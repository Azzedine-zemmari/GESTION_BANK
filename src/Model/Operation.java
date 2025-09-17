package Model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Operation {
    private UUID numero;
    private LocalDate date;
    private double montant;

    public Operation(UUID numero, LocalDate date, double montant) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
