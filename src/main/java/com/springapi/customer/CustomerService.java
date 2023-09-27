package com.springapi.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        boolean exist = customerRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(
                    "Customer with id " + id + " does not exist"
            );
        }
        customerRepository.deleteById(id);
    }

    @Transactional
    public void updateCustomer(Integer id,
                               Customer customer) {
        Customer customer1 = customerRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalStateException(
                            "Customer with id " + id + " does not exist"
                    );
                });

        if (!Objects.equals(customer.getName(),customer1.getName())){
            customer1.setName(customer.getName());
        }

        if (!Objects.equals(customer.getAge(),customer1.getAge())){
            customer1.setAge(customer.getAge());
        }

        if (!Objects.equals(customer.getEmail(),customer1.getEmail())){
            customer1.setEmail(customer.getEmail());
        }
    };
}


