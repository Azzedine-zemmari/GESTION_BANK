package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Retrait extends Operation {
    private Destination destination;
    public Retrait(UUID numero , LocalDate date, double montant , Destination destination){
        super(numero ,date,montant);
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Retrait{" + "numero= " + super.getNumero() + ", date=" + super.getDate() +
                ", montant=" + super.getMontant() +
                "destination=" + destination +
                '}';
    }
}
