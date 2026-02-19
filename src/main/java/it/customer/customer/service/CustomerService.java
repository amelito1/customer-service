package it.customer.customer.service;

import it.customer.customer.dto.request.CustomerRequest;
import it.customer.customer.dto.response.CustomerResponse;
import it.customer.customer.entities.CustomerEntity;
import it.customer.customer.repository.CustomerRepository;
import it.customer.customer.utility.CustomerUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> findAllCustomers() {
       return  customerRepository
               .findAll()
               .stream()
               .map(CustomerUtilities::toResponse).toList();
    }

    public CustomerResponse addCustomer(CustomerRequest request) {
        final CustomerEntity customerEntityToAdd = CustomerUtilities.toEntity(request);

       final CustomerEntity customerSaved = customerRepository.save(customerEntityToAdd);
        return CustomerUtilities.toResponse(customerSaved);
    }


}
