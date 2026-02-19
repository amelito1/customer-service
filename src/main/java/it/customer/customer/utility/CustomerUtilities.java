package it.customer.customer.utility;

import it.customer.customer.dto.request.CustomerRequest;
import it.customer.customer.dto.response.CustomerResponse;
import it.customer.customer.entities.CustomerEntity;

public class CustomerUtilities {

    public static String customerFullName(CustomerEntity userEntity) {
        return userEntity.getFirstName() +" "+userEntity.getLastName();
    }

    public static CustomerResponse toResponse(CustomerEntity customer) {
        return new CustomerResponse(
                customer.getId(),
                customerFullName(customer),
                customer.getDateOfBirth(),
                customer.getTaxIdentificationNumber(),
                customer.getEmail()
        );
    }

    public static  CustomerEntity toEntity(CustomerRequest customerRequest) {
        final CustomerEntity customer = new CustomerEntity();
        customer.setEmail(customerRequest.getEmail());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customer.setTaxIdentificationNumber(customerRequest.getTaxIdentificationNumber());

        return customer;
    }
}
