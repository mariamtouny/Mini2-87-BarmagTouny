package com.example.miniapp.services;

import com.example.miniapp.repositories.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.miniapp.models.Customer;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    /**
     * Add a new customer to the system
     * @param customer the customer object to be added
     * @return the saved customer with generated ID
     * @throws ResponseStatusException if customer is null or has invalid data
     */
    public Customer addCustomer(Customer customer) {
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer cannot be null");
        }
        return customerRepository.save(customer);
    }


    /**
     * Get all customers from the system
     * @return list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    

 /**
     * Get a customer based on ID
     * @param id Customer ID
     * @return the customer with the specified ID
     * @throws ResponseStatusException if customer not found
     */
    public Customer getCustomerById(Long id)
    {
        return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + id));
    }
    


//Throw exception here

     /**
     * Updates a customer based on ID
     * @param id Customer ID
     * @param customer Whose ID we want to update
     * @return customer who we updated
     * @throws ResponseStatusException if customer is null
     */
    public Customer updateCustomer(Long id, Customer customer)
    {
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer data cannot be null");
        }
        
        Customer existingCustomer = getCustomerById(id); 
    
        
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }


     /**
     * Deletes a customer given his ID
     * @param id Customer ID
     * @throws ResponseStatusException if not found
     */
    public void deleteCustomer(Long id)
    {
//        if(!customerRepository.existsById(id))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + id);
        customerRepository.deleteById(id);
    }

     /**
     * Retrievers all customers whose email address ends with a specific domain
     * @param domain of email we are looking for 
     * @return list whose domain matches
     * @throws ResponseStatusException if domain is null or empty
     */
    public List<Customer> findCustomersByEmailDomain(String domain)
    {
        if (domain == null || domain.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email domain cannot be null or empty");
        }
        return customerRepository.findByEmailDomain(domain);
    }

      /**
     * retrieve all customers whose phone numbers start with a specifc prefx.
     * @param prefix of customers phone number we are looking for 
     * @return list of customer whose phone numbers match this prefix
     * @throws ResponseStatusException if prefix is null or empty
     */
    public List<Customer> findCustomersByPhonePrefix(String prefix)
    {
        if (prefix == null || prefix.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone prefix cannot be null or empty");
        }
        return customerRepository.findByPhonePrefix(prefix);
    }

}