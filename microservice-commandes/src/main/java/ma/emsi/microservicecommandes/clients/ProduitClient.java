package ma.emsi.microservicecommandes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-produit")
public interface ProduitClient {

    @GetMapping("/produits/{id}")
    Object getProduit(@PathVariable Long id);
}
