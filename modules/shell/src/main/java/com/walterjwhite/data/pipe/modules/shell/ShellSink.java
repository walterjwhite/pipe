package com.walterjwhite.data.pipe.modules.shell;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.data.pipe.modules.shell.api.model.ShellSinkConfiguration;
import com.walterjwhite.shell.api.model.ShellCommand;
import com.walterjwhite.shell.api.service.ShellExecutionService;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShellSink extends AbstractSink<String, ShellSinkConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ShellSink.class);

  protected final ShellExecutionService shellExecutionService;

  @Inject
  public ShellSink(ShellExecutionService shellExecutionService) {
    super();
    this.shellExecutionService = shellExecutionService;
  }

  @Override
  protected void doConfigure() {}

  @Override
  public void accept(String record) {
    try {
      shellExecutionService.run(new ShellCommand().withCommandLine(record));
    } catch (Exception e) {
      throw (new RuntimeException("Error running command", e));
    }
  }

  public void close() {
    // shellExecutionService.kill(shellCommand);
  }
}
