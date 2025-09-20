package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.repositories.CustomerRepository;
import java.util.List;

public class CustomerSeeder extends AbstractSeeder<Customer> {

  private final CustomerRepository customerRepository;

  public CustomerSeeder(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<Customer> load() {

    return List.of(
        CustomerBuilder.create()
            .withFirstName("Loki1")
            .withLastName("Samahia1")
            .withPhoneNumber("111-111-1111")
            .withStatus(Status.ACTIVE)
            .build(),
        CustomerBuilder.create()
            .withFirstName("Loki2")
            .withLastName("Samahia2")
            .withPhoneNumber("222-222-2222")
            .withStatus(Status.ACTIVE)
            .build(),
        CustomerBuilder.create()
            .withFirstName("Loki3")
            .withLastName("Samahia3")
            .withPhoneNumber("333-333-3333")
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<Customer> customersEntities) {
    customersEntities.forEach(customerRepository::insert);
  }
}
