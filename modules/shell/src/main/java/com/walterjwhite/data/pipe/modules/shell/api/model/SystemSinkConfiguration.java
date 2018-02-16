package com.walterjwhite.data.pipe.modules.shell.api.model;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.modules.shell.SystemSink;

public class SystemSinkConfiguration extends AbstractSinkConfiguration {
  protected final boolean error;

  public SystemSinkConfiguration(boolean error) {
    super(SystemSink.class);
    this.error = error;
  }

  public boolean isError() {
    return error;
  }
}
