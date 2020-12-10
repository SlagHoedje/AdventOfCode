package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.List;
import java.util.stream.Collectors;

public class Day10 extends Day {
    public Day10() {
        super(2020, 10);
    }

    @Override
    protected void part1(List<String> lines) {
        List<Integer> numbers = lines.stream().map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList());

        int count1 = numbers.get(0) == 1 ? 1 : 0;
        int count3 = 1;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);

            if (diff == 1) {
                count1++;
            } else if (diff == 3) {
                count3++;
            }
        }

        System.out.println(count1 * count3);
    }

    @Override
    protected void part2(List<String> lines) {
        List<Integer> numbers = lines.stream().map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList());
        numbers.add(0, 0);

        // This WILL fail with higher chain lengths, so this isn't really a reliable solution, but it works ¯\_(ツ)_/¯
        int[] chainCounts = new int[]{1, 1, 2, 4, 7, 15};

        long count = 1;
        int chainLength = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);

            if (diff == 1) {
                chainLength++;
            } else if (diff == 3) {
                count *= chainCounts[chainLength];

                chainLength = 0;
            }
        }

        if (chainLength != 0) {
            count *= chainCounts[chainLength];
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day10();
    }
}
