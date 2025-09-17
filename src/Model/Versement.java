package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Versement extends Operation{
    private Source source;

    public Versement (UUID numero , LocalDate date , double montant , Source source ){
        super(numero,date,montant);
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Versement{" +
                "numero=" + super.getNumero() +
                ", date=" + super.getDate() +
                ", montant=" + super.getMontant() +
                ", source=" + source +
                '}';
    }
}
