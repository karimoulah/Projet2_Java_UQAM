### **--- Application de Gestion des Outils d'une Organisation MGL 7010 Hiver2025 ---**

## Auteurs

* **Étudiant 1** : Abdoul Karime DIOP / **Courriel:** diop.abdoul_karime@courrier.uqam.ca/ ****Code Permenant**:**DIOA14279808
* **Étudiant 2** : Abass SARR / **Courriel:** sarr.abass@courrier.uqam.ca/ ****Code Permenant**:**SARA07349709

## Contexte du Projet

Dans le cadre du cours **MGL7010 - Programmation et Conception Détaillee Orientée Objet**, ce projet a pour objectif de développer une application de gestion des outils, des employés et des bénévoles au sein d’une organisation. Cette application permet de gérer l'occupation des outils, de suivre leur utilisation et d’organiser les ressources humaines (employés et bénévoles). Le développement est réalisé en **Java** en appliquant les concepts fondamentaux de la **programmation orientée objet** (POO).

## Installation

### Pré-requis

- Java Development Kit (JDK) 8 ou supérieur
- Un IDE comme Visual Studio Code, IntelliJ IDEA ou Eclipse

### Compilation et Exécution

Pour compiler et exécuter le programme, utilisez les commandes suivantes :

```sh
git clone https://gitlab.info.uqam.ca/diop.abdoul_karime/gestionoutilsorganisation.git

cd src/main/java/com/projet1/toolsManagementSystem/InterfaceLigneCommande

java Main.java
```

## Structure du Code

Voici une vue d'ensemble des principales classes et de leurs responsabilités dans le projet :

    **Classes Principales:**

* **Main** : Le point d'entrée du programme. Il initialise les organisations, les administrateurs, les outils, les employés et les bénévoles, puis affiche le menu principal et gère les interactions avec l'utilisateur.
* **Organization** : Représente une organisation avec des outils et des utilisateurs (employés et bénévoles).
* **OrganizationAdmin** : Représente un administrateur d'organisation. Hérite de la classe `User` et ajoute des méthodes pour afficher les outils et les utilisateurs.
* **Tool** : Représente un outil avec un identifiant, un nom, un état d'occupation et un historique d'utilisation.
* **Usage** : Représente l'historique d'utilisation d'un outil, avec des informations sur l'utilisateur, l'outil, la date de début et la date de fin.
* **User** : Classe abstraite représentant un utilisateur avec un identifiant, un nom et une organisation.
* **Employee** et **Volunteer** : Représentent respectivement un employé et un bénévole. Héritent de la classe **User**  et implémentent l'interface  **IToolUser.**
* **IToolUser** : Interface définissant les méthodes pour occuper et libérer un outil.

## Fonctionnalités

* Afficher tous les outils
* Occuper un outil
* Libérer un outil
* Afficher les outils disponibles
* Afficher les employés
* Afficher les bénévoles
* Afficher l'historique des outils

## Version du Projet

Version 1.0 : Execution de l'Application par interface ligne de commande

La version 1.1   sera la mise à jour de l'application pour faire un **API REST** avec l'integration de ****Spring Boot** **et  **Spring Data JPA** .** **

## Demo Video

[https://www.loom.com/share/1d477b80921748108b9c033fbe6a6b79](https://www.loom.com/share/1d477b80921748108b9c033fbe6a6b79)
