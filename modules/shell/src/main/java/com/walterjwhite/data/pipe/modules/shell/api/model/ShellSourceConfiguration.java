package com.walterjwhite.data.pipe.modules.shell.api.model;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.modules.shell.ShellSource;
import com.walterjwhite.shell.api.model.ShellCommand;

public class ShellSourceConfiguration extends AbstractSourceConfiguration {
  protected ShellCommand shellCommand;

  public ShellSourceConfiguration(ShellCommand shellCommand) {
    this();
    this.shellCommand = shellCommand;
  }

  public ShellSourceConfiguration() {
    super(ShellSource.class);
  }

  public ShellCommand getShellCommand() {
    return shellCommand;
  }

  public void setShellCommand(ShellCommand shellCommand) {
    this.shellCommand = shellCommand;
  }
}
