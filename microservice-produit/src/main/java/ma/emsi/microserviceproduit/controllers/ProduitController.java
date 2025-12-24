package ma.emsi.microserviceproduit.controllers;

import ma.emsi.microserviceproduit.entities.Produit;
import ma.emsi.microserviceproduit.services.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produit> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(5000); // ✅ SIMULATION TIMEOUT
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Produit> create(@RequestBody Produit p) {
        Produit saved = service.create(p);
        return ResponseEntity.created(URI.create("/produits/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
