package com.walterjwhite.data.pipe.modules.index;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.index.api.model.index.IndexableRecord;
import com.walterjwhite.index.api.service.IndexService;
import javax.inject.Inject;

/** Takes an entity / record and merely pushes it to an indexing service (such as elasticsearch). */
public class IndexSink extends AbstractSink<IndexableRecord, IndexSinkConfiguration> {
  protected final IndexService indexService;

  @Inject
  public IndexSink(IndexService indexService) {
    super();
    this.indexService = indexService;
  }

  @Override
  public void close() {}

  @Override
  public void accept(IndexableRecord indexableRecord) {
    try {
      indexService.index(indexableRecord);
    } catch (Exception e) {
      throw (new RuntimeException("Error indexing data", e));
    }
  }

  @Override
  protected void doConfigure() {}
}
