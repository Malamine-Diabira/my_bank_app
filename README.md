# Gestion d'une Banque avec une Architecture Microservices

Ce projet est une implémentation d'un système de gestion bancaire basé sur une **architecture orientée microservices**. Il utilise **Spring Boot** pour le backend et **Angular** pour le frontend, offrant une solution modulaire et scalable pour gérer les opérations bancaires.

## Architecture du projet

Le système est composé de plusieurs microservices indépendants, chacun avec sa propre base de données, et des mécanismes de réplication de données si nécessaire :

1. **ms-agences** : Gère la structure de la banque (siège et agences).
2. **ms-clients** : Gère les clients et leurs comptes bancaires.
3. **ms-transactions** : Gère les opérations bancaires (dépôts, retraits, virements, etc.).

Chaque microservice est construit avec **Spring Boot 3.2.2**, utilisant **JPA**, **MySQL**, et expose des API REST. Le frontend, développé avec **Angular**, offre une interface utilisateur intuitive pour interagir avec ces services.

## Fonctionnalités principales

- Gestion des agences bancaires.
- Création et gestion des clients et de leurs comptes.
- Réalisation d'opérations bancaires : dépôts, retraits, consultation de solde, relevés.
- Interface utilisateur responsive avec navigation via un menu principal.

## Prérequis

- **Java** : 17 ou 20
- **Maven** : Pour la gestion des dépendances backend
- **Node.js & npm** : Pour le frontend Angular
- **MySQL** : Base de données pour chaque microservice
- **IDE** : Eclipse ou tout autre IDE compatible avec Spring Boot et Angular

## Installation et configuration

### Backend (Microservices)
1. **Créer les bases de données MySQL** :
   - `banque_agence` pour `ms-agences`
   - (À compléter pour les autres microservices selon vos besoins)
2. **Configurer les fichiers `application.properties`** :
   - Mettre à jour les informations de connexion à la base de données (URL, utilisateur, mot de passe).
3. **Compiler et lancer chaque microservice** :
   ```bash
   cd ms-agences
   mvn package
   java -jar target/ms-agences.jar
   ```
   Répétez pour `ms-clients` et `ms-transactions`.

### Frontend (Angular)
1. **Installer les dépendances** :
   ```bash
   cd mybank-web-app
   npm install
   npm install bootstrap bootstrap-icons
   ```
2. **Configurer Bootstrap** dans `angular.json` (voir le document pour les détails).
3. **Lancer l'application** :
   ```bash
   ng serve
   ```
   Accédez à l'application via `http://localhost:4200`.

## Structure du projet

### Backend
- **`ms-agences`** : Gestion des agences (model, repository, service, controller).
- **`ms-clients`** : Gestion des clients et comptes (à implémenter).
- **`ms-transactions`** : Gestion des opérations bancaires (API pour dépôt, retrait, solde, etc.).

### Frontend
- **Composants Angular** : `menu-principal`, `nouveau-client`, `operation`, `detail-compte`, etc.
- **Services Angular** : Communication avec les API backend via HTTP.

## Utilisation

1. Lancez les microservices backend (`ms-agences`, `ms-clients`, `ms-transactions`).
2. Démarrez l'application Angular.
3. Accédez aux fonctionnalités via le menu principal :
   - Ajouter un nouveau client.
   - Effectuer un dépôt ou un retrait.
   - Consulter le solde ou le relevé d'un compte.

## Contribution

Les contributions sont les bienvenues ! Veuillez soumettre une pull request ou ouvrir une issue pour toute suggestion ou problème.

## License

Ce projet est sous licence [MIT](LICENSE).

