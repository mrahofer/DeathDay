package org.example;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        try {
            System.out.println("Searching in the future...");
            TimeUnit.SECONDS.sleep(1);
            for (int i = 0; i < 4; i++) {
                System.out.println("Still searching in the future...");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(name +" will die on the " + getRandomDate() + "!");
    }

    public static String getRandomDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Calendar currentDate = Calendar.getInstance();
        Date now = currentDate.getTime();

        // Ziel-Datum (31.12.2077)
        Calendar targetDate = Calendar.getInstance();
        targetDate.set(2123, Calendar.DECEMBER, 31);
        Date endDate = targetDate.getTime();

        long startMillis = now.getTime();
        long endMillis = endDate.getTime();

        // Zufällige Millisekunden zwischen den beiden Daten generieren
        long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis));

        // Zufälliges Datum erstellen und zurückgeben
        return dateFormat.format(new Date(randomMillis));
    }
}