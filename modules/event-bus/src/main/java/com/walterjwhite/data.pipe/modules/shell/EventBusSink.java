package com.walterjwhite.data.pipe.modules.shell;

import com.google.common.eventbus.EventBus;
import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.data.pipe.modules.shell.api.model.EventBusSinkConfiguration;
import java.io.Serializable;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBusSink extends AbstractSink<Serializable, EventBusSinkConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(EventBusSink.class);

  protected final EventBus eventBus;

  @Inject
  public EventBusSink(EventBus eventBus) {
    super();
    this.eventBus = eventBus;
  }

  @Override
  protected void doConfigure() {}

  @Override
  public void accept(Serializable record) {
    eventBus.post(record);
  }

  public void close() {}
}
