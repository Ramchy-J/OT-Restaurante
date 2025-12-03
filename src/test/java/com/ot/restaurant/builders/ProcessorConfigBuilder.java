package com.ot.restaurant.builders;

import com.ot.restaurant.processes.ProcessorConfig;

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

  public ProcessorConfigBuilder withOnStart(Boolean onStart) {
    processorConfig.setOnStart(onStart);
    return this;
  }

  public ProcessorConfigBuilder withOnDestroy(Boolean onDestroy) {
    processorConfig.setOnDestroy(onDestroy);
    return this;
  }

  public ProcessorConfigBuilder withBeforeExecute(Boolean beforeExecute) {
    processorConfig.setBeforeExecute(beforeExecute);
    return this;
  }

  public ProcessorConfigBuilder withAfterExecute(Boolean afterExecute) {
    processorConfig.setAfterExecute(afterExecute);
    return this;
  }

  public ProcessorConfig build() {
    return this.processorConfig;
  }
}
