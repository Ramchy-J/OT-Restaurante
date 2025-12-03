package com.ot.restaurant.processes;

public enum ProcessState {
  pause("pause"),
  destroyed("destroyed"),
  standby("standby");

  private final String state;

  private ProcessState(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }
}
