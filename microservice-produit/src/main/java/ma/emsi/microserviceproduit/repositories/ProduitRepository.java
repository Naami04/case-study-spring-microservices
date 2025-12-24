package ma.emsi.microserviceproduit.repositories;

import ma.emsi.microserviceproduit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
