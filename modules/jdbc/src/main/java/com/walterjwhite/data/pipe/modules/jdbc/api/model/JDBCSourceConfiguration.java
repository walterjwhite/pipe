package com.walterjwhite.data.pipe.modules.jdbc.api.model;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.modules.jdbc.JDBCSource;

public class JDBCSourceConfiguration extends AbstractSourceConfiguration {
  protected JDBCConfiguration jdbcConfiguration;

  public JDBCSourceConfiguration() {
    super(JDBCSource.class);
  }

  public JDBCConfiguration getJdbcConfiguration() {
    return jdbcConfiguration;
  }

  public void setJdbcConfiguration(JDBCConfiguration jdbcConfiguration) {
    this.jdbcConfiguration = jdbcConfiguration;
  }
}
