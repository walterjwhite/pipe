package com.walterjwhite.data.pipe.api.session;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @PersistenceCapable
@Entity
public class PipeSessionConfiguration extends AbstractNamedEntity {
  @OneToMany
  //    @JoinTable
  protected List<PipeSessionGroupConfiguration> groups = new ArrayList<>();

  public PipeSessionConfiguration(String name, List<PipeSessionGroupConfiguration> groups) {
    super(name);

    if (groups != null && !groups.isEmpty()) this.groups.addAll(groups);
  }

  public PipeSessionConfiguration(
      String name, String description, List<PipeSessionGroupConfiguration> groups) {
    super(name, description);
    if (groups != null && !groups.isEmpty()) this.groups.addAll(groups);
  }
}
