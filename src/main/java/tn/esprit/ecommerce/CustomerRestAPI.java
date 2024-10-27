package tn.esprit.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestAPI {
    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.createCustomer(customer));
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(service.updateCustomer(id, customer));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
