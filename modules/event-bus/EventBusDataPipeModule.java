package com.walterjwhite.data.pipe.modules.event.bus;

import com.google.inject.AbstractModule;
import com.walterjwhite.google.guice.GuavaEventBusModule;

public class EventBusDataPipeModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new GuavaEventBusModule());
  }
}
