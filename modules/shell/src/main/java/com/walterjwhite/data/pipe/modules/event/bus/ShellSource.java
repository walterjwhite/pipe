package com.walterjwhite.data.pipe.modules.event.bus;

import com.walterjwhite.data.pipe.impl.AbstractSource;
import com.walterjwhite.data.pipe.impl.QueueIterator;
import com.walterjwhite.data.pipe.modules.event.bus.api.model.ShellSourceConfiguration;
import com.walterjwhite.shell.api.model.ShellCommand;
import com.walterjwhite.shell.api.service.ShellExecutionService;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import javax.inject.Inject;

/** TODO: 1. get the appropriate source connection here 2. get the appropriate source query here */
public class ShellSource extends AbstractSource<String, ShellSourceConfiguration> {
  protected final PriorityBlockingQueue queue = new PriorityBlockingQueue();
  protected final QueueIterator iterator = new QueueIterator(queue);

  protected final ShellExecutionService shellExecutionService;
  protected ShellCommand shellCommand;
  protected final ShellOutputCollector shellOutputCollector;

  @Inject
  public ShellSource(ShellExecutionService shellExecutionService) {
    super();
    this.shellExecutionService = shellExecutionService;
    shellOutputCollector = new ShellOutputCollector(queue);
  }

  @Override
  protected void doConfigure() {
    try {
      // TODO: should I re-add the collector here or further up the ladder?
      shellExecutionService.run(shellCommand /*, shellOutputCollector*/);
    } catch (Exception e) {
      throw new RuntimeException("error running command", e);
    }
  }

  public void close() throws Exception {
    // kill the process
  }

  @Override
  public Iterator<String> iterator() {
    return iterator;
  }
}
