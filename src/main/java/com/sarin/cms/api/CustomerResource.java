package com.sarin.cms.api;

import com.sarin.cms.model.Customer;
import com.sarin.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomer(id);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
         customerService.deleteCustomer(customerId);
    }
}
