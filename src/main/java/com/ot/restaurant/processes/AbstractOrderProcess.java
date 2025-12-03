package com.ot.restaurant.processes;

import com.ot.restaurant.ApplicationContext;

public abstract class AbstractOrderProcess implements Runnable {

  protected Thread thread;
  protected ProcessorConfig processorConfig;
  protected ApplicationContext applicationContext;
  protected ProcessState state;

  private Long currentTime = 0L;

  private Long deltaTime = 0L;
  private Long lastExecutionTime = 0L;

  public AbstractOrderProcess() {}

  public AbstractOrderProcess(
      Thread thread, ProcessorConfig processorConfig, ApplicationContext applicationContext) {
    this.thread = thread;
    this.processorConfig = processorConfig;
    this.applicationContext = applicationContext;
    this.state = ProcessState.standby;
  }

  protected void process() {
    this.state = ProcessState.destroyed;
  }

  public void run() {

    if (!processorConfig.getOnStart()) {
      processorConfig.handleOnStart(processorConfig, applicationContext);
    }

    while (state != ProcessState.destroyed) {
      if (state != ProcessState.pause) {
        if (processorConfig.getBeforeExecute()) {
          processorConfig.handleBeforeExecute(processorConfig, applicationContext);
        }

        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - lastExecutionTime;

        process();

        lastExecutionTime = currentTime;

        if (processorConfig.getAfterExecute()) {
          processorConfig.handleAfterExecute(processorConfig, applicationContext);
        }
      }

      quietSleep(processorConfig.getInterval());
    }

    if (processorConfig.getOnDestroy()) {
      processorConfig.handleOnDestroy(processorConfig, applicationContext);
    }
  }

  private static void quietSleep(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
