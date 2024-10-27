package tn.esprit.ecommerce;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerRepo repo;


    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
    public Optional<Customer> getCustomerById(String id) {
        return repo.findById(id);
    }

    public Customer updateCustomer(String id, Customer customer) {
        return repo.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirstname(customer.getFirstname());
                    existingCustomer.setLastname(customer.getLastname());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setAddress(customer.getAddress());
                    return repo.save(existingCustomer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }
}
