package ma.emsi.microserviceproduit.config;

import ma.emsi.microserviceproduit.entities.Produit;
import ma.emsi.microserviceproduit.services.ProduitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seed(ProduitService service) {
        return args -> {
            if (service.count() == 0) {
                service.create(new Produit("Produit 1", 100));
                service.create(new Produit("Produit 2", 250));
                service.create(new Produit("Produit 3", 80));
            }
        };
    }
}
