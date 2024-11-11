package tn.esprit.ecommerce.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-service")
public interface CustomerClient {

  @GetMapping("/customers/{id}")
  Optional<CustomerResponse> findCustomerById(@PathVariable("id") String id);
}
