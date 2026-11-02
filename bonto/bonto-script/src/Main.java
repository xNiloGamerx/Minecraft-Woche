import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Integer[]> kontos = new ArrayList<>();

    public static void main(String[] args) {
        createKontos();

        while (true) {
            start();
            System.out.println();

            System.out.print("Möchtest du das Menü verlassen? (y/n)\n>> ");
            String option = scanner.nextLine();

            if (option.equals("y")) {
                break;
            }
        }
    }

    public static void createKontos() {
        kontos.add(
                new Integer[]{45124, 0}
        );
        kontos.add(
                new Integer[]{92856, 0}
        );
        kontos.add(
                new Integer[]{27462, 0}
        );
    }

    public static void start() {
        System.out.println("Wähle ein Konto das du bearbeiten möchtest:");
        for (int i = 0; i < kontos.size(); i++) {
            Integer[] konto = kontos.get(i);
            System.out.println(i + ". '" + konto[0] + "': " + konto[1] + "€");
        }
        System.out.print(">> ");

        int selectedKontoIndex = scanner.nextInt(); // .nextInt() nimmt von 50\n nur 50. nextLine() konsumiert dann noch \n und dann geht es normal weiter
        scanner.nextLine(); //
        if (selectedKontoIndex < 0 || selectedKontoIndex >= kontos.size()) {
            System.out.println("Gewählter Kontoindex nicht erreichbar!");
            return;
        }
        Integer[] selectedKonto = kontos.get(selectedKontoIndex);

        System.out.print("Mächtest du einzahlen oder auszahlen? (e/a)\n>> ");
        String selectedOption = scanner.nextLine();

        int betrag;
        switch (selectedOption) {
            case "e":
                System.out.print("Wie viel möchtest du einzahlen?\n>> ");
                betrag = scanner.nextInt();
                buchen(selectedKonto[0], betrag);
                break;
            case "a":
                System.out.print("Wie viel möchtest du auszahlen?\n>> ");
                betrag = scanner.nextInt();
                buchen(selectedKonto[0], betrag * -1);
                break;
            default:
                System.out.println("Die gewählte Option existiert nicht!");
                break;
        }
        scanner.nextLine();
    }

    public static void buchen(int id, int betrag) {
        for (Integer[] konto : kontos) {
            if (konto[0] == id) {
                konto[1] += betrag;
                System.out.println("Konto '" + id + "' um " + betrag + "€ verändert!");
            }
        }
        System.out.println("Konto '" + id + "' nicht gefunden!");
    }
}
