package com.ot.restaurant.builders;

import com.ot.restaurant.ApplicationContext;
import com.ot.restaurant.processes.ProcessorConfig;
import java.util.function.BiConsumer;

public class ProcessorConfigBuilder {

  private ProcessorConfig processorConfig = new ProcessorConfig();

  public ProcessorConfigBuilder() {}

  public static ProcessorConfigBuilder create() {
    return new ProcessorConfigBuilder();
  }

  public ProcessorConfigBuilder withId(Long id) {
    processorConfig.setId(id);
    return this;
  }

  public ProcessorConfigBuilder withInterval(Long interval) {
    processorConfig.setInterval(interval);
    return this;
  }

  public ProcessorConfigBuilder withOnStart(
      BiConsumer<ProcessorConfig, ApplicationContext> onStart) {
    processorConfig.setOnStart(onStart);
    return this;
  }

  public ProcessorConfigBuilder withOnDestroy(
      BiConsumer<ProcessorConfig, ApplicationContext> onDestroy) {
    processorConfig.setOnDestroy(onDestroy);
    return this;
  }

  public ProcessorConfigBuilder withBeforeExecute(
      BiConsumer<ProcessorConfig, ApplicationContext> beforeExecute) {
    processorConfig.setBeforeExecute(beforeExecute);
    return this;
  }

  public ProcessorConfigBuilder withAfterExecute(
      BiConsumer<ProcessorConfig, ApplicationContext> afterExecute) {
    processorConfig.setAfterExecute(afterExecute);
    return this;
  }

  public ProcessorConfig build() {
    return this.processorConfig;
  }
}
