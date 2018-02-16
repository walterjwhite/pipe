package com.walterjwhite.data.pipe.modules.shell;

import com.google.common.eventbus.Subscribe;
import com.walterjwhite.data.pipe.impl.AbstractSource;
import com.walterjwhite.data.pipe.impl.QueueIterator;
import com.walterjwhite.data.pipe.modules.shell.api.model.EventBusSourceConfiguration;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** TODO: 1. get the appropriate source connection here 2. get the appropriate source query here */
public class EventBusSource extends AbstractSource<Serializable, EventBusSourceConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(EventBusSource.class);

  protected final PriorityBlockingQueue queue = new PriorityBlockingQueue();

  protected final QueueIterator iterator = new QueueIterator(queue);

  @Override
  protected void doConfigure() {}

  public void close() throws Exception {}

  @Subscribe
  public void onMessage(Serializable data) throws InterruptedException {
    queue.put(data);
  }

  @Override
  public Iterator<Serializable> iterator() {
    return iterator;
  }
}
