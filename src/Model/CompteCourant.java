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
        if (montant <= 0){
            throw new IllegalArgumentException("Le montant doit etre positif");
        }
        if(solde - montant >= -decouvert){
            setSolde(solde-montant);
            Retrait retrait = new Retrait(UUID.randomUUID(),LocalDate.now(),montant,destination);
            ajouterOperation(retrait);
            System.out.println("vous avez retirer ce montant " + montant + " votre solde : " + getSolde());
        }else{
            throw new IllegalStateException("Solde insuffisant pour effectuer le retrait");
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
    public void virement(double montant , Compte destinataire , Compte source , Source typeSource , Destination destination){
//        double soldeA = destinataire.getSolde();
//        double soldeB = source.getSolde();
//
//        setSolde(soldeA + montant);
//        setSolde(soldeB - montant);

        source.retirer(montant,destination);
        destinataire.versement(montant,typeSource);

        System.out.println("virement effectuer avec success ");


    }

}
