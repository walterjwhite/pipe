package com.walterjwhite.data.pipe.modules.shell.api.model;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.modules.shell.EventBusSink;

public class EventBusSinkConfiguration extends AbstractSinkConfiguration {
  protected EventBusConfiguration eventBusConfiguration;

  public EventBusSinkConfiguration() {
    super(EventBusSink.class);
  }

  public EventBusConfiguration getEventBusConfiguration() {
    return eventBusConfiguration;
  }

  public void setEventBusConfiguration(EventBusConfiguration eventBusConfiguration) {
    this.eventBusConfiguration = eventBusConfiguration;
  }
}
