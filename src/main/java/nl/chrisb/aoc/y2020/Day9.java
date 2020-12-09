package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.List;
import java.util.stream.Collectors;

public class Day9 extends Day {
    public Day9() {
        super(2020, 9);
    }

    private boolean isInvalidSum(List<Long> numbers, int index, int preamble) {
        for (int i = 0; i < preamble; i++) {
            for (int j = i + 1; j < preamble; j++) {
                if (numbers.get(index - preamble + i) + numbers.get(index - preamble + j) == numbers.get(index)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected void part1(List<String> lines) {
        final int preamble = 25;
        List<Long> numbers = lines.stream().map(Long::parseLong).collect(Collectors.toList());

        for (int i = preamble; i < numbers.size(); i++) {
            if (isInvalidSum(numbers, i, preamble)) {
                System.out.println(numbers.get(i));
                return;
            }
        }
    }

    @Override
    protected void part2(List<String> lines) {
        final int preamble = 25;
        List<Long> numbers = lines.stream().map(Long::parseLong).collect(Collectors.toList());

        for (int i = preamble; i < numbers.size(); i++) {
            if (isInvalidSum(numbers, i, preamble)) {
                long invalid = numbers.get(i);

                int low = 0;
                while (true) {
                    int high = low + 1;
                    long sum = numbers.get(low) + numbers.get(high);

                    while (sum < invalid) {
                        high++;
                        sum += numbers.get(high);

                        if (sum == invalid) {
                            long smallest = numbers.get(low);
                            long largest = numbers.get(high);

                            for (int j = low; j <= high; j++) {
                                long n = numbers.get(j);

                                if (n < smallest) {
                                    smallest = n;
                                }

                                if (n > largest) {
                                    largest = n;
                                }
                            }

                            System.out.println(smallest + largest);
                            return;
                        }
                    }

                    low++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Day9();
    }
}
