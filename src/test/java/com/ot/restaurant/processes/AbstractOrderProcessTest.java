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
            .withOnStart((processorConfig, applicationContext) -> {})
            .withOnDestroy((processorConfig, applicationContext) -> {})
            .withBeforeExecute((processorConfig, applicationContext) -> {})
            .withAfterExecute((processorConfig, applicationContext) -> {})
            .build();
  }

  @Test
  void shouldInvokeProcessWhenCallingIt() {
    dummyAbstractOrderProcessSpy.process();

    verify(dummyAbstractOrderProcessSpy, times(1)).process();
  }

  @Test
  void shouldInvokeProcessWhenInRunVariablesAreNotNull() {

    dummyAbstractOrderProcessSpy.state = ProcessState.STANDBY;
    dummyAbstractOrderProcessSpy.processorConfig = processorConfig;

    doAnswer(
            invocation -> {
              dummyAbstractOrderProcessSpy.state = ProcessState.DESTROYED;
              return null;
            })
        .when(dummyAbstractOrderProcessSpy)
        .process();

    dummyAbstractOrderProcessSpy.run();

    verify(dummyAbstractOrderProcessSpy, times(1)).process();
  }

  @Test
  void shouldNotInvokeProcessWhenInRunVariablesAreNotNull() {

    dummyAbstractOrderProcessSpy.state = ProcessState.STANDBY;

    // dummyAbstractOrderProcessSpy.run();

    doThrow(NullPointerException.class).when(dummyAbstractOrderProcessSpy).run();

    assertThrows(NullPointerException.class, () -> dummyAbstractOrderProcessSpy.run());
  }

  private static class DummyAbstractOrderProcess extends AbstractOrderProcess {}
}
