package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.List;

public class Day2 extends Day {
    public Day2() {
        super(2020, 2);
    }

    @Override
    protected void part1(List<String> lines) {
        int count = 0;

        for (String line : lines) {
            String[] parts = line.split(": ");
            String requirement = parts[0];
            String password = parts[1];

            char letter = requirement.charAt(requirement.length() - 1);

            String range = requirement.substring(0, requirement.length() - 2);
            String[] rangeParts = range.split("-");

            int least = Integer.parseInt(rangeParts[0]);
            int most = Integer.parseInt(rangeParts[1]);

            int currentCount = 0;
            for (char c : password.toCharArray()) {
                if (c == letter) {
                    currentCount++;
                }
            }

            if (currentCount >= least && currentCount <= most) {
                count++;
            }
        }

        System.out.println(count);
    }

    @Override
    protected void part2(List<String> lines) {
        int count = 0;

        for (String line : lines) {
            String[] parts = line.split(": ");
            String requirement = parts[0];
            String password = parts[1];

            char letter = requirement.charAt(requirement.length() - 1);

            String range = requirement.substring(0, requirement.length() - 2);
            String[] rangeParts = range.split("-");

            int first = Integer.parseInt(rangeParts[0]) - 1;
            int second = Integer.parseInt(rangeParts[1]) - 1;

            boolean firstValid = password.charAt(first) == letter;
            boolean secondValid = password.charAt(second) == letter;

            if (!(firstValid && secondValid) && (firstValid || secondValid)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day2();
    }
}
