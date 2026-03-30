package com.ot.restaurant.processes;

import com.ot.restaurant.ApplicationContext;
import java.util.function.BiConsumer;

public class ProcessorConfig {

  private Long id;
  private Long interval;
  private BiConsumer<ProcessorConfig, ApplicationContext> onStart;
  private BiConsumer<ProcessorConfig, ApplicationContext> onDestroy;
  private BiConsumer<ProcessorConfig, ApplicationContext> beforeExecute;
  private BiConsumer<ProcessorConfig, ApplicationContext> afterExecute;

  public ProcessorConfig() {}

  public ProcessorConfig(
      Long id,
      Long interval,
      BiConsumer<ProcessorConfig, ApplicationContext> onStart,
      BiConsumer<ProcessorConfig, ApplicationContext> onDestroy,
      BiConsumer<ProcessorConfig, ApplicationContext> beforeExecute,
      BiConsumer<ProcessorConfig, ApplicationContext> afterExecute) {
    this.id = id;
    this.interval = interval;
    this.onStart = onStart;
    this.onDestroy = onDestroy;
    this.beforeExecute = beforeExecute;
    this.afterExecute = afterExecute;
  }

  public Long getId() {
    return id;
  }

  public Long getInterval() {
    return interval;
  }

  public BiConsumer<ProcessorConfig, ApplicationContext> getOnStart() {
    return onStart;
  }

  public BiConsumer<ProcessorConfig, ApplicationContext> getOnDestroy() {
    return onDestroy;
  }

  public BiConsumer<ProcessorConfig, ApplicationContext> getBeforeExecute() {
    return beforeExecute;
  }

  public BiConsumer<ProcessorConfig, ApplicationContext> getAfterExecute() {
    return afterExecute;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setInterval(Long interval) {
    this.interval = interval;
  }

  public void setOnStart(BiConsumer<ProcessorConfig, ApplicationContext> onStart) {
    this.onStart = onStart;
  }

  public void setOnDestroy(BiConsumer<ProcessorConfig, ApplicationContext> onDestroy) {
    this.onDestroy = onDestroy;
  }

  public void setBeforeExecute(BiConsumer<ProcessorConfig, ApplicationContext> beforeExecute) {
    this.beforeExecute = beforeExecute;
  }

  public void setAfterExecute(BiConsumer<ProcessorConfig, ApplicationContext> afterExecute) {
    this.afterExecute = afterExecute;
  }
}
