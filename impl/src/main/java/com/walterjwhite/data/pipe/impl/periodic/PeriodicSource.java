package com.walterjwhite.data.pipe.impl.periodic;

import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.walterjwhite.data.pipe.api.source.Source;
import com.walterjwhite.data.pipe.impl.AbstractSource;
import com.walterjwhite.data.pipe.impl.QueueIterator;
import com.walterjwhite.infrastructure.inject.core.helper.ApplicationHelper;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/** For sources that return output once, we must execute them multiple times to produce output. */
public class PeriodicSource<SourceRecordType extends Serializable>
    extends AbstractSource<PeriodicRecord<SourceRecordType>, PeriodicSourceConfiguration>
    implements Runnable {
  protected final PriorityBlockingQueue<PeriodicRecord<SourceRecordType>> queue =
      new PriorityBlockingQueue<>();
  protected final QueueIterator iterator;
  protected final ListeningScheduledExecutorService executorService;
  // TODO: support killing after running a finite number of operations
  protected ListenableScheduledFuture future;
  protected Source source;

  //  @Inject
  protected PeriodicSource(ListeningScheduledExecutorService executorService) {
    this.executorService = executorService;
    iterator = new QueueIterator(queue);
  }

  @Override
  public Iterator<PeriodicRecord<SourceRecordType>> iterator() {
    return iterator;
  }

  /**
   * Collect all of the results
   *
   * @return the results from the current execution.
   */
  protected List<SourceRecordType> doRunOnce() {
    List<SourceRecordType> data = new ArrayList<>();

    final Iterator<SourceRecordType> sourceIterator = source.iterator();
    while (sourceIterator.hasNext()) data.add(sourceIterator.next());

    return data;
  }

  @Override
  protected void doConfigure() {
    source =
        ApplicationHelper.getApplicationInstance()
            .getInjector()
            .getInstance(sourceConfiguration.getSourceConfiguration().getSourceClass());

    future =
        executorService.scheduleWithFixedDelay(
            this, 0, sourceConfiguration.getInterval(), sourceConfiguration.getTimeUnit());
  }

  @Override
  public void close() throws Exception {
    future.cancel(true);
  }

  @Override
  public void run() {
    queue.put(new PeriodicRecord(LocalDateTime.now(), doRunOnce()));
  }
}
