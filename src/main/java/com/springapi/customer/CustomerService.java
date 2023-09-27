package com.springapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        boolean exist = customerRepository.existsById(id);
        if(!exist){
            throw  new IllegalStateException(
                    "Customer with id " + id + " does not exist"
            );
        }
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id,
                               Customer customer){
        boolean exist = customerRepository.existsById(id);
        if(!exist){
            throw  new IllegalStateException(
                    "Customer with id " + id + " does not exist"
            );
        }
        customerRepository.save(customer);
    }
}
