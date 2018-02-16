package com.walterjwhite.data.pipe.modules.index;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;

public class IndexSourceConfiguration extends AbstractSourceConfiguration {
  protected IndexConfiguration indexConfiguration;

  public IndexSourceConfiguration() {
    super(IndexSource.class);
  }

  public IndexConfiguration getIndexConfiguration() {
    return indexConfiguration;
  }

  public void setIndexConfiguration(IndexConfiguration indexConfiguration) {
    this.indexConfiguration = indexConfiguration;
  }
}
