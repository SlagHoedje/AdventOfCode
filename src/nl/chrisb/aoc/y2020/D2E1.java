package nl.chrisb.aoc.y2020;

import java.util.Scanner;

public class D2E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(": ");
            String requirement = parts[0];
            String password = parts[1];

            char letter = requirement.charAt(requirement.length() - 1);

            String range = requirement.substring(0, requirement.length() - 2);
            String[] rangeParts = range.split("-");

            int least = Integer.parseInt(rangeParts[0]);
            int most = Integer.parseInt(rangeParts[1]);

            int currentCount = 0;
            for (char c : password.toCharArray()) {
                if (c == letter) {
                    currentCount++;
                }
            }

            if (currentCount >= least && currentCount <= most) {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }
}
