package tn.esprit.microservice.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice.produit.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire.
    // Par exemple, une méthode pour rechercher une catégorie par nom :
    // Optional<Category> findByName(String name);
}
