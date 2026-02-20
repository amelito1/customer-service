package it.customer.customer.service;

import it.customer.customer.dto.request.CustomerRequest;
import it.customer.customer.dto.response.CustomerResponse;
import it.customer.customer.entities.CustomerEntity;
import it.customer.customer.repository.CustomerRepository;
import it.customer.customer.utility.CustomerUtilities;
import it.euris.common.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<CustomerResponse> retrievesCustomerPages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        final List<CustomerResponse> customers = this.customerRepository
                .findAll(pageable)
                .stream()
                .map(CustomerUtilities::toResponse).toList();
        return PageUtils.toPage(customers, pageable);
    }


}
