package com.walterjwhite.data.pipe.modules.shell;

import com.walterjwhite.shell.api.service.OutputCollector;
import java.util.concurrent.PriorityBlockingQueue;

public class ShellOutputCollector implements OutputCollector {
  protected final PriorityBlockingQueue queue;

  public ShellOutputCollector(PriorityBlockingQueue queue) {
    super();
    this.queue = queue;
  }

  @Override
  public void onData(String line, boolean isError) {
    queue.put(line);
  }
}
