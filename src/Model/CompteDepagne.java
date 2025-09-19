package Model;

import java.time.LocalDate;
import java.util.UUID;

public class CompteDepagne extends Compte {
    private Double tauxIntert;
    public CompteDepagne(Double sold,Double taux){
        super(sold);
        tauxIntert = taux;
    }

    public Double getTauxIntert() {
        return tauxIntert;
    }

    public void setTauxIntert(Double tauxIntert) {
        this.tauxIntert = tauxIntert;
    }

    public void retirer(double montant,Destination destination){
        if(getSolde() >= montant){
            setSolde(getSolde()-montant);
            Retrait retrait = new Retrait(UUID.randomUUID(),LocalDate.now(),montant,destination);
            ajouterOperation(retrait);
            System.out.println("Vous avez retirer " + montant + " votre sole : "+ getSolde());
        }
        else{
            System.out.println("Vous avez rien (ghyareha)");
        }
    }

    public void afficherDetails(){
        System.out.println("Details : \n" + "Code : "+ getCode()+ "\n" + "Sold : "+ getSolde() + "Operation ");
        for(int i = 0;i<getListOperation().size();i++){
            System.out.println(getListOperation().get(i) + "\n");
        }
    }
    @Override
    public String toString() {
        return "CompteDepagne{" +
                "tauxIntert=" + tauxIntert +
                " solde " + solde +
                " code " + code +
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
    public void calculerInteret(){
        Double result = solde * tauxIntert;
        setSolde(solde + result);
        System.out.println("votre solde avec l interet et : " + solde);
    }

}
