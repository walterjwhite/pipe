package com.walterjwhite.data.pipe.modules.jdbc;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.data.pipe.modules.jdbc.api.model.JDBCSinkConfiguration;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCSink extends AbstractSink<Object[], JDBCSinkConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(JDBCSink.class);

  protected JDBCAwareContainer jdbcAwareContainer;
  protected int recordsProcessed = 0;

  @Override
  protected void doConfigure() {
    jdbcAwareContainer =
        new JDBCAwareContainer(
            sinkConfiguration.getJdbcConfiguration(),
            sinkConfiguration.getRecordsPerUnitOfWork() > 0);
  }

  @Override
  public void accept(Object[] record) {
    try {
      for (int i = 0; i < record.length; i++) {
        if (String.class.isInstance(record[i]))
          jdbcAwareContainer.getPreparedStatement().setString(i, (String) record[i]);
        if (Integer.class.isInstance(record[i]))
          jdbcAwareContainer.getPreparedStatement().setInt(i, (Integer) record[i]);
        if (Double.class.isInstance(record[i]))
          jdbcAwareContainer.getPreparedStatement().setDouble(i, (Double) record[i]);
        else throw (new IllegalArgumentException("unsupported type"));
      }
    } catch (SQLException e) {
      LOGGER.warn("Error setting value", e);
    }

    recordsProcessed++;

    if (recordsProcessed > sinkConfiguration.getRecordsPerUnitOfWork()) {
      recordsProcessed = 0;
      try {
        jdbcAwareContainer.getConnection().commit();
      } catch (SQLException e) {
        LOGGER.warn("Error commiting tx", e);
      }
    }
  }

  public void close() {
    try {
      jdbcAwareContainer.getConnection().commit();
    } catch (SQLException e) {
      LOGGER.warn("Error commiting tx", e);
    }

    try {
      jdbcAwareContainer.getPreparedStatement().close();
    } catch (SQLException e) {
      LOGGER.warn("Error closing preparedStatement", e);
    }

    try {
      jdbcAwareContainer.getConnection().close();
    } catch (SQLException e) {
      LOGGER.warn("Error closing connection", e);
    }
  }
}
