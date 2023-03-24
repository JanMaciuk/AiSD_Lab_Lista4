import java.util.Scanner;

public class Main { //TODO zadanie za 4 punkty, odwracanie i sortowanie
    public static void main(String[] args) {
        System.out.println("Wpisz ciąg znaków do sprawdzenia zrównoważenia nawiasów:");
        Scanner scan = new Scanner(System.in);
        String wyrazenie = scan.nextLine();
        boolean zrownowazone;
        try {
            zrownowazone = Nawiasy.nawiasyZrownowazone(wyrazenie);
            if (zrownowazone) { System.out.println("Nawiasy zrównoważone"); }
            else { System.out.println("Nawiasy niezrównoważone"); }
        }
        catch (FullStackException | EmptyStackException e) {
            System.out.println("Niespodziewany błąd przy obsłudze stosu: " + e.getMessage()); }

    }
}
