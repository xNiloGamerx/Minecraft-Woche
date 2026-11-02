package konto;

import java.util.UUID;

public class Konto {
    private String id;
    private double value;
    private String type;

    public Konto() {
        buildId();
        this.value = 0.0;
        this.type = "konto";
    }

    public Konto(String type) {
        buildId();
        this.value = 0.0;
        this.type = type;
    }

    private void buildId() {
        this.id = UUID.randomUUID().toString();
    }

    public void buchen(double betrag) {
        this.value += betrag;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
