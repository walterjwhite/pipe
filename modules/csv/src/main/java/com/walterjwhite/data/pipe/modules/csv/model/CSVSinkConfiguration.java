package com.walterjwhite.data.pipe.modules.csv.model;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.modules.csv.service.CSVSink;

public class CSVSinkConfiguration extends AbstractSinkConfiguration {
  protected CSVConfiguration csvConfiguration;

  public CSVSinkConfiguration(CSVConfiguration csvConfiguration) {
    super(CSVSink.class);
    this.csvConfiguration = csvConfiguration;
  }

  public CSVConfiguration getCsvConfiguration() {
    return csvConfiguration;
  }

  public void setCsvConfiguration(CSVConfiguration csvConfiguration) {
    this.csvConfiguration = csvConfiguration;
  }
}
