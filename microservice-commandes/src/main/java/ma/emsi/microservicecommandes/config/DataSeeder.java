package ma.emsi.microservicecommandes.config;

import ma.emsi.microservicecommandes.entities.Commande;
import ma.emsi.microservicecommandes.services.CommandeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CommandeService service;

    public DataSeeder(CommandeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        if (service.count() == 0) {

            Commande c1 = new Commande();
            c1.setDescription("Commande STOP");
            c1.setQuantite(2);
            c1.setDate(LocalDate.now().minusDays(2));
            c1.setMontant(120.0);
            c1.setIdProduit(1L);
            service.create(c1);

            Commande c2 = new Commande();
            c2.setDescription("Commande VITESSE");
            c2.setQuantite(1);
            c2.setDate(LocalDate.now().minusDays(8));
            c2.setMontant(80.0);
            c2.setIdProduit(2L);
            service.create(c2);

            Commande c3 = new Commande();
            c3.setDescription("Commande SENS INTERDIT");
            c3.setQuantite(5);
            c3.setDate(LocalDate.now().minusDays(15));
            c3.setMontant(300.0);
            c3.setIdProduit(3L);
            service.create(c3);
        }
    }
}
