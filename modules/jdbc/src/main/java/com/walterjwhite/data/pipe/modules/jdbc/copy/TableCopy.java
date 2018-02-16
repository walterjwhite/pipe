package com.walterjwhite.data.pipe.modules.jdbc.copy;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;

public class TableCopy extends AbstractNamedEntity {
  protected DatabaseCopySession databaseCopySession;

  public TableCopy(String name, String description, DatabaseCopySession databaseCopySession) {
    super(name, description);
    this.databaseCopySession = databaseCopySession;
  }

  public TableCopy() {
    super();
  }

  public DatabaseCopySession getDatabaseCopySession() {
    return databaseCopySession;
  }

  public void setDatabaseCopySession(DatabaseCopySession databaseCopySession) {
    this.databaseCopySession = databaseCopySession;
  }
}
