package konto;

import java.util.Collection;
import java.util.HashMap;

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
        kontos.get(kontoId).buchen(betrag);
    }

    public static void buchen(Konto konto, double betrag) {
        kontos.get(konto.getId()).buchen(betrag);
    }
}
