public class Nawiasy {
    public static boolean zawieraNawiasy = false;
    static boolean nawiasOtwierajacy(char ch) {
        return (ch == '(' || ch == '{' || ch == '[');
    }
    static boolean nawiasZamykajacy(char ch) {
        return (ch == ')' || ch == '}' || ch == ']');
    }
    static int rodzajNawiasu(char ch) {
        if (nawiasOtwierajacy(ch)) { zawieraNawiasy = true; return 1; }
        if (nawiasZamykajacy(ch)) { zawieraNawiasy= true; return 0; }
        return 5; // jeżeli to nie jest nawias
    }
    static boolean nawiasyZgodne(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
    public static boolean nawiasyZrownowazone(String wyrazenie) throws FullStackException, EmptyStackException {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (char ch: wyrazenie.toCharArray()) {
            switch (rodzajNawiasu(ch)) {
                case 1 -> stack.push(ch); // nawias otwierający dodaje do stosu
                case 0 -> { if (stack.isEmpty()||!nawiasyZgodne(stack.pop(), ch)) { return false; } } // nawias zamykający, jeżeli jest niezrównoważony to zwracam false.
            }
        }
        if (!zawieraNawiasy) {
            System.out.println("Brak nawiasów w wyrażeniu");
            return false;  //Zakładam, że wyrażenie bez nawiasów nie może być zrównoważone, ale zależy od definicji
        }
    return stack.isEmpty();  // upewniam się, że nie ma niezamkniętych nawiasów
    }

}
