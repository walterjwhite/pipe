package com.walterjwhite.data.pipe.modules.shell.api.model;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.modules.shell.ShellSink;
import com.walterjwhite.shell.api.model.ShellCommand;

public class ShellSinkConfiguration extends AbstractSinkConfiguration {
  protected ShellCommand shellCommand;

  public ShellSinkConfiguration(ShellCommand shellCommand) {
    this();
    this.shellCommand = shellCommand;
  }

  public ShellSinkConfiguration() {
    super(ShellSink.class);
  }

  public ShellCommand getShellCommand() {
    return shellCommand;
  }

  public void setShellCommand(ShellCommand shellCommand) {
    this.shellCommand = shellCommand;
  }
}
