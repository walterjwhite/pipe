package com.walterjwhite.data.pipe.modules.jdbc.api.model;

public class JDBCConfiguration {
  protected String queryFilename;
  protected String query;
  protected Object[] queryParameters;
  protected String username;
  protected String password;

  protected String jdbcUrl;
  protected String driverClassName;
  protected String driverPath;

  public String getDriverPath() {
    return driverPath;
  }

  public void setDriverPath(String driverPath) {
    this.driverPath = driverPath;
  }

  public String getQueryFilename() {
    return queryFilename;
  }

  public void setQueryFilename(String queryFilename) {
    this.queryFilename = queryFilename;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Object[] getQueryParameters() {
    return queryParameters;
  }

  public void setQueryParameters(Object[] queryParameters) {
    this.queryParameters = queryParameters;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public void setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }
}
