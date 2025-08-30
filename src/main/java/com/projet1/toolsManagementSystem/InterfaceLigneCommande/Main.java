package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static Scanner userInput = new Scanner(System.in);
    private static Organization organizationA;
    private static Organization oraganizationB;
    private static User currentUser;

    public static void main(String[] args) {
        loadAllTestData();
        startApplication();
        userInput.close();
    }

    // Chargement des données de test
    private static void loadAllTestData() {
        // Initialisation des organisations
        organizationA = new Organization("Organisation A");
        oraganizationB = new Organization("Organisation B");


        // Ajout des utilisateurs pour l'organisation A
        organizationA.addUser(new OrganizationAdmin("ADMIN1", "Abass SARR", organizationA));
        organizationA.addUser(new Employee("E1", "Alice", organizationA));
        organizationA.addUser(new Employee("E2", "Bob", organizationA));
        organizationA.addUser(new Volunteer("V1", "Charlie", organizationA));
        organizationA.addUser(new Volunteer("V2", "Diana", organizationA));

        // Création des outils pour l'organisation A
        organizationA.addTool(new Tool("101", "Marteau"));
        organizationA.addTool(new Tool("102", "Tournevis"));
        organizationA.addTool(new Tool("103", "Perceuse"));


        // Création des utilisateurs pour l'organisation B
        oraganizationB.addUser(new OrganizationAdmin("ADMIN2", "Abdou Karim DIOP", oraganizationB));
        oraganizationB.addUser(new Employee("E3", "Edward", oraganizationB));
        oraganizationB.addUser(new Employee("E4", "Fiona", oraganizationB));
        oraganizationB.addUser(new Volunteer("V3", "George", oraganizationB));

        // Création des outils pour l'organisation B
        oraganizationB.addTool(new Tool("201", "Cie"));
        oraganizationB.addTool(new Tool("202", "Pince"));


        System.out.println("Initialisation des données terminée!");
        System.out.println("\nUtilisateurs disponibles pour la connexion:");
        System.out.println("Administrateurs: ADMIN1, ADMIN2");
        System.out.println("Employés: E1, E2, E3, E4");
        System.out.println("Bénévoles: V1, V2, V3");
    }
    

    // Démarrer le programme
    private static void startApplication() {
        boolean isAppRunning = true;
        while (isAppRunning) {
            displayWelcomeMenu();
            int choice = getInputOption("Choisissez une option: ");
            
            if (choice == 0) {
                System.out.println("Au revoir!");
                isAppRunning = false;
                break;
            } else if (choice == 1) {
                login();
            } else {
                System.out.println("Option invalide, Veuillez réessayer.");
            }
        }
    }

    // Retourver l'input ou l'option du cliet
    private static int getInputOption(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    // Afficher le menu principal
    private static void displayWelcomeMenu() {
        System.out.println("\n=====================================");
        System.out.println("    Système de Gestion d'Outils   ");
        System.out.println("=====================================");

        System.out.println("1- Se connecter");
        System.out.println("0- Quitter");

        System.out.println("=====================================");
    }

    // Se connecter
    private static void login() {
        System.out.println("\n=== Connexion ===");
        System.out.print("Entrez votre ID utilisateur: ");
        String userId = userInput.nextLine();
        
        currentUser = findUser(userId);
        if (currentUser != null) {
            System.out.println("Bienvenue, " + currentUser.getName() + "!");
            displayUserMenu();
        } else {
            System.out.println("Utilisateur non trouvé!");
        }
    }

    private static void displayUserMenu() {
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("\n=== Menu Principal - " + currentUser.getName() + " ===");
            if (currentUser instanceof OrganizationAdmin) {
                dispplayAdminMenu();
            } else if (currentUser instanceof IToolUser) {
                displayUserMenu((IToolUser) currentUser);
            }
            
            System.out.println("\nVoulez-vous continuer? (1 pour continuer, 0 pour se déconnecter)");
            int choice = getInputOption("Votre choix: ");
            if (choice == 0) {
                continueMenu = false;
                System.out.println("Déconnexion...");
            } else if (choice != 1) {
                System.out.println("Option invalide! Veuillez choisir 0 ou 1.");
            }
        }
    }

    // Afficher le menu admin (Admin Organisation) et ses options
    private static void dispplayAdminMenu() {
        OrganizationAdmin admin = (OrganizationAdmin) currentUser;
        System.out.println("1. Afficher tous les outils");
        System.out.println("2. Afficher les outils disponibles");
        System.out.println("3. Afficher tous les employés");
        System.out.println("4. Afficher tous les bénévoles");
        System.out.println("5. Afficher l'historique d'utilisation des outils");
        System.out.println("0. Retour");
        
        int choice = getInputOption("Votre choix: ");
        switch (choice) {
            case 1: 
                admin.displayAllTools();
                 break;
            case 2: 
                admin.displayAvailableTools(); 
                break;
            case 3: 
                admin.displayAllEmployees(); 
                break;
            case 4: 
                admin.displayAllVolunteers(); 
                break;
            case 5: 
                displayToolUsageHistory(admin); break;
            case 0: return;

            default: System.out.println("Option invalide!");
        }
    }

    // Afficher le menu utilisateur (Volontaire et Employé) et ses options
    private static void displayUserMenu(IToolUser user) {
        System.out.println("1. Afficher les outils disponibles");
        System.out.println("2. Emprunter un outil");
        System.out.println("3. Retourner un outil");
        System.out.println("0. Retour");
        
        int choice = getInputOption("Votre choix: ");
        switch (choice) {
            case 1:
                // ((User) user).displayAvailableTools();
                if(user instanceof Employee) {
                    ((Employee) user).displayAvailableTools();
                } else if(user instanceof Volunteer) {
                    ((Volunteer) user).displayAvailableTools();
                }
                break;
            case 2:
                if(user instanceof Employee) {
                    occupyTool((Employee) user);
                } else if(user instanceof Volunteer) {
                    occupyTool((Volunteer) user);
                }
                break;
            case 3:
                if(user instanceof Employee) {
                    releaseTool((Employee) user);
                } else if(user instanceof Volunteer) {
                    releaseTool((Volunteer) user);
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Option invalide!");
        }
    }

    // Emprunt d'outil par un employé
    private static void occupyTool(Employee employee) {
        System.out.print("Entrez l'ID de l'outil à emprunter: ");
        String toolId = userInput.nextLine();
        try {
            employee.occupyTool(toolId, employee.getId());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // Retour d'outil par un employé
    private static void releaseTool(Employee employee) {
        System.out.print("Entrez l'ID de l'outil à retourner: ");
        String toolId = userInput.nextLine();
        try {
            employee.releaseTool(toolId, employee.getId());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // Emprunt d'outil par un bénévole
    private static void occupyTool(Volunteer volunteer) {
        System.out.print("Entrez l'ID de l'outil à emprunter: ");
        String toolId = userInput.nextLine();
        try {
            volunteer.occupyTool(toolId, volunteer.getId());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // Retour d'outil par un bénévole
    private static void releaseTool(Volunteer volunteer) {
        System.out.print("Entrez l'ID de l'outil à retourner: ");
        String toolId = userInput.nextLine();
        try {
            volunteer.releaseTool(toolId, volunteer.getId());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    private static User findUser(String userId) {
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(organizationA.getAllUsers());
        allUsers.addAll(oraganizationB.getAllUsers());
        return allUsers.stream().filter(user -> user.getId().equals(userId))
            .findFirst().orElse(null);
    }


    private static void displayToolUsageHistory(OrganizationAdmin admin) {
        System.out.println("\n=== Historique d'utilisation des outils ===");
        List<Tool> tools = admin.getOrganization().getAllTools();
        
        if (tools.isEmpty()) {
            System.out.println("Aucun outil dans l'organisation.");
            return;
        }

        System.out.println("Choisissez un outil pour voir sonhistorique:");
        for (int i = 0; i < tools.size(); i++) {
            System.out.println((i + 1) + ". " + tools.get(i).getName() + " (ID: " + tools.get(i).getId() + ")");
        }
        // System.out.println("0. Retour");

        int choice = getInputOption("Votre choix: ");
        if (choice > 0 && choice <= tools.size()) {
            Tool selectedTool = tools.get(choice - 1);
            System.out.println("\nHistorique d'utilisation pour " 
            + selectedTool.getName() + ": ");
            List<Usage> usageHistory = selectedTool.getUsageHistory();
            if (usageHistory.isEmpty()) {
                System.out.println("Aucun historique d'utilisation pour cet outil.");
            }
        } else if (choice != 0) {
            System.out.println("Choix invalide!");
        }
    }


}

