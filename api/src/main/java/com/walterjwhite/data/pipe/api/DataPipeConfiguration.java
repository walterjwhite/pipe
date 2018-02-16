package com.walterjwhite.data.pipe.api;

import com.walterjwhite.data.pipe.api.filter.AbstractFilterConfiguration;
import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;
import com.walterjwhite.data.pipe.api.source.AbstractSinkConfiguration;
import com.walterjwhite.data.pipe.api.transformation.AbstractTransformationConfiguration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataPipeConfiguration implements Serializable {
  protected Set<AbstractSourceConfiguration> sourceConfigurations = new HashSet<>();
  protected Set<AbstractSinkConfiguration> sinkConfigurations = new HashSet<>();
  protected List<AbstractTransformationConfiguration> transformationConfigurations =
      new ArrayList<>();
  protected Set<AbstractFilterConfiguration> filterConfigurations = new HashSet<>();

  protected Set<String> libraryPaths;

  public DataPipeConfiguration(
      Set<AbstractSourceConfiguration> sourceConfigurations,
      Set<AbstractSinkConfiguration> sinkConfigurations,
      List<AbstractTransformationConfiguration> transformationConfigurations,
      Set<AbstractFilterConfiguration> filterConfigurations,
      Set<String> libraryPaths) {
    super();
    this.sourceConfigurations = sourceConfigurations;
    this.sinkConfigurations = sinkConfigurations;
    this.transformationConfigurations = transformationConfigurations;
    this.filterConfigurations = filterConfigurations;
    this.libraryPaths = libraryPaths;
  }

  public DataPipeConfiguration(
      Set<AbstractSourceConfiguration> sourceConfigurations,
      Set<AbstractSinkConfiguration> sinkConfigurations) {
    super();
    this.sourceConfigurations = sourceConfigurations;
    this.sinkConfigurations = sinkConfigurations;
  }

  public DataPipeConfiguration(
      AbstractSourceConfiguration sourceConfiguration,
      AbstractSinkConfiguration sinkConfiguration,
      AbstractFilterConfiguration filterConfiguration) {
    super();
    this.sourceConfigurations.add(sourceConfiguration);
    this.sinkConfigurations.add(sinkConfiguration);
    this.filterConfigurations.add(filterConfiguration);
  }

  public DataPipeConfiguration(
      AbstractSourceConfiguration sourceConfiguration,
      AbstractSinkConfiguration sinkConfiguration,
      AbstractTransformationConfiguration transformationConfiguration) {
    super();
    this.sourceConfigurations.add(sourceConfiguration);
    this.sinkConfigurations.add(sinkConfiguration);
    this.transformationConfigurations.add(transformationConfiguration);
  }

  public DataPipeConfiguration(
      AbstractSourceConfiguration sourceConfiguration,
      AbstractSinkConfiguration sinkConfiguration) {
    super();
    this.sourceConfigurations.add(sourceConfiguration);
    this.sinkConfigurations.add(sinkConfiguration);
  }

  public DataPipeConfiguration() {
    super();
  }

  public Set<AbstractSourceConfiguration> getSourceConfigurations() {
    return sourceConfigurations;
  }

  public void setSourceConfigurations(Set<AbstractSourceConfiguration> sourceConfigurations) {
    this.sourceConfigurations = sourceConfigurations;
  }

  public Set<AbstractSinkConfiguration> getSinkConfigurations() {
    return sinkConfigurations;
  }

  public void setSinkConfigurations(Set<AbstractSinkConfiguration> sinkConfigurations) {
    this.sinkConfigurations = sinkConfigurations;
  }

  public List<AbstractTransformationConfiguration> getTransformationConfigurations() {
    return transformationConfigurations;
  }

  public void setTransformationConfigurations(
      List<AbstractTransformationConfiguration> transformationConfigurations) {
    this.transformationConfigurations = transformationConfigurations;
  }

  public Set<AbstractFilterConfiguration> getFilterConfigurations() {
    return filterConfigurations;
  }

  public void setFilterConfigurations(Set<AbstractFilterConfiguration> filterConfigurations) {
    this.filterConfigurations = filterConfigurations;
  }

  public Set<String> getLibraryPaths() {
    return libraryPaths;
  }

  public void setLibraryPaths(Set<String> libraryPaths) {
    this.libraryPaths = libraryPaths;
  }
}
