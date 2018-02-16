package com.walterjwhite.data.pipe.impl.periodic;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import java.util.concurrent.TimeUnit;

public class PeriodicSourceConfiguration extends AbstractSourceConfiguration {
  protected long interval;
  protected TimeUnit timeUnit;
  protected long shutdownTimeout = 5;
  protected AbstractSourceConfiguration sourceConfiguration;

  public PeriodicSourceConfiguration(
      long interval,
      TimeUnit timeUnit,
      long shutdownTimeout,
      AbstractSourceConfiguration sourceConfiguration) {
    super(PeriodicSource.class);
    this.interval = interval;
    this.timeUnit = timeUnit;
    this.shutdownTimeout = shutdownTimeout;
    this.sourceConfiguration = sourceConfiguration;
  }

  public PeriodicSourceConfiguration() {
    super(PeriodicSource.class);
  }

  public long getInterval() {
    return interval;
  }

  public void setInterval(long interval) {
    this.interval = interval;
  }

  public TimeUnit getTimeUnit() {
    return timeUnit;
  }

  public void setTimeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
  }

  public long getShutdownTimeout() {
    return shutdownTimeout;
  }

  public void setShutdownTimeout(long shutdownTimeout) {
    this.shutdownTimeout = shutdownTimeout;
  }

  public AbstractSourceConfiguration getSourceConfiguration() {
    return sourceConfiguration;
  }

  public void setSourceConfiguration(AbstractSourceConfiguration sourceConfiguration) {
    this.sourceConfiguration = sourceConfiguration;
  }
}
