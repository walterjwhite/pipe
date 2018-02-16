package com.walterjwhite.data.pipe.modules.shell.api.model;

public class SystemConfiguration {
  protected boolean error;

  public SystemConfiguration(boolean error) {
    super();
    this.error = error;
  }

  public SystemConfiguration() {
    this(false);
  }

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }
}
