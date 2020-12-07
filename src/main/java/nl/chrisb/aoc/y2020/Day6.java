package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 extends Day {
    public Day6() {
        super(2020, 6);
    }

    @Override
    protected void part1(List<String> lines) {
        String input = String.join("\n", lines);

        int sum = 0;
        for (String answers : input.split("\n\n")) {
            Set<Character> characters = new HashSet<>();

            for (char c : answers.toCharArray()) {
                if (Character.isLetter(c)) {
                    characters.add(c);
                }
            }

            sum += characters.size();
        }

        System.out.println(sum);
    }

    @Override
    protected void part2(List<String> lines) {
        String input = String.join("\n", lines);

        int sum = 0;
        for (String answers : input.split("\n\n")) {
            String[] people = answers.split("\n");

            Set<Character> characters = new HashSet<>();

            for (char c : people[0].toCharArray()) {
                characters.add(c);
            }

            for (String person : people) {
                characters.removeIf(character -> !person.contains(String.valueOf(character)));
            }

            sum += characters.size();
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        new Day6();
    }
}
