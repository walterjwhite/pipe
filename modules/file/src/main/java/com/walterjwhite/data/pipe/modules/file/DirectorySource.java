package com.walterjwhite.data.pipe.modules.file;

import com.walterjwhite.data.pipe.impl.AbstractSource;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

public class DirectorySource extends AbstractSource<File, FileSourceConfiguration> {
  protected File directory;

  @Override
  protected void doConfigure() {
    directory = new File(sourceConfiguration.getPath());
  }

  @Override
  public void close() throws Exception {}

  // TODO: support a filename filter (that could be implemented alternatively through a pipe filter)
  // TODO: for directories with a lot of files, this is not a good approach
  @Override
  public Iterator<File> iterator() {
    return Arrays.asList(directory.listFiles()).iterator();
  }
}
