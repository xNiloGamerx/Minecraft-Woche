import konto.Konto;
import konto.KontoManager;

import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        KontoManager.init();

        while (true) {
            start();
            System.out.println();

            System.out.print("Möchtest du das Menü verlassen? (y/n)\n>> ");
            String option = scanner.nextLine();

            if (option.equals("y")) {
                printOverview();
                break;
            }
        }
    }

    public static void start() {
        System.out.println("Wähle eine Konto:");
        Collection<Konto> kontos = printOverview();
        System.out.print(">> ");
        Konto selectedKonto = (Konto) kontos.toArray()[scanner.nextInt()];
        scanner.nextLine();

        System.out.print("Mächtest du einzahlen oder auszahlen? (e/a)\n>> ");
        String selectedOption = scanner.nextLine();

        int betrag;
        switch (selectedOption) {
            case "e":
                System.out.print("Wie viel möchtest du einzahlen?\n>> ");
                betrag = scanner.nextInt();
                KontoManager.buchen(selectedKonto, betrag);
                break;
            case "a":
                System.out.print("Wie viel möchtest du auszahlen?\n>> ");
                betrag = scanner.nextInt();
                KontoManager.buchen(selectedKonto, betrag * -1);
                break;
            default:
                System.out.println("Die gewählte Option existiert nicht!");
                break;
        }
        scanner.nextLine();
    }

    public static Collection<Konto> printOverview() {
        Collection<Konto> kontos = KontoManager.getAll();
        for (int i = 0; i < kontos.size(); i++) {
            Konto k = (Konto) kontos.toArray()[i];
            System.out.println("\t" + i + ". '" + k.getId() + "' [" + k.getType() + "]: " + k.getValue());
        }
        return kontos;
    }
}