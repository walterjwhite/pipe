package com.walterjwhite.data.pipe.modules.csv.model;

/** Configuration required to read/write to/from CSV files. */
public class CSVConfiguration {
  protected String filename;
  protected String[] headers;

  public CSVConfiguration(String filename, String... headers) {
    super();
    this.filename = filename;
    this.headers = headers;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String[] getHeaders() {
    return headers;
  }

  public void setHeaders(String[] headers) {
    this.headers = headers;
  }
}
