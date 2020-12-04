package nl.chrisb.aoc.y2020.neat;

import nl.chrisb.aoc.common.Day;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.function.Predicate;

public class Day4 extends Day {
    public Day4() {
        super(2020, 4);
    }

    @Override
    protected void part1(List<String> lines) {
        String fullFile = String.join("\n", lines);
        String[] passwords = fullFile.split("\n\n");
        String[] requirements = new String[]{"byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:"};

        int count = 0;

        for (String password : passwords) {
            boolean valid = true;

            for (String requirement : requirements) {
                if (!password.contains(requirement)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        System.out.println(count);
    }

    private boolean checkPassword(String password) {
        Map<String, Predicate<String>> requirements = new HashMap<>() {{
            put("byr", t -> ValueRange.of(1920, 2002).isValidIntValue(Integer.parseInt(t)));
            put("iyr", t -> ValueRange.of(2010, 2020).isValidIntValue(Integer.parseInt(t)));
            put("eyr", t -> ValueRange.of(2020, 2030).isValidIntValue(Integer.parseInt(t)));
            put("hgt", t -> t.endsWith("cm") ? ValueRange.of(150, 193).isValidIntValue(Integer.parseInt(t.substring(0, t.length() - 2)))
                    : t.endsWith("in") && ValueRange.of(59, 76).isValidIntValue(Integer.parseInt(t.substring(0, t.length() - 2))));
            put("hcl", t -> t.matches("#[0-9a-f]{6}"));
            put("ecl", t -> t.matches("amb|blu|brn|gry|grn|hzl|oth"));
            put("pid", t -> t.matches("\\d{9}"));
        }};

        Map<String, String> passwordEntries = new HashMap<>();
        for (String entry : password.split("[ \\n]")) {
            String[] parts = entry.split(":");
            passwordEntries.put(parts[0], parts[1]);
        }

        for (Map.Entry<String, Predicate<String>> requirement : requirements.entrySet()) {
            if (!passwordEntries.containsKey(requirement.getKey())) {
                return false;
            }

            if (!requirement.getValue().test(passwordEntries.get(requirement.getKey()))) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected void part2(List<String> lines) {
        String fullFile = String.join("\n", lines);
        String[] passwords = fullFile.split("\n\n");

        int count = 0;

        for (String password : passwords) {
            if (checkPassword(password)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day4();
    }
}
