package com.walterjwhite.data.pipe.modules.shell;

import com.google.inject.AbstractModule;
import com.walterjwhite.data.pipe.impl.DataPipeModule;
import com.walterjwhite.shell.impl.ShellModule;

public class ShellDataPipeModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(ShellSource.class);
    bind(SystemSink.class);

    install(new ShellModule());
    install(new DataPipeModule());
  }
}
