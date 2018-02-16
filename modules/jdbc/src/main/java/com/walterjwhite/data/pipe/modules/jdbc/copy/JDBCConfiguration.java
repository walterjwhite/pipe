package com.walterjwhite.data.pipe.modules.jdbc.copy;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import java.util.HashMap;
import java.util.Map;

public class JDBCConfiguration extends AbstractNamedEntity {
  protected String username;
  protected String password;

  protected String uri;
  protected String driverClassName;
  protected Map<String, String> properties = new HashMap<>();

  public JDBCConfiguration(
      String name,
      String description,
      String username,
      String password,
      String uri,
      String driverClassName) {
    super(name, description);
    this.username = username;
    this.password = password;
    this.uri = uri;
    this.driverClassName = driverClassName;
  }

  public JDBCConfiguration() {
    super();
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

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }
}
