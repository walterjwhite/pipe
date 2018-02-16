package com.walterjwhite.data.pipe.modules.cli;

import com.walterjwhite.google.guice.cli.property.OperatingMode;
import com.walterjwhite.google.guice.cli.service.AbstractCommandLineHandler;
import com.walterjwhite.google.guice.property.property.DefaultValue;

public enum PipeOperatingMode implements OperatingMode {
  @DefaultValue
  Daemon("Connect sources with sinks and run until killed", PipeCommandLineHandler.class);

  private final String description;
  private final Class<? extends AbstractCommandLineHandler> commandLineHandlerClass;

  PipeOperatingMode(
      String description, Class<? extends AbstractCommandLineHandler> commandLineHandlerClass) {
    this.description = description;
    this.commandLineHandlerClass = commandLineHandlerClass;
  }

  @Override
  public Class<? extends AbstractCommandLineHandler> getInitiatorClass() {
    return commandLineHandlerClass;
  }
}
