package com.walterjwhite.data.pipe.modules.csv;

import com.google.inject.AbstractModule;
import com.walterjwhite.data.pipe.api.sink.Sink;
import com.walterjwhite.data.pipe.api.source.Source;
import com.walterjwhite.data.pipe.modules.csv.service.CSVSink;
import com.walterjwhite.data.pipe.modules.csv.service.CSVSource;

public class CSVDataPipeModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Source.class).to(CSVSource.class);
    bind(Sink.class).to(CSVSink.class);
  }
}
