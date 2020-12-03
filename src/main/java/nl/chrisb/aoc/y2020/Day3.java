package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.List;

public class Day3 extends Day {
    public Day3() {
        super(2020, 3);
    }

    private int countTrees(List<String> map, int dx, int dy) {
        int mapWidth = map.get(0).length();
        int mapHeight = map.size();

        int x = 0;
        int y = 0;

        int trees = 0;

        while (true) {
            x += dx;
            y += dy;

            if (y >= mapHeight) {
                break;
            }

            if (x >= mapWidth) {
                x -= mapWidth;
            }

            if (map.get(y).charAt(x) == '#') {
                trees++;
            }
        }

        return trees;
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
