package Model;

import java.util.ArrayList;

public abstract class Compte {
    protected static int competeur  = 0;
    protected String code;
    protected double solde;
    protected ArrayList<Operation> listOperation;


    public Compte(double solde) {
        this.code = CodeGenerator();
        this.solde = solde;
        this.listOperation = new ArrayList<>() ;
    }

    public String getCode(){
        return this.code;
    }

    public String CodeGenerator() {
        competeur++;
        return String.format("CPT-%05d", competeur);
    }

    public double getSolde(){
        return this.solde;
    }

    public void setSolde(double solde){
        this.solde = solde;
    }

    public ArrayList<Operation> getListOperation(){
        return this.listOperation;
    }

    public void setListOperation(ArrayList<Operation> listOperation){
        this.listOperation = listOperation;
    }
    public abstract void retirer(double montant);
    public abstract double calculerInteret();
    public abstract void afficherDetails();

}
