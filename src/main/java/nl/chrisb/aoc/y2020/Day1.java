package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 extends Day {
    public Day1() {
        super(2020, 1);
    }

    @Override
    protected void part1(List<String> lines) {
        List<Integer> numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());

        for (int i : numbers) {
            for (int j : numbers) {
                if (i + j == 2020) {
                    System.out.println(i * j);
                    return;
                }
            }
        }
    }

    @Override
    protected void part2(List<String> lines) {
        List<Integer> numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());

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

    public static void main(String[] args) {
        new Day1();
    }
}
