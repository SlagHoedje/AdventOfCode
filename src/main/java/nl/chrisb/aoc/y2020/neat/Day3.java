package nl.chrisb.aoc.y2020.neat;

import nl.chrisb.aoc.common.Day;

import java.util.List;
import java.util.stream.IntStream;

public class Day3 extends Day {
    public Day3() {
        super(2020, 3);
    }

    private int countTrees(List<String> map, int dx, int dy) {
        return (int) IntStream.range(0, map.size() - 1)
                .filter(i -> i != 0 && i % dy == 0)
                .filter(i -> map.get(i).charAt((i * dx) % map.get(i).length()) == '#')
                .count();
    }

    @Override
    protected void part1(List<String> lines) {
        System.out.println(countTrees(lines, 3, 1));
    }

    @Override
    protected void part2(List<String> lines) {
        System.out.println(countTrees(lines, 1, 1)
                * countTrees(lines, 3, 1)
                * countTrees(lines, 5, 1)
                * countTrees(lines, 7, 1)
                * countTrees(lines, 1, 2));
    }

    public static void main(String[] args) {
        new Day3();
    }
}
