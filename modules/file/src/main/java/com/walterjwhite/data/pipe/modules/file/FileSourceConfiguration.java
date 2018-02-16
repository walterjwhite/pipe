package com.walterjwhite.data.pipe.modules.file;

import com.walterjwhite.data.pipe.api.sink.AbstractSourceConfiguration;

public class FileSourceConfiguration extends AbstractSourceConfiguration {
  protected String path;

  public FileSourceConfiguration(final String path) {
    super(FileSource.class);

    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
