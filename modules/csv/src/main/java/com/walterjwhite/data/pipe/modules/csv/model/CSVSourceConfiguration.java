package com.walterjwhite.data.pipe.modules.csv.model;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.modules.csv.service.CSVSource;

public class CSVSourceConfiguration extends AbstractSourceConfiguration {
  protected CSVConfiguration csvConfiguration;

  public CSVSourceConfiguration(CSVConfiguration csvConfiguration) {
    super(CSVSource.class);
    this.csvConfiguration = csvConfiguration;
  }

  public CSVConfiguration getCsvConfiguration() {
    return csvConfiguration;
  }

  public void setCsvConfiguration(CSVConfiguration csvConfiguration) {
    this.csvConfiguration = csvConfiguration;
  }
}
