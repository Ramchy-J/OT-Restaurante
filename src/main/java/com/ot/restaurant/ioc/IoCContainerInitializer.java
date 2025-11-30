package com.ot.restaurant.ioc;

import com.ot.restaurant.ApplicationContext;
import com.ot.restaurant.controllers.ChefController;
import com.ot.restaurant.controllers.CustomerController;
import com.ot.restaurant.controllers.IngredientsController;
import com.ot.restaurant.controllers.OrderController;
import com.ot.restaurant.controllers.OrderDetailController;
import com.ot.restaurant.controllers.ProductController;
import com.ot.restaurant.entities.Chef;
import com.ot.restaurant.entities.Ingredients;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.repositories.ChefRepository;
import com.ot.restaurant.repositories.ChefRepositoryImpl;
import com.ot.restaurant.repositories.CustomerRepository;
import com.ot.restaurant.repositories.CustomerRepositoryImpl;
import com.ot.restaurant.repositories.IngredientsRepository;
import com.ot.restaurant.repositories.IngredientsRepositoryImpl;
import com.ot.restaurant.repositories.OrderDetailRepository;
import com.ot.restaurant.repositories.OrderDetailRepositoryImpl;
import com.ot.restaurant.repositories.OrderRepository;
import com.ot.restaurant.repositories.OrderRepositoryImpl;
import com.ot.restaurant.repositories.ProductRepository;
import com.ot.restaurant.repositories.ProductRepositoryImpl;
import com.ot.restaurant.seeder.AbstractSeeder;
import com.ot.restaurant.seeder.ChefSeeder;
import com.ot.restaurant.seeder.CustomerSeeder;
import com.ot.restaurant.seeder.IngredientsSeeder;
import com.ot.restaurant.seeder.OrderDetailSeeder;
import com.ot.restaurant.seeder.OrderSeeder;
import com.ot.restaurant.seeder.ProductSeeder;
import com.ot.restaurant.seeder.SeederManager;
import java.util.ArrayList;

public class IoCContainerInitializer {
  private final IoCContainer ioc = IoCContainer.getInstance();

  public IoCContainerInitializer() {}

  public void initialize() throws Exception {
    initializeRepositories();
    initializeControllers();
    initializeApplicationContext();
  }

  private void initializeRepositories() throws Exception {
    final var chefRepository = "chefRepository";
    ioc.register(chefRepository, new ChefRepositoryImpl<>());

    final var customerRepository = "customerRepository";
    ioc.register(customerRepository, new CustomerRepositoryImpl());

    final var ingredientsRepository = "ingredientsRepository";
    ioc.register(ingredientsRepository, new IngredientsRepositoryImpl<>());

    final var orderDetailRepository = "orderDetailRepository";
    ioc.register(orderDetailRepository, new OrderDetailRepositoryImpl<>());

    final var orderRepository = "orderRepository";
    ioc.register(orderRepository, new OrderRepositoryImpl<>());

    final var productRepository = "productRepository";
    ioc.register(productRepository, new ProductRepositoryImpl<>());
  }

  private void initializeControllers() throws Exception {
    final var chefRepository = ((ChefRepository<Chef>) ioc.resolve("chefRepository"));
    final var chefController = "chefController";
    ioc.register(chefController, new ChefController(chefRepository));

    final var customerRepository = (CustomerRepository) ioc.resolve("customerRepository");
    final var customerController = "customerController";
    ioc.register(customerController, new CustomerController(customerRepository));

    final var ingredientsRepository =
        (IngredientsRepository<Ingredients>) ioc.resolve("ingredientsRepository");
    final var ingredientsController = "ingredientsController";
    ioc.register(ingredientsController, new IngredientsController(ingredientsRepository));

    final var orderRepository = (OrderRepository<Order>) ioc.resolve("orderRepository");
    final var orderController = "orderController";
    ioc.register(orderController, new OrderController(orderRepository));

    final var orderDetailRepository =
        (OrderDetailRepository<OrderDetail>) ioc.resolve("orderDetailRepository");
    final var orderDetailController = "orderDetailController";
    ioc.register(orderDetailController, new OrderDetailController(orderDetailRepository));

    final var productRepository = (ProductRepository<Product>) ioc.resolve("productRepository");
    final var productController = "productController";
    ioc.register(productController, new ProductController(productRepository));
  }

  public void initializeSeeders() throws Exception {
    final var seeders = new ArrayList<AbstractSeeder>();

    final var customerRepository = (CustomerRepository) ioc.resolve("customerRepository");
    final var customerSeeder = new CustomerSeeder(customerRepository);
    seeders.add(customerSeeder);

    final var chefRepository = (ChefRepository) ioc.resolve("chefRepository");
    final var chefSeeder = new ChefSeeder(chefRepository);
    seeders.add(chefSeeder);

    final var ingredientsRepository = (IngredientsRepository) ioc.resolve("ingredientsRepository");
    final var ingredientsSeeder = new IngredientsSeeder(ingredientsRepository);
    seeders.add(ingredientsSeeder);

    final var productRepository = (ProductRepository) ioc.resolve("productRepository");
    final var productSeeder = new ProductSeeder(productRepository);
    seeders.add(productSeeder);

    final var orderDetailRepository = (OrderDetailRepository) ioc.resolve("orderDetailRepository");
    final var orderDetailSeeder = new OrderDetailSeeder(orderDetailRepository);
    seeders.add(orderDetailSeeder);

    final var orderRepository = (OrderRepository) ioc.resolve("orderRepository");
    final var orderSeeder = new OrderSeeder(orderRepository);
    seeders.add(orderSeeder);

    final var seederManager = "seederManager";
    ioc.register(seederManager, new SeederManager(seeders));
  }

  public void initializeApplicationContext() throws Exception {
    final var applicationContext = new ApplicationContext();
    ioc.register("applicationContext", applicationContext);
  }
}
