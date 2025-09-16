package Model;

public class CompteDepagne extends Compte {
    private int tauxIntert;
    public CompteDepagne(double sold,int taux){
        super(sold);
        tauxIntert = taux;
    }

    public int getTauxIntert() {
        return tauxIntert;
    }

    public void setTauxIntert(int tauxIntert) {
        this.tauxIntert = tauxIntert;
    }

    public void retirer(double montant){
        if(getSolde() >= montant){
            setSolde(getSolde()-montant);
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
    public double calculerInteret(){
        return 0;
    }

    @Override
    public String toString() {
        return "CompteDepagne{" +
                "tauxIntert=" + tauxIntert +
                " solde " + solde +
                " code " + code +
                '}';
    }

    public void versement(double montant){
        setSolde(getSolde()+montant);
        System.out.println("versement effectuer avec success ");
    }
}
