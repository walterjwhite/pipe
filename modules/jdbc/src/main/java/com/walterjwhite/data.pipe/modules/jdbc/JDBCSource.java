package com.walterjwhite.data.pipe.modules.jdbc;

import com.walterjwhite.data.pipe.impl.AbstractSource;
import com.walterjwhite.data.pipe.modules.jdbc.api.model.JDBCSourceConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** TODO: 1. get the appropriate source connection here 2. get the appropriate source query here */
public class JDBCSource extends AbstractSource<Object[], JDBCSourceConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(JDBCSource.class);
  protected JDBCAwareContainer jdbcAwareContainer;
  protected ResultSet resultSet;

  @Override
  protected void doConfigure() {
    jdbcAwareContainer = new JDBCAwareContainer(sourceConfiguration.getJdbcConfiguration());
    try {
      resultSet = jdbcAwareContainer.getPreparedStatement().executeQuery();
    } catch (SQLException e) {
      throw (new RuntimeException("Error preparing resultset", e));
    }
  }

  public void close() throws Exception {
    closeResultSet();
    jdbcAwareContainer.close();
  }

  protected void closeResultSet() {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (Exception e) {
        LOGGER.warn("error closing resultset.", e);
      }
    }
  }

  @Override
  public Iterator<Object[]> iterator() {
    try {
      return new JDBCIterator(jdbcAwareContainer.getConnection(), sourceConfiguration);
    } catch (SQLException e) {
      throw (new RuntimeException("Error initializing iterator", e));
    }
  }
}
