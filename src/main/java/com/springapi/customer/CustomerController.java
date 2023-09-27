package com.springapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @PostMapping
    public void addCustomer (@RequestBody Customer customer){
         customerService.addCustomer(customer);
    }
    @DeleteMapping(path = "{customerID}")
    public void deleteCustomer(@PathVariable("customerID") Integer id){
        customerService.deleteCustomer(id);
    }
    @PutMapping("{customerID}")
    public void updateCustomer(@PathVariable("customerID") Integer id,
                               @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
    }
}
