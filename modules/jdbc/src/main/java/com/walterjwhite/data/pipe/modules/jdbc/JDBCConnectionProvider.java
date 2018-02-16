package com.walterjwhite.data.pipe.modules.jdbc;

import com.walterjwhite.data.pipe.modules.jdbc.api.model.JDBCConfiguration;
import java.sql.Connection;

public class JDBCConnectionProvider {
  public static Connection get(JDBCConfiguration jdbcConfiguration) {
    jdbcConfiguration.getDriverClassName();
    jdbcConfiguration.getJdbcUrl();
    jdbcConfiguration.getUsername();
    jdbcConfiguration.getPassword();
    return null;
  }
}
