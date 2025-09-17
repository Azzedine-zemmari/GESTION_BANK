package Model;

import java.util.Date;
import java.util.UUID;

public abstract class Operation {
    private UUID numero;
    private Date date;
    private double montant;

    public Operation(UUID numero, Date date, double montant) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
    }

    public UUID getNumero() {
        return numero;
    }

    public void setNumero(UUID numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }
}
