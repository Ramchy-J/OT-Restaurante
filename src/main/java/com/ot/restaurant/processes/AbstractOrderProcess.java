package com.ot.restaurant.processes;

import static com.ot.restaurant.utils.ThreadUtils.quietSleep;

import com.ot.restaurant.ApplicationContext;
import java.util.Optional;

public abstract class AbstractOrderProcess implements Runnable {

  protected Thread thread;
  protected ProcessorConfig processorConfig;
  protected ApplicationContext applicationContext;
  protected ProcessState state;

  public AbstractOrderProcess() {}

  public AbstractOrderProcess(
      Thread thread, ProcessorConfig processorConfig, ApplicationContext applicationContext) {
    this.thread = thread;
    this.processorConfig = processorConfig;
    this.applicationContext = applicationContext;
    this.state = ProcessState.STANDBY;
  }

  protected void process() {}

  public void run() {

    Optional.ofNullable(processorConfig.getOnStart())
        .ifPresent(h -> h.accept(processorConfig, applicationContext));

    while (state != ProcessState.DESTROYED) {
      if (state != ProcessState.PAUSE) {

        Optional.ofNullable(processorConfig.getBeforeExecute())
            .ifPresent(h -> h.accept(processorConfig, applicationContext));

        process();

        Optional.ofNullable(processorConfig.getAfterExecute())
            .ifPresent(h -> h.accept(processorConfig, applicationContext));
      }

      quietSleep(processorConfig.getInterval());
    }

    Optional.ofNullable(processorConfig.getOnDestroy())
        .ifPresent(h -> h.accept(processorConfig, applicationContext));
  }
}
