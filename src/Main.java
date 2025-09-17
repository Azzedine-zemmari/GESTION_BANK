import Model.Compte;
import Model.CompteCourant;
import Model.CompteDepagne;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        ArrayList<Compte> comptes = new ArrayList<>();

        boolean quitter = true;
        while(quitter){
            System.out.println("menu:");
            System.out.println("1 . cree compte");
            System.out.println("2 . verser a votre compte ");
            System.out.println("3 . retirer a votre compte ");
            System.out.println("4 . verser a un autre compte ");
            System.out.println("5 . Quitter ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1 :
                    System.out.println("Cree compte :");
                    System.out.println("1 . compte courant ");
                    System.out.println("2 . compte depagne ");
                    int account = scanner.nextInt();
                    scanner.nextLine();
                    switch (account){
                        case 1:
                            System.out.println("Entrer votre solde ");
                            double solde = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Entrer votre decouvert ");
                            int decouvert = scanner.nextInt();
                            scanner.nextLine();
                            CompteCourant cc = new CompteCourant(solde,decouvert);
                            comptes.add(cc);
                            System.out.println("Compte courant cree avec success");
                            break;
                        case 2:
                            System.out.println("Entrer votre solde ");
                            double SOLDE = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Entrer votre taux interet ");
                            int tauxIntert = scanner.nextInt();
                            scanner.nextLine();
                            CompteDepagne dd = new CompteDepagne(SOLDE,tauxIntert);
                            comptes.add(dd);
                            System.out.println("Compte debagne et cree par sucess");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("enter the code CPT-XXXXX ");
                    String code = scanner.nextLine();
                    Compte ACCOUNT = findByCode(comptes,code);
                    if(ACCOUNT != null){
                        System.out.println("enter solde du versement ");
                        double soldeVers = scanner.nextDouble();
                        scanner.nextLine();
                        ACCOUNT.versement(soldeVers);
                        System.out.println("Versement done ");
                    }
                    else{
                        System.out.println("CPT NOT found");
                    }
                    break;
                case 3:
                    for(int i = 0;i<comptes.size();i++){
                        System.out.println(comptes.get(i));
                    }
                    break;
                case 4:
                    System.out.println("enter the code CPT-XXXXX ");
                    String CPT = scanner.nextLine();
                    Compte compt = findByCode(comptes,CPT);
                    System.out.println("solde : " + compt.getSolde());
                    break;
            }
        }
    }
    // search for account by his code
    public static Compte findByCode(ArrayList<Compte> comptes,String code){
        for(Compte c : comptes){
            if(c.getCode().equals(code)){
                return c;
            }
    }
        return null;
    }

}