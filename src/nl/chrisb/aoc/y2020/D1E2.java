package nl.chrisb.aoc.y2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        scanner.close();

        for (int i : numbers) {
            for (int j : numbers) {
                for (int k : numbers) {
                    if (i + j + k == 2020) {
                        System.out.println(i * j * k);
                        return;
                    }
                }
            }
        }
    }
}
