package ma.emsi.microserviceproduit.services;

import ma.emsi.microserviceproduit.entities.Produit;
import ma.emsi.microserviceproduit.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository repo;

    public ProduitService(ProduitRepository repo) {
        this.repo = repo;
    }

    public List<Produit> findAll() {
        return repo.findAll();
    }

    public Produit findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit not found: " + id));
    }

    public Produit create(Produit p) {
        return repo.save(p);
    }

    public Produit update(Long id, Produit p) {
        Produit old = findById(id);
        old.setNom(p.getNom());
        old.setPrix(p.getPrix());
        return repo.save(old);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public long count() {
        return repo.count();
    }
}
