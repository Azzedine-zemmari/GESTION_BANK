package Model;

import sun.security.krb5.internal.crypto.Des;

import java.time.LocalDate;
import java.util.UUID;

public class CompteCourant extends Compte{
    private int decouvert;
    public CompteCourant(double solde , int decouvert){
        super(solde);
        this.decouvert = decouvert;
    }

    public void retirer(double montant, Destination destination){
        double total = getSolde() + getDecouvert();
        if(total >= montant){
            setSolde(total-montant);
            Retrait retrait = new Retrait(UUID.randomUUID(),LocalDate.now(),montant,destination);
            ajouterOperation(retrait);
            System.out.println("vous avez retirer ce montant " + montant + " votre solde : " + getSolde());
        }else{
            System.out.println("Vous avez rien a retire (ghyreha)");
        }
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    public double calculerInteret(){
        return 0;
    }
    public void afficherDetails(){
        System.out.println("Details : \n" + "Code : "+ getCode()+ "\n" + "Sold : "+ getSolde() + "Operation ");
        for(int i = 0;i<getListOperation().size();i++){
            System.out.println(getListOperation().get(i) + "\n");
        }
    }


    @Override
    public String toString() {
        return "CompteCourant{" +
                "decouvert=" + decouvert + " solde " + solde + " code " + code +
                '}';
    }

    public void versement(double montant,Source source){
        setSolde(getSolde()+montant);
        Versement v = new Versement(UUID.randomUUID(), LocalDate.now(),montant, source);
        ajouterOperation(v);
        System.out.println("versement effectuer avec success ");
        }

}
