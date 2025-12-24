package ma.emsi.microservicecommandes.services;

import ma.emsi.microservicecommandes.entities.Commande;
import ma.emsi.microservicecommandes.repositories.CommandeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository repo;

    public CommandeService(CommandeRepository repo) {
        this.repo = repo;
    }

    public List<Commande> findAll() {
        return repo.findAll();
    }

    public Commande findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande " + id + " introuvable"));
    }

    public Commande create(Commande c) {
        c.setId(null);
        if (c.getDate() == null) c.setDate(LocalDate.now());
        return repo.save(c);
    }

    public Commande update(Long id, Commande c) {
        Commande existing = findById(id);
        existing.setDescription(c.getDescription());
        existing.setQuantite(c.getQuantite());
        existing.setDate(c.getDate());
        existing.setMontant(c.getMontant());
        existing.setIdProduit(c.getIdProduit());
        return repo.save(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande " + id + " introuvable");
        }
        repo.deleteById(id);
    }

    public List<Commande> lastDays(int days) {
        LocalDate dateMin = LocalDate.now().minusDays(days);
        return repo.findByDateGreaterThanEqual(dateMin);
    }

    public long count() {
        return repo.count();
    }
}
