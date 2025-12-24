package ma.emsi.microservicecommandes.repositories;

import ma.emsi.microservicecommandes.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateGreaterThanEqual(LocalDate dateMin);
}
