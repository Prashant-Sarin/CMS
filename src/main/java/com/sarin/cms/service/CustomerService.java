package com.sarin.cms.service;

import com.sarin.cms.dao.CustomerDAO;
import com.sarin.cms.exception.CustomerNotFoundException;
import com.sarin.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int id) {
        Optional<Customer> optionalCustomer = customerDAO.findById(id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found.");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int id, Customer customer) {
        customer.setId(id);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteById(id);
    }
}
