package it.customer.customer.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.customer.customer.dto.request.CustomerRequest;
import it.customer.customer.dto.response.CustomerResponse;
import it.customer.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customer" )
@Tag(name = "Customer")
public class CustomerController {

    @Autowired
    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(path = "/create-customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> createCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        final  CustomerResponse customer = this.service.addCustomer(customerRequest);
        return new ResponseEntity<CustomerResponse>(customer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/retrieve-customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerResponse>> retrieves() {
        final List<CustomerResponse> customers = this.service.findAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
