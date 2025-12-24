package ma.emsi.microservicecommandes.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.emsi.microservicecommandes.clients.ProduitClient;
import ma.emsi.microservicecommandes.entities.Commande;
import ma.emsi.microservicecommandes.services.CommandeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService service;
    private final ProduitClient produitClient;

    @Value("${mes-config-ms.commandes-last:10}")
    private int lastDays;

    public CommandeController(CommandeService service, ProduitClient produitClient) {
        this.service = service;
        this.produitClient = produitClient;
    }

    // ✅ CRUD
    @GetMapping
    public List<Commande> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Commande one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Commande> create(@RequestBody Commande c) {
        Commande saved = service.create(c);
        return ResponseEntity.created(URI.create("/commandes/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public Commande update(@PathVariable Long id, @RequestBody Commande c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/last")
    public List<Commande> last() {
        return service.lastDays(lastDays);
    }

    @GetMapping("/config")
    public String config() {
        return "mes-config-ms.commandes-last = " + lastDays;
    }

    // ✅ Appel microservice-produit avec protection CircuitBreaker
    @CircuitBreaker(name = "produitService", fallbackMethod = "fallbackProduit")
    @GetMapping("/{id}/produit")
    public Object produitDeCommande(@PathVariable Long id) {
        Commande c = service.findById(id);

        if (c.getIdProduit() == null) {
            return Map.of("message", "Cette commande n'a pas idProduit");
        }

        return produitClient.getProduit(c.getIdProduit());
    }

    // ✅ Fallback (IMPORTANT: même signature + Exception à la fin)
    public Object fallbackProduit(Long id, Throwable ex) {
        return Map.of(
                "message", "Microservice-produit indisponible (timeout ou erreur)",
                "commandeId", id,
                "error", ex.getClass().getSimpleName()
        );
    }
}
