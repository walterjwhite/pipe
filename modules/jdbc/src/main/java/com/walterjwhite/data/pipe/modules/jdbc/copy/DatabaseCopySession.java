package com.walterjwhite.data.pipe.modules.jdbc.copy;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCopySession extends AbstractNamedEntity {

  protected JDBCConfiguration sourceConfiguration;
  protected JDBCConfiguration targetConfiguration;

  protected boolean nop;

  protected LocalDateTime startDateTime;
  protected LocalDateTime endDateTime;

  protected List<String> tableNames = new ArrayList<>();

  public DatabaseCopySession(
      String name,
      String description,
      JDBCConfiguration sourceConfiguration,
      JDBCConfiguration targetConfiguration,
      boolean nop,
      LocalDateTime startDateTime,
      LocalDateTime endDateTime) {
    super(name, description);
    this.sourceConfiguration = sourceConfiguration;
    this.targetConfiguration = targetConfiguration;
    this.nop = nop;
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
  }

  public DatabaseCopySession() {
    super();
  }

  public JDBCConfiguration getSourceConfiguration() {
    return sourceConfiguration;
  }

  public void setSourceConfiguration(JDBCConfiguration sourceConfiguration) {
    this.sourceConfiguration = sourceConfiguration;
  }

  public JDBCConfiguration getTargetConfiguration() {
    return targetConfiguration;
  }

  public void setTargetConfiguration(JDBCConfiguration targetConfiguration) {
    this.targetConfiguration = targetConfiguration;
  }

  public boolean isNop() {
    return nop;
  }

  public void setNop(boolean nop) {
    this.nop = nop;
  }

  public LocalDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(LocalDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public LocalDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(LocalDateTime endDateTime) {
    this.endDateTime = endDateTime;
  }

  public List<String> getTableNames() {
    return tableNames;
  }

  public void setTableNames(List<String> tableNames) {
    this.tableNames = tableNames;
  }
}
