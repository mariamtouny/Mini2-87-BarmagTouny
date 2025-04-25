package com.example.miniapp.controllers;
import com.example.miniapp.models.Customer;
import com.example.miniapp.services.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


        /**
     * Add a new customer
     * @param customer the customer to add
     * @return the added customer with generated ID
     */

    @PostMapping("/addCustomer") public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }


       /**
      * Get all customers
     * @return list of all customers
      */
    @GetMapping("/allCustomers") public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }


           /**
      * Get a customer based on his ID
      * @param id of customer to get
      * @return the customer with the specified ID
      * @throws ResponseStatusException if customer not found
      */
    @GetMapping("/{id}") public Customer getCustomerById(@PathVariable Long id)
    {   return customerService.getCustomerById(id);
    }

       /**
      * Update a customer's information
      * @param id the customer ID to update
      * @param customer the updated customer information
      * @return the updated customer
      */
      @PutMapping("/update/{id}") public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer)
      {
        return customerService.updateCustomer(id, customer);
      }

         /**
     * Delete a customer
     * @param id the customer ID to delete
     * @return confirmation message
     */
    @DeleteMapping("/delete/{id}") public String deleteCustomer(@PathVariable Long id)
    {
         customerService.deleteCustomer(id);
         return "Customer with ID: " + id + " has been deleted successfully";
    }

        /**
     * Find customers by their email domain
     * @param domain the email domain to search for
     * @return list of customers with emails ending with the specified domain
     */
    @GetMapping("/findByEmailDomain") public List<Customer> findCustomersByEmailDomain(@RequestParam String domain)
    {
        return customerService.findCustomersByEmailDomain(domain);
    }


        /**
     * Find customers by their phone number prefix
     * @param prefix the phone number prefix to search for
     * @return list of customers with phone numbers starting with the specified prefix
     */
    @GetMapping("/findByPhonePrefix")
    public List<Customer> findCustomersByPhonePrefix(@RequestParam String prefix) {
        return customerService.findCustomersByPhonePrefix(prefix);
    }

    
}
