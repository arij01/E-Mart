package tn.esprit.microservice.produit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.microservice.produit.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}