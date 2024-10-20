package com.restaurante.entities;

import com.restaurante.exceptions.DependencyKeyNullpointerException;
import com.restaurante.exceptions.DependencyNotFoundException;
import com.restaurante.exceptions.DependencyValueNullpointerException;
import com.restaurante.exceptions.DuplicatedDependencyFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
Lines for use the container
1. IoCContainer ioc = IoCContainer.getInstance();
2. ioc.Register(Entitie_name,new Entitie_name());
3. Entitie_name any_name = (Entitie_name)ioc.Resolve("Entitie_name");
4. Now you can use the name used in any_name for to the methodes of the entitie
 */
final class IoCContainer<T> {

  // Singleton to instantiate the IoCContainer only once
  private static IoCContainer ioc;

  private IoCContainer() {}

  public static IoCContainer getInstance() {

    return Optional.ofNullable(ioc).orElseGet(IoCContainer::new);
  }

  // IoCContainer structure
  private final Map<String, T> instancePool = new HashMap<String, T>();

  public void register(final String key, final T value) throws Exception {

    Optional.ofNullable(key).orElseThrow(DependencyKeyNullpointerException::new);

    Optional.of(key).map(instancePool::get).orElseThrow(DuplicatedDependencyFoundException::new);

    instancePool.put(key, value);
  }

  public T resolve(final String key) throws Exception {

    Optional.ofNullable(key).orElseThrow(DependencyValueNullpointerException::new);

    Optional.of(key).map(instancePool::get).orElseThrow(DependencyNotFoundException::new);

    return (T) instancePool.get(key);
  }
}
