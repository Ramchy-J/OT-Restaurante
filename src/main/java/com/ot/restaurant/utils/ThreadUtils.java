package com.ot.restaurant.utils;

public class ThreadUtils {
  public static void quietSleep(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
