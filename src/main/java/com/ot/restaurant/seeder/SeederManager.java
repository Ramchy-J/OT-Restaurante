package com.ot.restaurant.seeder;

import java.util.List;

public class SeederManager {
  private final List<AbstractSeeder> seeders;

  public SeederManager(List<AbstractSeeder> seeders) {
    this.seeders = seeders;
  }

  public void run() {
    seeders.forEach(AbstractSeeder::seed);
  }
}
