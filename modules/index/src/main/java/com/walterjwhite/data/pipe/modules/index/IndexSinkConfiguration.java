package com.walterjwhite.data.pipe.modules.index;

import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;

public class IndexSinkConfiguration extends AbstractSinkConfiguration {
  protected IndexConfiguration indexConfiguration;

  public IndexSinkConfiguration() {
    super(IndexSink.class);
  }

  public IndexConfiguration getIndexConfiguration() {
    return indexConfiguration;
  }

  public void setIndexConfiguration(IndexConfiguration indexConfiguration) {
    this.indexConfiguration = indexConfiguration;
  }
}
