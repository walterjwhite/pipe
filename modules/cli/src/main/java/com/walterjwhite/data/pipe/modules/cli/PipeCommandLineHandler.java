package com.walterjwhite.data.pipe.modules.cli;

import com.walterjwhite.data.pipe.api.session.PipeSessionConfiguration;
import com.walterjwhite.google.guice.cli.service.AbstractCommandLineHandler;
import com.walterjwhite.serialization.modules.snakeyaml.SnakeyamlSerializationService;
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
  public void run(String... arguments) throws Exception {
    for (final String argument : arguments) {
      PipeSessionConfiguration pipeSessionConfiguration =
          (PipeSessionConfiguration)
              serializationService.deserialize(
                  new FileInputStream(argument), PipeSessionConfiguration.class);
      final PipeSessionInstance pipeSessionInstance =
          new PipeSessionInstance(pipeSessionConfiguration);
      pipeSessionInstances.add(pipeSessionInstance);
      pipeSessionInstance.configure();
      pipeSessionInstance.start();
    }
  }

  @Override
  protected void onShutdown() throws Exception {
    for (final PipeSessionInstance pipeSessionInstance : pipeSessionInstances)
      pipeSessionInstance.stop();

    super.onShutdown();
  }
}
