package Polyaeva;

import java.util.Random;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = Generator.generateText("abc", 3 + random.nextInt(3));
        }

        Thread thread1 = new Thread(() -> Process.isPalindrom(texts));
        Thread thread2 = new Thread(() -> Process.isUniqueLetters(texts));
        Thread thread3 = new Thread(() -> Process.isAlphabetical(texts));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Beautiful nicknames with length 3: " + Process.numberForLength3.get() + " pcs");
        System.out.println("Beautiful nicknames with length 4: " + Process.numberForLength4.get() + " pcs");
        System.out.println("Beautiful nicknames with length 5: " + Process.numberForLength5.get() + " pcs");
    }
}