package nl.chrisb.aoc.y2020.neat;

import nl.chrisb.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day11 extends Day {
    public Day11() {
        super(2020, 11);
    }

    @Override
    protected void part1(List<String> lines) {
        List<String> state = lines;
        List<String> newState = null;

        while (!state.equals(newState)) {
            if (newState != null) {
                state = newState;
            }

            newState = new ArrayList<>();

            for (int y = 0; y < state.size(); y++) {
                StringBuilder line = new StringBuilder();

                for (int x = 0; x < state.get(y).length(); x++) {
                    char current = state.get(y).charAt(x);

                    if (current == '.') {
                        line.append(".");
                    }

                    int occupied = 0;

                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx == 0 && dy == 0) {
                                continue;
                            }

                            if (x + dx < 0 || x + dx >= state.get(y).length()) {
                                continue;
                            }

                            if (y + dy < 0 || y + dy >= state.size()) {
                                continue;
                            }

                            if (state.get(y + dy).charAt(x + dx) == '#') {
                                occupied++;
                            }
                        }
                    }

                    if (current == 'L') {
                        if (occupied == 0) {
                            line.append("#");
                        } else {
                            line.append("L");
                        }
                    } else if (current == '#') {
                        if (occupied >= 4) {
                            line.append("L");
                        } else {
                            line.append("#");
                        }
                    }
                }

                newState.add(line.toString());
            }
        }

        int count = 0;

        for (String line : state) {
            for (char c : line.toCharArray()) {
                if (c == '#') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    @Override
    protected void part2(List<String> lines) {
        List<String> state = lines;
        List<String> newState = null;

        while (!state.equals(newState)) {
            if (newState != null) {
                state = newState;
            }

            newState = new ArrayList<>();

            for (int y = 0; y < state.size(); y++) {
                StringBuilder line = new StringBuilder();

                for (int x = 0; x < state.get(y).length(); x++) {
                    char current = state.get(y).charAt(x);

                    if (current == '.') {
                        line.append(".");
                    }

                    int occupied = 0;

                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx == 0 && dy == 0) {
                                continue;
                            }

                            int cx = 0;
                            int cy = 0;

                            while (true) {
                                cx += dx;
                                cy += dy;

                                if (x + cx < 0 || x + cx >= state.get(y).length()) {
                                    break;
                                }

                                if (y + cy < 0 || y + cy >= state.size()) {
                                    break;
                                }

                                if (state.get(y + cy).charAt(x + cx) == '.') {
                                    continue;
                                }

                                if (state.get(y + cy).charAt(x + cx) == '#') {
                                    occupied++;
                                }

                                break;
                            }
                        }
                    }

                    if (current == 'L') {
                        if (occupied == 0) {
                            line.append("#");
                        } else {
                            line.append("L");
                        }
                    } else if (current == '#') {
                        if (occupied >= 5) {
                            line.append("L");
                        } else {
                            line.append("#");
                        }
                    }
                }

                newState.add(line.toString());
            }
        }

        int count = 0;

        for (String line : state) {
            for (char c : line.toCharArray()) {
                if (c == '#') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Day11();
    }
}
