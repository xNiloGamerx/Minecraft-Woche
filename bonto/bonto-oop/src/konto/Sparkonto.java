package konto;

public class Sparkonto extends Konto {
    private double zinsSatz;

    public Sparkonto() {
        super("sparkonto");
    }

    public double getZinsSatz() {
        return zinsSatz;
    }

    public void setZinsSatz(double z) {
        this.zinsSatz = z;
    }
}
