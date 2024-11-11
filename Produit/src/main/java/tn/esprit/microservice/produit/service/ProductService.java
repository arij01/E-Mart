package tn.esprit.microservice.produit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.produit.exception.ResourceNotFoundException;
import tn.esprit.microservice.produit.model.Category;
import tn.esprit.microservice.produit.model.Product;
import tn.esprit.microservice.produit.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Create a new product
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Get a product by ID
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Update a product
    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        product.setName(productDetails.getName());  // Assuming Product has a name field
        product.setPrice(productDetails.getPrice()); // Assuming Product has a price field
        // Update other fields as necessary

        return productRepository.save(product);
    }

    // Delete a product
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        productRepository.delete(product);
    }

//    public Product save(Product product, Long categoryId) {
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
//        product.setCategory(category);
//        return productRepository.save(product);
//    }
//    public Product saveProductWithCategory(Product product, Long categoryId) {
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));

//        product.setCategory(category); // Associe la catégorie au produit
//        return productRepository.save(product); // Sauvegarde le produit avec la catégorie
//    }


}
