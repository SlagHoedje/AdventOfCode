package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.*;

public class Day7 extends Day {
    public Day7() {
        super(2020, 7);
    }

    private Map<String, Map<String, Integer>> parseRules(List<String> lines) {
        Map<String, Map<String, Integer>> rules = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.replaceAll("\\.| bags| bag", "").split(" contain ");
            String bagColor = parts[0];

            Map<String, Integer> containingBags = new HashMap<>();

            if (!parts[1].startsWith("no")) {
                String[] containingRules = parts[1].split(", ");

                for (String rule : containingRules) {
                    int number = Integer.parseInt(rule.substring(0, 1));
                    String bag = rule.substring(2);

                    containingBags.put(bag, number);
                }
            }

            rules.put(bagColor, containingBags);
        }

        return rules;
    }

    @Override
    protected void part1(List<String> lines) {
        final String toFind = "shiny gold";

        Map<String, Map<String, Integer>> rules = parseRules(lines);
        Set<String> possibleContainers = new HashSet<>();
        int count = -1;

        while (count != possibleContainers.size()) {
            count = possibleContainers.size();

            for (Map.Entry<String, Map<String, Integer>> entry : rules.entrySet()) {
                if (entry.getValue().containsKey(toFind)) {
                    possibleContainers.add(entry.getKey());
                    continue;
                }

                for (String container : possibleContainers) {
                    if (entry.getValue().containsKey(container)) {
                        possibleContainers.add(entry.getKey());
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }

    @Override
    protected void part2(List<String> lines) {
        final String toFind = "shiny gold";

        Map<String, Map<String, Integer>> rules = parseRules(lines);

        Map<String, Integer> stack = new HashMap<>();
        stack.put(toFind, 1);

        int count = 0;

        while (!stack.isEmpty()) {
            Map<String, Integer> newStack = new HashMap<>();

            for (Map.Entry<String, Integer> entry : stack.entrySet()) {
                count += rules.get(entry.getKey()).values().stream().reduce(0, Integer::sum) * entry.getValue();

                for (Map.Entry<String, Integer> rule : rules.get(entry.getKey()).entrySet()) {
                    int existing = 0;
                    
                    if (newStack.containsKey(rule.getKey())) {
                        existing = newStack.get(rule.getKey());
                        newStack.remove(rule.getKey());
                    }

                    newStack.put(rule.getKey(), rule.getValue() * entry.getValue() + existing);
                }

            }

            stack = newStack;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day7();
    }
}
