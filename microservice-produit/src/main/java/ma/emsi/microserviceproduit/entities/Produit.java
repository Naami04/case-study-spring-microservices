package ma.emsi.microserviceproduit.entities;

import jakarta.persistence.*;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;

    public Produit() {}

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrix(double prix) { this.prix = prix; }
}
