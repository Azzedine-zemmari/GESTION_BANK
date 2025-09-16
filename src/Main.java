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
        ArrayList<Object> comptes = new ArrayList<>();

        boolean quitter = true;
        while(quitter){
            System.out.println("menu:");
            System.out.println("1 . cree compte");
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
                case 2:
                    for(int i = 0;i<comptes.size();i++){
                        System.out.println(comptes.get(i));
                    }
                    break;
                case 3:
                    quitter = false;
                    System.out.println(" thalaaa ");
                    break;
            }
        }
    }
}