# Rapport du Projet Académique : Application E-commerce Microservices (Backend)

## Introduction

Ce repo contient le code backend de l'application e-commerce développée en utilisant une architecture microservices avec Spring Boot. Le backend gère les différents services tels que les clients, produits, commandes, et factures. La base de données H2 a été employée pour le stockage des données.

---

## Structure Backend : Spring Boot Microservices


### Répertoires principaux

- **billing-service** : Gestion des factures.
- **config-service** : Service de configuration centralisée.
- **customer-service** : Gestion des clients.
- **discovery-service** : Service de découverte Eureka.
- **gateway** : API Gateway pour le routage.
- **inventory-service** : Gestion des stocks.

![architecture](https://github.com/user-attachments/assets/c969a7f5-877c-4e2c-932a-a179f5d50326)


### Technologies Utilisées

- Spring Boot (Cloud, Data JPA, Web).
- H2 Database.
- Eureka Discovery.
- Gateway.

### Liens

- Lien du frontend Angular : [Repo Frontend](https://github.com/othsoh/ecom-microServiceApp-Front-angular/)
- Lien du ChatBot RAG : [Repo Frontend](https://github.com/othsoh/RAG-chatBot/)

---

## Base de Données : H2 Database

La base de données H2 a été choisie pour simplifier le développement. Elle permet un stockage en mémoire rapide et est facile à intégrer avec Spring Boot.

### Classes
![class-micro-service (3)](https://github.com/user-attachments/assets/f8449953-cf74-4c93-9095-e0fd39d11cc3)

---

## Fonctionnalités Clés

1. Gestion des produits : CRUD sur les produits.
2. Gestion des clients : Enregistrement et consultation des clients.
3. Gestion des commandes : Création et suivi des commandes.
4. Facturation : Génération des factures.
5. Gateway API : Accès centralisé et routage des services.

---

## Captures d'écran

### Get Customers
![image](https://github.com/user-attachments/assets/24eed515-5905-465d-a8c2-adfb03dc6213)

### Get Products
![image](https://github.com/user-attachments/assets/519e7d87-0c8b-4fd0-85eb-74e5b1b0b4d7)

### Get Bills
![image](https://github.com/user-attachments/assets/2ffe302d-6d96-42d6-bcac-7bcaeef816c3)

### Get Full Bill
![image](https://github.com/user-attachments/assets/46dcd272-2b19-47ac-aae9-3e7cda4725b2)

### Get Bills By Customer
![image](https://github.com/user-attachments/assets/ecad5e16-b1dd-41d5-8110-01c4f8a53bc5)

---

## Conclusion

Le backend offre une architecture modulaire et scalable grâce à Spring Boot. Tous les services peuvent être déployés indépendamment, offrant une grande flexibilité.  

- Le code source du frontend peut être trouvé ici : [Repo Frontend](https://github.com/othsoh/ecom-microServiceApp-Front-angular/)
- Lien du ChatBot RAG : [Repo Frontend](https://github.com/othsoh/RAG-chatBot/)


---

© 2024 Projet Académique - Application E-commerce Microservices (Backend)
