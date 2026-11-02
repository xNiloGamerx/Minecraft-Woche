package com.nilo.bontoPlugin.konto;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Konto {
    private String id;
    private double value;
    private String type;
    private Material material;
    private TextColor textColor;

    public Konto() {
        buildId();
        this.value = 0.0;
        this.type = "konto";
        this.material = Material.GOLDEN_CARROT;
        this.textColor = TextColor.color(0, 255, 0);
    }

    public Konto(String type, Material material, TextColor textColor) {
        buildId();
        this.value = 0.0;
        this.type = type;
        this.material = material;
        this.textColor = textColor;
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

    public Material getMaterial() {
        return material;
    }

    public TextColor getTextColor() {
        return textColor;
    }
}
