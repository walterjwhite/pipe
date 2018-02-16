package com.walterjwhite.data.pipe.modules.index;

import com.walterjwhite.datastore.api.model.entity.EntityType;
import com.walterjwhite.index.api.model.index.Index;

public class IndexConfiguration {
  protected Index index;
  protected EntityType entityType;

  public Index getIndex() {
    return index;
  }

  public void setIndex(Index index) {
    this.index = index;
  }

  public EntityType getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }
}
