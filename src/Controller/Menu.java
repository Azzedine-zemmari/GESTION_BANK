package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final ArrayList<Compte> comptes;

    public Menu() {
        scanner = new Scanner(System.in);
        comptes = new ArrayList<>();
    }

    public void start() {
        boolean quitter = true;
        while (quitter) {
            try {

                System.out.println("menu:");
                System.out.println("1 . cree compte");
                System.out.println("2 . verser a votre compte ");
                System.out.println("3 . afficher tout les compte ");
                System.out.println("4 . afficher solde d'un compte ");
                System.out.println("5 . afficher details du compte ");
                System.out.println("6 . retirer ");
                System.out.println("7 . virement ");
                System.out.println("8 . calcul interet");
                System.out.println("0 . quitter ");

                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        creeCompte();
                        break;
                    case 2:
                        verser();
                        break;
                    case 3:
                        afficherComptes();
                        break;
                    case 4:
                        afficherSolde();
                        break;
                    case 5:
                        afficherDetails();
                        break;
                    case 6:
                        retirer();
                        break;
                    case 7:
                        virement();
                        break;
                    case 8:
                        calculInteret();
                        break;
                    case 0:
                        quitter = false;
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur vous devez enter nomber");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(" une erreur : " + e.getMessage());
            }
        }
    }

    public void creeCompte() {
        try {

            System.out.println("Cree compte :");
            System.out.println("1 . compte courant ");
            System.out.println("2 . compte depagne ");
            System.out.println("******************");
            int account = scanner.nextInt();
            scanner.nextLine();
            switch (account) {
                case 1:
                    System.out.println("Entrer votre solde ");
                    double solde = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Entrer votre decouvert ");
                    double decouvert = scanner.nextDouble();
                    scanner.nextLine();
                    CompteCourant cc = new CompteCourant(solde, decouvert);
                    comptes.add(cc);
                    System.out.println("Compte courant cree avec success");
                    break;
                case 2:
                    System.out.println("Entrer votre solde ");
                    Double SOLDE = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Entrer votre taux interet ");
                    Double tauxIntert = scanner.nextDouble();
                    scanner.nextLine();
                    CompteDepagne dd = new CompteDepagne(SOLDE, tauxIntert);
                    comptes.add(dd);
                    System.out.println(dd);

                    break;
                default:
                    System.out.println("Choix invalide (1 ou 2 seulement)");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : vous devez entrer un nombre valide !");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }

    // search for account by his code
    public static Compte findByCode(ArrayList<Compte> comptes, String code) {
        for (Compte c : comptes) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public void verser() {
        try {

            System.out.println("enter the code CPT-XXXXX :  ");
            String code = scanner.nextLine();
            Compte ACCOUNT = findByCode(comptes, code);
            if (ACCOUNT != null) {

                System.out.println("enter solde du versement ");
                double soldeVers = scanner.nextDouble();
                scanner.nextLine();

                if (soldeVers <= 0) throw new IllegalArgumentException("Montant invalide (doit être positif).");

                System.out.println("Quelle method tu prefere pour verser : ");
                System.out.println("------------------------");
                for (int i = 0; i < Source.values().length; i++) {
                    System.out.println((i + 1) + " " + Source.values()[i]);
                }
                System.out.println("------------------------");

                int choixSource = scanner.nextInt();
                scanner.nextLine();

                if (choixSource < 1 || choixSource > Source.values().length) {
                    throw new IllegalArgumentException("Choix de source invalide.");
                }
                Source source = Source.values()[choixSource - 1];
                ACCOUNT.versement(soldeVers, source);
                System.out.println("Versement done ");
            } else {
                System.out.println("compte NOT found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur vous devez enter nomber");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }

    private void afficherComptes() {
        if (comptes.isEmpty()) {
            System.out.println(" Aucun compte enregistré !");
        } else {
            for (Compte c : comptes) {
                System.out.println(c);
            }
        }
    }

    private void afficherSolde() {
        System.out.println("enter the code CPT-XXXXX ");
        String CPT = scanner.nextLine();
        Compte compt = findByCode(comptes, CPT);
        if (compt != null) {
            System.out.println("solde : " + compt.getSolde());
        } else {
            System.out.println("CPT NOT found");
        }
    }

    private void afficherDetails() {
        System.out.println("enter the code CPT-XXXXX ");
        String code = scanner.nextLine();
        Compte acc = findByCode(comptes, code);
        if (acc != null) {
            acc.afficherDetails();
        } else {
            System.out.println("CPT NOT found");
        }
    }

    private void retirer() {
        try {

            System.out.println("enter the code CPT-XXXXX");
            String cp = scanner.nextLine();
            Compte ac = findByCode(comptes, cp);
            if (ac != null) {
                System.out.println("enter solde du retirer ");
                double soldeRetr = scanner.nextDouble();
                scanner.nextLine();
                if (soldeRetr <= 0) throw new IllegalArgumentException("Montant doit être positif !");
                System.out.println("Method de retirer :");
                for (int i = 0; i < Destination.values().length; i++) {
                    System.out.println((i + 1) + " " + Destination.values()[i]);
                }

                int DestChoice = scanner.nextInt();
                scanner.nextLine();

                if (DestChoice < 1 || DestChoice > Destination.values().length) {
                    throw new IllegalArgumentException("Choix de destination invalide !");
                }

                Destination dest = Destination.values()[DestChoice - 1];
                ac.retirer(soldeRetr, dest);
            } else {
                System.out.println("Compte not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : entrez un nombre valide !");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(" Erreur : " + e.getMessage());
        }
    }

    private void virement() {
        try {

            System.out.println("enter the code du source CPT-XXXXX");
            String Cp1 = scanner.nextLine();
            Compte Ac1 = findByCode(comptes, Cp1);

            System.out.println("enter the code destinataire CPT-XXXXX");
            String Cp2 = scanner.nextLine();
            Compte Ac2 = findByCode(comptes, Cp2);

            if (Ac1 != null && Ac2 != null) {
                System.out.println("enter solde du versement ");
                double soldeVerm = scanner.nextDouble();
                scanner.nextLine();

                if (Ac1.getSolde() < soldeVerm) throw new IllegalArgumentException("Solde insuffisant");

                if (soldeVerm <= 0) throw new IllegalArgumentException("Montant doit être positif !");

                // type source du virement
                System.out.println("source du virement : ");
                for (int i = 0; i < Source.values().length; i++) {
                    System.out.println((i + 1) + " " + Source.values()[i]);
                }
                int choixSource = scanner.nextInt();
                scanner.nextLine();

                if (choixSource < 0 || choixSource > Source.values().length) {
                    throw new IllegalArgumentException("Choix source invalide !");
                }

                Source source = Source.values()[choixSource - 1];
                // type du destination du virement
                System.out.println("destination du virement : ");
                for (int i = 0; i < Destination.values().length; i++) {
                    System.out.println((i + 1) + " " + Destination.values()[i]);
                }
                int choixDestination = scanner.nextInt();
                scanner.nextLine();

                if (choixDestination < 0 || choixDestination > Source.values().length) {
                    throw new IllegalArgumentException("Choix Destination invalide !");
                }
                Destination destination = Destination.values()[choixDestination - 1];

                Ac1.virement(soldeVerm, Ac2, Ac1, source, destination);
                System.out.println("Versement done ");
            } else {
                System.out.println("CPT not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : entrer un nombre invalide");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }

    private void calculInteret() {
        try {
            System.out.println("Entrer votre compte : CPT-XXXXX");
            String compte = scanner.nextLine();
            Compte account = findByCode(comptes, compte);
            if (account != null && account instanceof CompteDepagne) {
                account.calculerInteret();
                System.out.println(" Intérêt calculé avec succès !");
            } else {
                System.out.println("votre compte n exsite pas ");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du calcul d’intérêt : " + e.getMessage());
        }
    }

}
