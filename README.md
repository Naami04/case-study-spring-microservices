  Spring Boot Microservices – Case Studies 1 & 2

  Team de développement:
Naami Mohamed - Elrhadiouini Hamza

  Établissement : EMSI
  Module : JEE & Architectures Distribuées
  Année : 2024–2025

  Objectif du projet

Ce projet a pour objectif de mettre en œuvre une architecture microservices complète basée sur Spring Boot et Spring Cloud, incluant :

- Découpage en microservices indépendants

- Enregistrement dynamique via Eureka

- Configuration centralisée avec Spring Cloud Config

- Point d’entrée unique via API Gateway

- Communication inter-services avec OpenFeign

 - Tolérance aux pannes (Timeout + Fallback)

 - Tests des endpoints REST

  Architecture globale

   [ Client ]
     |
     v
[ API Gateway ]
     |
     +--------------------+
     |                    |
     v                    v
[ Microservice Commandes ]   [ Microservice Produit ]
     |
     v
[ Base de données H2 ]


   Structure des projets
Étude de cas 1
        
   - eureka-server
        
   - config-server

   - microservice-commandes

   - microservice-produit

Étude de cas 2

   - gateway-service

   - Résilience & fallback

   - Simulation de timeout

 Technologies utilisées

Java 17 / 21

Spring Boot

Spring Cloud (Eureka, Config, Gateway)

Spring Data JPA

OpenFeign

H2 Database

Maven

Git & GitHub

Instructions d’exécution
  Démarrer dans l’ordre :

1 - eureka-server

2 - config-server

3 - microservice-produit

4 - microservice-commandes

5 - gateway-service
