package com.walterjwhite.data.pipe.modules.shell;

import com.walterjwhite.data.pipe.impl.AbstractSink;
import com.walterjwhite.data.pipe.modules.shell.api.model.SystemSinkConfiguration;
import java.io.PrintStream;
import javax.inject.Inject;

public class SystemSink extends AbstractSink<String, SystemSinkConfiguration> {
  protected PrintStream printStream;

  @Inject
  public SystemSink() {
    super();
  }

  @Override
  protected void doConfigure() {
    if (!sinkConfiguration.isError()) printStream = System.out;
    else printStream = System.err;
  }

  @Override
  public void close() throws Exception {
    printStream.flush();
    printStream.close();
  }

  @Override
  public void accept(String s) {
    printStream.println(s);
  }
}
