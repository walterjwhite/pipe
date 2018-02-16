package com.walterjwhite.data.pipe.modules.cli;

import com.walterjwhite.data.pipe.api.transformation.AbstractTransformationConfiguration;

public class SimpleTransformationConfiguration extends AbstractTransformationConfiguration {
  protected String from;
  protected String to;

  public SimpleTransformationConfiguration(String from, String to) {
    super(SimpleTestTransformation.class);
    this.from = from;
    this.to = to;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }
}
