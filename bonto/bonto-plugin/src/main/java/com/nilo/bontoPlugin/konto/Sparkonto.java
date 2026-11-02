package com.nilo.bontoPlugin.konto;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;

public class Sparkonto extends Konto {
    private double zinsSatz;

    public Sparkonto() {
        super("sparkonto", Material.BUBBLE_CORAL, TextColor.color(255, 0, 0));
    }

    public double getZinsSatz() {
        return zinsSatz;
    }

    public void setZinsSatz(double z) {
        this.zinsSatz = z;
    }
}
