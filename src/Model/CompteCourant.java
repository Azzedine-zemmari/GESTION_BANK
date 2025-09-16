package Model;

public class CompteCourant extends Compte{
    private int decouvert;
    public CompteCourant(double solde , int dec){
        super(solde);
        this.decouvert = dec;
    }

    public void retirer(double montant){
        if(getSolde()-getDecouvert() >= montant){
            setSolde((getSolde() + getDecouvert())-montant);
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
}
