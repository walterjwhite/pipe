package com.walterjwhite.vaadin.data.pipe;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import java.util.Arrays;
import java.util.Objects;

public class VaadinDataSinkConfiguration extends AbstractSinkConfiguration {
  protected int maxRows;
  protected String dataClassName;

  protected String title;
  protected String description;
  protected String[] columnNames;

  public VaadinDataSinkConfiguration(
      int maxRows,
      String dataClassName,
      String gridColumnResolverClassName,
      String title,
      String description,
      final String... columnNames) {
    super(VaadinDataSink.class);
    this.maxRows = maxRows;
    this.dataClassName = dataClassName;
    this.columnNames = columnNames;
    this.title = title;
    this.description = description;
  }

  public VaadinDataSinkConfiguration() {
    super(VaadinDataSink.class);
  }

  public int getMaxRows() {
    return maxRows;
  }

  public void setMaxRows(int maxRows) {
    this.maxRows = maxRows;
  }

  public String getDataClassName() {
    return dataClassName;
  }

  public void setDataClassName(String dataClassName) {
    this.dataClassName = dataClassName;
  }

  public String[] getColumnNames() {
    return columnNames;
  }

  public void setColumnNames(String[] columnNames) {
    this.columnNames = columnNames;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VaadinDataSinkConfiguration that = (VaadinDataSinkConfiguration) o;
    return maxRows == that.maxRows
        && Objects.equals(dataClassName, that.dataClassName)
        && Objects.equals(title, that.title)
        && Arrays.equals(columnNames, that.columnNames);
  }

  @Override
  public int hashCode() {

    int result = Objects.hash(maxRows, dataClassName, title);
    result = 31 * result + Arrays.hashCode(columnNames);
    return result;
  }
}
