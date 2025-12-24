package ma.emsi.microservicecommandes.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantite;
    private LocalDate date;
    private Double montant;

    // id du produit (microservice-produit)
    private Long idProduit;

    public Commande() {}

    public Commande(String description, Integer quantite, LocalDate date, Double montant, Long idProduit) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
        this.idProduit = idProduit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public Long getIdProduit() { return idProduit; }
    public void setIdProduit(Long idProduit) { this.idProduit = idProduit; }
}
