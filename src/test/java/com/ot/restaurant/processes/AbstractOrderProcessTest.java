package com.ot.restaurant.processes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ot.restaurant.ApplicationContext;
import com.ot.restaurant.builders.ProcessorConfigBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractOrderProcessTest {

  private ApplicationContext applicationContext = new ApplicationContext();

  private ProcessorConfig processorConfig;

  private Thread thread = new Thread();

  private DummyAbstractOrderProcess dummyAbstractOrderProcess = new DummyAbstractOrderProcess();

  private DummyAbstractOrderProcess dummyAbstractOrderProcessSpy = spy(dummyAbstractOrderProcess);

  @BeforeEach
  void setUp() {

    processorConfig =
        ProcessorConfigBuilder.create()
            .withId(0L)
            .withInterval(1L)
            .withOnStart(Boolean.FALSE)
            .withOnDestroy(Boolean.FALSE)
            .withBeforeExecute(Boolean.FALSE)
            .withAfterExecute(Boolean.FALSE)
            .build();
    dummyAbstractOrderProcessSpy.processorConfig = processorConfig;
  }

  @Test
  void shouldInvokeProcessWhenCallingIt() {
    dummyAbstractOrderProcessSpy.process();

    verify(dummyAbstractOrderProcessSpy, times(1)).process();
  }

  @Test
  void shouldInvokeRunWhenVariableAreAligned() {

    dummyAbstractOrderProcessSpy.state = ProcessState.standby;
    dummyAbstractOrderProcessSpy.processorConfig.setOnStart(Boolean.FALSE);
    dummyAbstractOrderProcessSpy.processorConfig.setOnDestroy(Boolean.FALSE);
    dummyAbstractOrderProcessSpy.processorConfig.setBeforeExecute(Boolean.TRUE);
    dummyAbstractOrderProcessSpy.processorConfig.setAfterExecute(Boolean.TRUE);

    dummyAbstractOrderProcessSpy.run();

    verify(dummyAbstractOrderProcessSpy, times(1)).process();
  }

  private static class DummyAbstractOrderProcess extends AbstractOrderProcess {}
}
