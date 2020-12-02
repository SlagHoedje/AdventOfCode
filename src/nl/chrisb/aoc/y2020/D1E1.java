package nl.chrisb.aoc.y2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        scanner.close();

        for (int i : numbers) {
            for (int j : numbers) {
                if (i + j == 2020) {
                    System.out.println(i * j);
                    return;
                }
            }
        }
    }
}
