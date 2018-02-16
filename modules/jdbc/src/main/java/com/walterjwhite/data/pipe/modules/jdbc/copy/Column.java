package com.walterjwhite.data.pipe.modules.jdbc.copy;

import com.walterjwhite.datastore.api.model.entity.AbstractEntity;
import java.sql.JDBCType;

public class Column extends AbstractEntity {
  protected String name;
  protected JDBCType type;
  protected int size;
  protected int decimalDigits;
  protected boolean nullable;
  protected boolean autoIncrement;

  public Column(
      String name,
      JDBCType type,
      int size,
      int decimalDigits,
      boolean nullable,
      boolean autoIncrement) {
    super();

    this.name = name;
    this.type = type;
    this.size = size;
    this.decimalDigits = decimalDigits;
    this.nullable = nullable;
    this.autoIncrement = autoIncrement;
  }

  public Column() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JDBCType getType() {
    return type;
  }

  public void setType(JDBCType type) {
    this.type = type;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getDecimalDigits() {
    return decimalDigits;
  }

  public void setDecimalDigits(int decimalDigits) {
    this.decimalDigits = decimalDigits;
  }

  public boolean isNullable() {
    return nullable;
  }

  public void setNullable(boolean nullable) {
    this.nullable = nullable;
  }

  public boolean isAutoIncrement() {
    return autoIncrement;
  }

  public void setAutoIncrement(boolean autoIncrement) {
    this.autoIncrement = autoIncrement;
  }
}
