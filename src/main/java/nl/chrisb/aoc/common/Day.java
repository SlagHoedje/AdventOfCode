package nl.chrisb.aoc.common;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Day {
    public Day(int year, int day) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(year + "/" + day + ".txt");

        Scanner scanner;

        if (stream == null) {
            System.out.println("Input file not found, enter manually:");
            scanner = new Scanner(System.in);
        } else {
            scanner = new Scanner(stream);
        }

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        System.out.printf("AoC %d Day %d | Part 1:\n", year, day);
        part1(lines);

        System.out.println();
        System.out.printf("AoC %d Day %d | Part 2:\n", year, day);
        part2(lines);
    }

    protected abstract void part1(List<String> lines);

    protected abstract void part2(List<String> lines);
}
