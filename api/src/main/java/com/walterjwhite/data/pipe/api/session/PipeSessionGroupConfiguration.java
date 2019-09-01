package com.walterjwhite.data.pipe.api.session;

import com.walterjwhite.data.pipe.api.DataPipeConfiguration;
import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Similar pipes go together, for example, all of the Apache web server logs or all of the tomcat
 * logs, or database logs.
 */
@Getter
@Setter
// @PersistenceCapable
@NoArgsConstructor
@Entity
public class PipeSessionGroupConfiguration extends AbstractNamedEntity {
  @OneToMany
  // @JoinTable
  protected List<DataPipeConfiguration> dataPipeConfigurations = new ArrayList<>();

  public PipeSessionGroupConfiguration(
      String name, List<DataPipeConfiguration> dataPipeConfigurations) {
    super(name);
    this.dataPipeConfigurations = dataPipeConfigurations;
  }

  public PipeSessionGroupConfiguration(
      String name, String description, List<DataPipeConfiguration> dataPipeConfigurations) {
    super(name, description);
    this.dataPipeConfigurations = dataPipeConfigurations;
  }
}
