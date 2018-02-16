package com.walterjwhite.data.pipe.modules.jdbc.api.model;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.modules.jdbc.JDBCSink;

public class JDBCSinkConfiguration extends AbstractSinkConfiguration {
  protected JDBCConfiguration jdbcConfiguration;

  protected int recordsPerUnitOfWork = -1;
  protected boolean createTables = false;

  public JDBCSinkConfiguration() {
    super(JDBCSink.class);
  }

  public JDBCConfiguration getJdbcConfiguration() {
    return jdbcConfiguration;
  }

  public void setJdbcConfiguration(JDBCConfiguration jdbcConfiguration) {
    this.jdbcConfiguration = jdbcConfiguration;
  }

  public int getRecordsPerUnitOfWork() {
    return recordsPerUnitOfWork;
  }

  public void setRecordsPerUnitOfWork(int recordsPerUnitOfWork) {
    this.recordsPerUnitOfWork = recordsPerUnitOfWork;
  }

  public boolean isCreateTables() {
    return createTables;
  }

  public void setCreateTables(boolean createTables) {
    this.createTables = createTables;
  }
}
