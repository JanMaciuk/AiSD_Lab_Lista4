import java.util.Scanner;

public class Main { //TODO zadanie za 4 punkty, kopiowanie używając tylko zmiennych
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            zrownowazenieCheck();
            polindromCheck();
            przenoszeniePomocniczyStos();
        } catch (Exception e) {
            e.printStackTrace();
// To nie jest dobry sposób obsługi błędów, ale w tych metodach wszystkie stosy mają sprawdzaną długość, i są w warunkach sprawdzających że nie są puste
        }
    }

    public static void zrownowazenieCheck() throws FullStackException, EmptyStackException {
        System.out.println("Wpisz ciąg znaków do sprawdzenia zrównoważenia nawiasów:");
        String wyrazenie = scan.nextLine();
        boolean zrownowazone;
        zrownowazone = Nawiasy.nawiasyZrownowazone(wyrazenie);
        if (zrownowazone) { System.out.println("Nawiasy zrównoważone"); }
        else { System.out.println("Nawiasy niezrównoważone"); }

    }

    public static void polindromCheck() throws FullStackException, EmptyStackException {
        System.out.println("Podaj wyrażenie do sprawdzenia polindromiczności:");
        String napis = scan.nextLine();
        ArrayStack<Character> stack = new ArrayStack<>(napis.length());
        for (char ch: napis.toCharArray()) {
             stack.push(ch);
        }
        for (char ch: napis.toCharArray()) {
                if (ch != stack.pop()) { System.out.println("Wyrażenie nie jest polindromem");return; }
        }
        System.out.println("Wyrażenie jest polindromem");
}

    public static void przenoszeniePomocniczyStos() throws FullStackException, EmptyStackException {
        System.out.println("podaj jakiś ciąg znaków do testów:");
        String napis = scan.nextLine();
        ArrayStack<Character> S1 = new ArrayStack<>(napis.length());
        ArrayStack<Character> SP = new ArrayStack<>(napis.length());
        ArrayStack<Character> S2 = new ArrayStack<>(napis.length());

        for (char ch: napis.toCharArray()) {
            try { S1.push(ch); }
            catch (FullStackException e) { e.printStackTrace(); }
        }

        while (!S1.isEmpty()) {
             SP.push(S1.pop());
        }
        while (!SP.isEmpty()) {
             S2.push(SP.pop());  // Dodawanie elementów do nowego stosu odwraca kolejność, więc robie to 2 razy
        }
        for (char ch: napis.toCharArray()) {
             S1.push(ch);  // przywracam oryginalny S1

        }

        while (!S1.isEmpty()) {
             //Sprawdzam czy elementy są takie same, jeżeli tak to są w dobrej kolejności
                if (S1.pop() != S2.pop()) { System.out.println("Błąd");return; }
        }
        System.out.println("Przenoszenie udane");

    }

    public static void przenoszenieZmienne() { //TODO
        System.out.println("podaj jakiś ciąg znaków do testów:");
        String napis = scan.nextLine();
        ArrayStack<Character> S1 = new ArrayStack<>(napis.length());
        ArrayStack<Character> S2 = new ArrayStack<>(napis.length());


    }
}
