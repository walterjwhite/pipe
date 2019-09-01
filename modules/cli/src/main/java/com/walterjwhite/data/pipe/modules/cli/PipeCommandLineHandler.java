package com.walterjwhite.data.pipe.modules.cli;

import com.walterjwhite.data.pipe.api.session.PipeSessionConfiguration;
import com.walterjwhite.inject.cli.service.AbstractCommandLineHandler;
import com.walterjwhite.serialization.modules.snakeyaml.SnakeyamlSerializationService;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

public class PipeCommandLineHandler extends AbstractCommandLineHandler {
  protected final SnakeyamlSerializationService serializationService;

  protected Set<PipeSessionInstance> pipeSessionInstances = new HashSet<>();

  public PipeCommandLineHandler(
      int shutdownTimeoutInSeconds, SnakeyamlSerializationService serializationService) {
    super(shutdownTimeoutInSeconds);
    this.serializationService = serializationService;
  }

  @Override
  protected void doRun(String... arguments) throws Exception {
    for (final String argument : arguments) {
      PipeSessionConfiguration pipeSessionConfiguration =
          (PipeSessionConfiguration)
              serializationService.deserialize(
                  new BufferedInputStream(new FileInputStream(argument)),
                  PipeSessionConfiguration.class);
      final PipeSessionInstance pipeSessionInstance =
          new PipeSessionInstance(pipeSessionConfiguration);
      pipeSessionInstances.add(pipeSessionInstance);
      pipeSessionInstance.configure();
      pipeSessionInstance.start();
    }
  }

  @Override
  public void interrupt() {
    for (final PipeSessionInstance pipeSessionInstance : pipeSessionInstances)
      pipeSessionInstance.stop();

    super.interrupt();
  }
}
