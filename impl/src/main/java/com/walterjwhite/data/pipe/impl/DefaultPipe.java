package com.walterjwhite.data.pipe.impl;

import com.walterjwhite.data.pipe.api.*;
import com.walterjwhite.data.pipe.api.session.PipeSessionConfiguration;
import com.walterjwhite.data.pipe.api.session.PipeSessionGroupConfiguration;
import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.api.source.Source;
import com.walterjwhite.google.guice.GuiceHelper;
import java.util.HashSet;
import java.util.Set;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPipe implements Pipe {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPipe.class);

  protected final DataPipeConfiguration dataPipeConfiguration;
  protected final PipeSessionGroupConfiguration pipeSessionGroupConfiguration;
  protected final PipeSessionConfiguration pipeSessionConfiguration;

  public DefaultPipe(
      DataPipeConfiguration dataPipeConfiguration,
      PipeSessionGroupConfiguration pipeSessionGroupConfiguration,
      PipeSessionConfiguration pipeSessionConfiguration) {
    this.dataPipeConfiguration = dataPipeConfiguration;
    this.pipeSessionGroupConfiguration = pipeSessionGroupConfiguration;
    this.pipeSessionConfiguration = pipeSessionConfiguration;
  }

  // TODO: initialize the pipe / stream
  // TODO: guice supports configuring the UnitOfWork, we can adjust that to commit the tx every 1000
  // rows / records / etc.
  //  @Transactional
  public void pipe(DataPipeConfiguration dataPipeConfiguration) throws Exception {
    final Set<Source> sources = new HashSet<>();
    final Set<Stream> streams = new HashSet<>();
    for (final AbstractSourceConfiguration sourceConfiguration :
        dataPipeConfiguration.getSourceConfigurations()) {
      Source source =
          GuiceHelper.getGuiceInjector().getInstance(sourceConfiguration.getSourceClass());
      source.configure(sourceConfiguration);
      sources.add(source);

      Stream stream =
          StreamSupport.stream(Spliterators.spliteratorUnknownSize(source.iterator(), 0), false);
      streams.add(stream);
    }

    DefaultTeeConsumer consumer =
        new DefaultTeeConsumer(dataPipeConfiguration.getSinkConfigurations());
    // Stream stream = Stream.of(sources);
    // Stream stream = Streams.stream(sources);
    //    Stream stream = Streams.concat();
    // Stream stream = streams.stream();
    DefaultFilterChain defaultFilterChain =
        new DefaultFilterChain(dataPipeConfiguration.getFilterConfigurations());
    DefaultTransformationChain defaultTransformationChain =
        new DefaultTransformationChain(dataPipeConfiguration.getTransformationConfigurations());
    try {
      for (final Stream stream : streams) {
        processStream(stream, defaultFilterChain, defaultTransformationChain, consumer);
      }
    } finally {
      consumer.close();
    }
  }

  protected void processStream(
      Stream stream,
      DefaultFilterChain defaultFilterChain,
      DefaultTransformationChain defaultTransformationChain,
      DefaultTeeConsumer consumer) {
    try {
      stream.filter(defaultFilterChain).map(defaultTransformationChain).forEach(consumer);
    } finally {
      stream.close();
    }
  }

  public void start() {}

  public void close() {}
}
