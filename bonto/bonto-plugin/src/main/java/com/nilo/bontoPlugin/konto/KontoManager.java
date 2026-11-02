package com.nilo.bontoPlugin.konto;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class KontoManager {
    private static HashMap<String, Konto> kontos = new HashMap<>();

    public static void init() {
        for (int i = 0; i < 3; i++) {
            Konto konto = new Konto();
            kontos.put(konto.getId(), konto);
        }
        for (int i = 0; i < 2; i++) {
            Konto konto = new Sparkonto();
            kontos.put(konto.getId(), konto);
        }
        for (int i = 0; i < 5; i++) {
            Konto konto = new Konto();
            kontos.put(konto.getId(), konto);
        }
    }

    public static Konto get(String kontoId) {
        return kontos.get(kontoId);
    }

    public static Collection<Konto> getAll() {
        return kontos.values();
    }

    public static void buchen(String kontoId, double betrag) {
        buchen(kontos.get(kontoId), betrag);
    }

    public static void buchen(Konto konto, double betrag) {
        konto.buchen(betrag);
    }

    public static ItemStack getKontoItem(String id) {
        return getKontoItem(kontos.get(id));
    }

    public static ItemStack getKontoItem(Konto konto) {
        int amount = konto.getValue() <= 0 ? 1 : (int) konto.getValue();

        ItemStack item = new ItemStack(konto.getMaterial(), amount);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.displayName(
                Component.text(konto.getType()).color(konto.getTextColor())
                        .appendSpace()
                        .append(
                                Component.text(konto.getValue()).color(TextColor.color(0, 0, 255))
                        )
        );
        itemMeta.lore(
                List.of(
                        Component.text(konto.getId()).color(TextColor.color(128, 128, 128))
                )
        );

        item.setItemMeta(itemMeta);
        return item;
    }
}
