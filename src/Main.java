import java.util.Scanner;
import java.util.Stack;

public class Main { //TODO zadanie za 4 punkty, kopiowanie używając tylko zmiennych
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
        try {
            System.out.println("""
                            Wybierz program do wykonania:
                            0. Wyjdź
                            1. Sprawdź zrównoważenie nawiasów w wyrażeniu
                            2. Sprawdzenie czy wyrażenie jest polindromem
                            3. Przenoszenie elementów stosu przy użyciu stosu pomocniczego
                            4. Przenoszenie elementów stosu przy użyciu zmiennych""");
            int wybor = scan.nextInt();
            scan.nextLine();
            switch (wybor) {
                case 0 -> running = false;
                case 1 -> zrownowazenieCheck();
                case 2 -> polindromCheck();
                case 3 -> przenoszeniePomocniczyStos();
                case 4 -> {}//todo
                default -> System.out.println("Zły numer opcji");
            }
        } catch (Exception e) {
            e.printStackTrace();
// To nie jest dobry sposób obsługi błędów, ale w tych metodach wszystkie stosy mają sprawdzaną długość, i są w warunkach sprawdzających że nie są puste
        }}
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
        ArrayStack<Character> stackReversed = new ArrayStack<>(napis.length());
        for (char ch: napis.toCharArray()) { stack.push(ch); }
        stackReversed = stack.reverse();
        while (!stack.isEmpty()) {
                if (stackReversed.pop() != stack.pop()) { System.out.println("Wyrażenie nie jest polindromem");return; }
        }
        System.out.println("Wyrażenie jest polindromem");
}

    public static void przenoszeniePomocniczyStos() throws FullStackException, EmptyStackException {
        System.out.println("podaj jakiś ciąg znaków do testów:");
        String napis = scan.nextLine();
        ArrayStack<Character> S1 = new ArrayStack<>(napis.length());
        ArrayStack<Character> SP = new ArrayStack<>(napis.length());
        ArrayStack<Character> S2 = new ArrayStack<>(napis.length());

        for (char ch: napis.toCharArray()) { S1.push(ch); }
        SP = S1.reverse();
        S2 = SP.reverse();

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
