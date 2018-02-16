package com.walterjwhite.data.pipe.modules.shell.api.model;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.modules.shell.EventBusSource;

public class EventBusSourceConfiguration extends AbstractSourceConfiguration {
  protected EventBusConfiguration eventBusConfiguration;

  public EventBusSourceConfiguration() {
    super(EventBusSource.class);
  }

  public EventBusConfiguration getEventBusConfiguration() {
    return eventBusConfiguration;
  }

  public void setEventBusConfiguration(EventBusConfiguration eventBusConfiguration) {
    this.eventBusConfiguration = eventBusConfiguration;
  }
}
