package Polyaeva;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Process {
    static AtomicInteger numberForLength3 = new AtomicInteger(0);
    static AtomicInteger numberForLength4 = new AtomicInteger(0);
    static AtomicInteger numberForLength5 = new AtomicInteger(0);

    public static void isPalindrom(String[] texts) {
        for (String string :
                texts) {
            String reversed = new StringBuilder(string).reverse().toString();
            if (string.equals(reversed)) {
                addToAtomicInteger(string);
            }
        }
    }

    public static void isUniqueLetters(String[] texts) {
        for (String string :
                texts) {
            Set<Character> unigue = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                unigue.add(string.charAt(i));
            }
            if (unigue.size() == 1) {
                addToAtomicInteger(string);
            }
        }
    }

    public static void isAlphabetical(String[] texts) {
        for (String string : texts) {
            List<Character> chars = new ArrayList<>();
            for (char ch : string.toCharArray()) {
                chars.add(ch);
            }
            Collections.sort(chars);
            String result = chars.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            if (string.equals(result)) {
                addToAtomicInteger(string);
            }
        }

    }

    public static void addToAtomicInteger(String string) {
        if (string.length() == 3) {
            numberForLength3.getAndIncrement();
        } else if (string.length() == 4) {
            numberForLength4.getAndIncrement();
        } else if (string.length() == 5) {
            numberForLength5.getAndIncrement();
        }
    }
}
