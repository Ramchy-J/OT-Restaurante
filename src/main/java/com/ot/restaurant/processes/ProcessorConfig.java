package com.ot.restaurant.processes;

import com.ot.restaurant.ApplicationContext;

public class ProcessorConfig {

  private Long id;
  private Long interval;
  private Boolean onStart;
  private Boolean onDestroy;
  private Boolean beforeExecute;
  private Boolean afterExecute;

  public ProcessorConfig() {}

  public ProcessorConfig(
      Long id,
      Long interval,
      Boolean onStart,
      Boolean onDestroy,
      Boolean beforeExecute,
      Boolean afterExecute) {
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

  public Boolean getOnStart() {
    return onStart;
  }

  public Boolean getOnDestroy() {
    return onDestroy;
  }

  public Boolean getBeforeExecute() {
    return beforeExecute;
  }

  public Boolean getAfterExecute() {
    return afterExecute;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setInterval(Long interval) {
    this.interval = interval;
  }

  public void setOnStart(Boolean onStart) {
    this.onStart = onStart;
  }

  public void setOnDestroy(Boolean onDestroy) {
    this.onDestroy = onDestroy;
  }

  public void setBeforeExecute(Boolean beforeExecute) {
    this.beforeExecute = beforeExecute;
  }

  public void setAfterExecute(Boolean afterExecute) {
    this.afterExecute = afterExecute;
  }

  public void handleOnStart(
      ProcessorConfig processorConfig, ApplicationContext applicationContext) {}

  public void handleOnDestroy(
      ProcessorConfig processorConfig, ApplicationContext applicationContext) {}

  public void handleBeforeExecute(
      ProcessorConfig processorConfig, ApplicationContext applicationContext) {}

  public void handleAfterExecute(
      ProcessorConfig processorConfig, ApplicationContext applicationContext) {}
}
