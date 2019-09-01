package com.walterjwhite.data.pipe.modules.jdbc;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.data.pipe.modules.jdbc.api.model.JDBCSinkConfiguration;
import java.sql.SQLException;

public class JDBCSink extends AbstractSink<Object[], JDBCSinkConfiguration> {
  protected PreparedStatementJDBCAwareContainer preparedStatementJDBCAwareContainer;
  protected int recordsProcessed = 0;

  @Override
  protected void doConfigure() {
    preparedStatementJDBCAwareContainer =
        new PreparedStatementJDBCAwareContainer(
            sinkConfiguration.getJdbcQueryConfiguration(),
            sinkConfiguration.getRecordsPerUnitOfWork() > 0);
  }

  @Override
  public void accept(Object[] record) {
    try {
      for (int i = 0; i < record.length; i++) {
        if (String.class.isInstance(record[i]))
          preparedStatementJDBCAwareContainer
              .getPreparedStatement()
              .setString(i, (String) record[i]);
        if (Integer.class.isInstance(record[i]))
          preparedStatementJDBCAwareContainer.getPreparedStatement().setInt(i, (Integer) record[i]);
        if (Double.class.isInstance(record[i]))
          preparedStatementJDBCAwareContainer
              .getPreparedStatement()
              .setDouble(i, (Double) record[i]);
        else throw (new IllegalArgumentException("unsupported type"));
      }
    } catch (SQLException e) {
      // LOGGER.warn("Error setting value", e);
      throw new RuntimeException("Error setting value", e);
    }

    recordsProcessed++;

    if (recordsProcessed > sinkConfiguration.getRecordsPerUnitOfWork()) {
      recordsProcessed = 0;
      try {
        preparedStatementJDBCAwareContainer.getConnection().commit();
      } catch (SQLException e) {
        // LOGGER.warn("Error commiting tx", e);
        throw new RuntimeException("Error committing tx", e);
      }
    }
  }

  public void close() throws SQLException {
    try {
      preparedStatementJDBCAwareContainer.getConnection().commit();
    } catch (SQLException e) {
      throw new RuntimeException("Error committing tx", e);
    }

    preparedStatementJDBCAwareContainer.getPreparedStatement().close();
    preparedStatementJDBCAwareContainer.getConnection().close();
  }
}
