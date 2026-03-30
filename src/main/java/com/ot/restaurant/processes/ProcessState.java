package com.ot.restaurant.processes;

public enum ProcessState {
  PAUSE("pause"),
  DESTROYED("destroyed"),
  STANDBY("standby");

  private final String state;

  private ProcessState(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }
}
