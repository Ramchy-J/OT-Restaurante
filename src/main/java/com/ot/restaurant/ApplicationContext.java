package com.ot.restaurant;

public class ApplicationContext {

  private String state = "";

  public ApplicationContext() {}

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
