package it.customer.customer.repository;

import it.customer.customer.entities.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Long> {
}
