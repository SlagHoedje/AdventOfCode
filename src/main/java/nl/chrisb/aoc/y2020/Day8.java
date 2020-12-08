package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day8 extends Day {
    public Day8() {
        super(2020, 8);
    }

    @Override
    protected void part1(List<String> lines) {
        int acc = 0;
        int pc = 0;

        Set<Integer> visitedInstructions = new HashSet<>();

        while (!visitedInstructions.contains(pc)) {
            String[] parts = lines.get(pc).split(" ");
            String instruction = parts[0];
            int arg = Integer.parseInt(parts[1]);

            switch (instruction) {
                case "acc":
                    acc += arg;
                    break;
                case "jmp":
                    visitedInstructions.add(pc);
                    pc += arg;
                    continue;
            }

            visitedInstructions.add(pc);
            pc++;
        }

        System.out.println(acc);
    }

    private Integer terminatesOrAcc(List<String> instructions) {
        int acc = 0;
        int pc = 0;

        Set<Integer> visitedInstructions = new HashSet<>();

        while (pc < instructions.size()) {
            if (visitedInstructions.contains(pc)) {
                return null;
            }

            String[] parts = instructions.get(pc).split(" ");
            String instruction = parts[0];
            int arg = Integer.parseInt(parts[1]);

            switch (instruction) {
                case "acc":
                    acc += arg;
                    break;
                case "jmp":
                    visitedInstructions.add(pc);
                    pc += arg;
                    continue;
            }

            visitedInstructions.add(pc);
            pc++;
        }

        return acc;
    }

    @Override
    protected void part2(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            String instruction = parts[0];
            int arg = Integer.parseInt(parts[1]);

            if (instruction.equals("jmp") && arg <= 0 || instruction.equals("nop")) {
                List<String> newInstructions = new ArrayList<>(lines);

                if (instruction.equals("jmp")) {
                    newInstructions.set(i, "nop " + arg);
                }

                if (instruction.equals("nop")) {
                    newInstructions.set(i, "jmp " + arg);
                }

                Integer acc = terminatesOrAcc(newInstructions);
                if (acc != null) {
                    System.out.println(acc);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Day8();
    }
}
