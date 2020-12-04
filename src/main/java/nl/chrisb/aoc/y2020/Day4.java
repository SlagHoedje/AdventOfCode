package nl.chrisb.aoc.y2020;

import nl.chrisb.aoc.common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Override
    protected void part2(List<String> lines) {
        String fullFile = String.join("\n", lines);
        String[] passwords = fullFile.split("\n\n");
        String[] requirements = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

        int count = 0;

        for (String password : passwords) {
            password = password.replaceAll("\n", " ");

            List<String> gotRequirements = new ArrayList<>();

            for (String req : password.split(" ")) {
                String[] parts = req.split(":");

                switch (parts[0]) {
                    case "byr":
                        if (!parts[1].matches("[0-9]{4}")) {
                            break;
                        }

                        int year = Integer.parseInt(parts[1]);
                        if (year < 1920 || year > 2002) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "iyr":
                        if (!parts[1].matches("[0-9]{4}")) {
                            break;
                        }

                        year = Integer.parseInt(parts[1]);
                        if (year < 2010 || year > 2020) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "eyr":
                        if (!parts[1].matches("[0-9]{4}")) {
                            break;
                        }

                        year = Integer.parseInt(parts[1]);
                        if (year < 2020 || year > 2030) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "hgt":
                        if (!parts[1].matches("[0-9]*(cm|in)")) {
                            break;
                        }

                        String measurement = parts[1].substring(parts[1].length() - 2);
                        int height = Integer.parseInt(parts[1].substring(0, parts[1].length() - 2));
                        if (measurement.equals("cm")) {
                            if (height < 150 || height > 193) {
                                break;
                            }
                        } else if (measurement.equals("in")) {
                            if (height < 59 || height > 76) {
                                break;
                            }
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "hcl":
                        if (!parts[1].matches("#[0-9a-f]{6}")) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "ecl":
                        if (!parts[1].matches("(amb|blu|brn|gry|grn|hzl|oth)")) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                    case "pid":
                        if (!parts[1].matches("[0-9]{9}")) {
                            break;
                        }

                        gotRequirements.add(parts[0]);
                        break;
                }
            }

            List<String> left = new ArrayList<>(Arrays.asList(requirements));
            left.removeAll(gotRequirements);
            if (left.size() == 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day4();
    }
}
