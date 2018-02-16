package com.walterjwhite.data.pipe.modules.cli;

import com.walterjwhite.data.pipe.api.filter.AbstractFilterConfiguration;

public class SimpleFilterConfiguration extends AbstractFilterConfiguration {
  protected String valueToIgnore;

  public SimpleFilterConfiguration(String valueToIgnore) {
    super(SimpleTestFilter.class);
    this.valueToIgnore = valueToIgnore;
  }

  public String getValueToIgnore() {
    return valueToIgnore;
  }

  public void setValueToIgnore(String valueToIgnore) {
    this.valueToIgnore = valueToIgnore;
  }
}
