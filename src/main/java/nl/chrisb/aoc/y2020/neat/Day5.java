package nl.chrisb.aoc.y2020.neat;

import nl.chrisb.aoc.common.Day;

import java.util.List;

public class Day5 extends Day {
    public Day5() {
        super(2020, 5);
    }

    @Override
    protected void part1(List<String> lines) {
        //noinspection OptionalGetWithoutIsPresent
        System.out.println(lines.stream().map(l -> l.replaceAll("[FL]", "0").replaceAll("[BR]", "1"))
                .map(l -> Integer.parseInt(l.substring(0, 7), 2) * 8 + Integer.parseInt(l.substring(7), 2))
                .max(Integer::compareTo).get());
    }

    @Override
    protected void part2(List<String> lines) {
        System.out.println(lines.stream().map(l -> l.replaceAll("[FL]", "0").replaceAll("[BR]", "1"))
                .map(l -> Integer.parseInt(l.substring(0, 7), 2) * 8 + Integer.parseInt(l.substring(7), 2))
                .sorted()
                .reduce(0, (a, b) -> (a == 0 || a == b - 1) ? b : a) + 1);
    }

    public static void main(String[] args) {
        new Day5();
    }
}
