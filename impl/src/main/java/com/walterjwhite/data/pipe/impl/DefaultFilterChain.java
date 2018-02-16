package com.walterjwhite.data.pipe.impl;

import com.walterjwhite.data.pipe.api.filter.AbstractFilterConfiguration;
import com.walterjwhite.data.pipe.api.filter.Filter;
import com.walterjwhite.google.guice.GuiceHelper;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/** TODO: support more complicated chaining such as And, Or, Negate ... */
public class DefaultFilterChain implements Predicate {
  protected final Set<Filter> filters = new HashSet<>();

  public DefaultFilterChain(final Set<AbstractFilterConfiguration> filterConfigurations)
      throws ClassNotFoundException {
    super();

    for (final AbstractFilterConfiguration filterConfiguration : filterConfigurations) {
      Filter filter =
          GuiceHelper.getGuiceInjector().getInstance(filterConfiguration.getFilterClass());
      filter.configure(filterConfiguration);
      filters.add(filter);
    }
  }

  @Override
  public boolean test(Object o) {
    for (final Filter filter : filters) if (!filter.test(o)) return false;

    return true;
  }
}
