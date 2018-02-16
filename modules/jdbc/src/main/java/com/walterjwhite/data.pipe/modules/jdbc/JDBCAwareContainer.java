package com.walterjwhite.data.pipe.modules.jdbc;

import com.walterjwhite.data.pipe.modules.jdbc.api.model.JDBCConfiguration;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCAwareContainer implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(JDBCAwareContainer.class);

  protected Connection connection;
  protected PreparedStatement preparedStatement;

  public JDBCAwareContainer(JDBCConfiguration jdbcConfiguration) {
    this(jdbcConfiguration, true);
  }

  public JDBCAwareContainer(JDBCConfiguration jdbcConfiguration, final boolean autoCommit) {
    try {
      URLClassLoader urlClassLoader =
          new URLClassLoader(
              new URL[] {new File(jdbcConfiguration.getDriverPath()).toURI().toURL()},
              getClass().getClassLoader());
      final Driver driver =
          (Driver)
              Class.forName(jdbcConfiguration.getDriverClassName(), true, urlClassLoader)
                  .newInstance();

      DriverManager.registerDriver(new DriverShim(driver));
      this.connection = JDBCConnectionProvider.get(jdbcConfiguration);
      this.preparedStatement = connection.prepareStatement(jdbcConfiguration.getQuery());

      setQueryParameters(jdbcConfiguration);
    } catch (Exception e) {
      throw (new RuntimeException("Error configuring", e));
    }
  }

  protected void setQueryParameters(JDBCConfiguration jdbcConfiguration) throws SQLException {
    if (jdbcConfiguration.getQueryParameters() != null
        && jdbcConfiguration.getQueryParameters().length > 0) {
      for (int i = 0; i < jdbcConfiguration.getQueryParameters().length; i++) {
        final Object argument = jdbcConfiguration.getQueryParameters()[i];

        if (argument == null) this.preparedStatement.setObject(i + 1, null);
        else if (argument instanceof String)
          this.preparedStatement.setString(i + 1, (String) argument);
        else if (argument instanceof Integer)
          this.preparedStatement.setInt(i + 1, (Integer) argument);
        else if (argument instanceof Double)
          this.preparedStatement.setDouble(i + 1, (Double) argument);
        //        else if(argument instanceof LocalDate)
        //          this.preparedStatement.setDate(i + 1, ((LocalDate)argument).);
        else throw (new IllegalArgumentException(argument.getClass() + " is unsupported"));
      }
    }
  }

  @Override
  public void close() throws Exception {
    closePreparedStatement();
    closeConnection();
  }

  protected void closePreparedStatement() {
    if (preparedStatement != null) {
      try {
        preparedStatement.close();
      } catch (Exception e) {
        LOGGER.warn("error closing preparedStatement.", e);
      }
    }
  }

  protected void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      LOGGER.warn("Unable to close connection");
    }
  }

  public PreparedStatement getPreparedStatement() {
    return (preparedStatement);
  }

  public Connection getConnection() {
    return (connection);
  }
}
