package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day5 extends Day {
    public Day5() {
        super(2020, 5);
    }

    @Override
    protected void part1(List<String> lines) {
        int maxSeatId = 0;

        for (String line : lines) {
            int minRow = 0;
            int maxRow = 127;
            int minCol = 0;
            int maxCol = 7;

            for (char c : line.toCharArray()) {
                switch (c) {
                    case 'F':
                        maxRow -= (maxRow - minRow) / 2;
                        break;
                    case 'B':
                        minRow += (maxRow - minRow + 1) / 2;
                        break;
                    case 'L':
                        maxCol -= (maxCol - minCol) / 2;
                        break;
                    case 'R':
                        minCol += (maxCol - minCol + 1) / 2;
                        break;
                }
            }

            int seatId = minRow * 8 + minCol;

            if (seatId > maxSeatId) {
                maxSeatId = seatId;
            }
        }

        System.out.println(maxSeatId);
    }

    @Override
    protected void part2(List<String> lines) {
        List<Integer> seatIds = new ArrayList<>();

        for (String line : lines) {
            int minRow = 0;
            int maxRow = 127;
            int minCol = 0;
            int maxCol = 7;

            for (char c : line.toCharArray()) {
                switch (c) {
                    case 'F':
                        maxRow -= (maxRow - minRow) / 2;
                        break;
                    case 'B':
                        minRow += (maxRow - minRow + 1) / 2;
                        break;
                    case 'L':
                        maxCol -= (maxCol - minCol) / 2;
                        break;
                    case 'R':
                        minCol += (maxCol - minCol + 1) / 2;
                        break;
                }
            }

            int seatId = minRow * 8 + minCol;
            seatIds.add(seatId);
        }

        seatIds.sort(Integer::compareTo);

        for (int i = 1; i < seatIds.size(); i++) {
            if (seatIds.get(i) != seatIds.get(i - 1) + 1) {
                System.out.println(seatIds.get(i - 1) + 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Day5();
    }
}
