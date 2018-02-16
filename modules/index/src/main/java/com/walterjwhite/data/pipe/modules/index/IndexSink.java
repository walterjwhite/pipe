package com.walterjwhite.data.pipe.modules.index;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.index.api.model.index.IndexableRecord;
import com.walterjwhite.index.api.service.IndexService;
import java.sql.SQLException;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Takes an entity / record and merely pushes it to an indexing service (such as elasticsearch). */
public class IndexSink extends AbstractSink<IndexableRecord, IndexSinkConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexSink.class);

  protected final IndexService indexService;

  @Inject
  public IndexSink(IndexService indexService) throws SQLException {
    super();
    this.indexService = indexService;
  }

  @Override
  public void close() throws Exception {}

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
