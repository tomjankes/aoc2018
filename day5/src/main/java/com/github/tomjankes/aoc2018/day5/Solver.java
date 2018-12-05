package com.github.tomjankes.aoc2018.day5;

import com.github.tomjankes.aoc2018.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Solver {

    private static final Logger logger = LoggerFactory.getLogger(Solver.class);

    static class ReductionResult {
        private final List<Integer> polymer;
        private final int position;
        private final boolean last;

        public ReductionResult(List<Integer> polymer, int position, boolean last) {
            this.polymer = polymer;
            this.position = position;
            this.last = last;
        }
    }

    private boolean canBeReduced(int first, int second) {
        return Character.isUpperCase(first) != Character.isUpperCase(second)
            && Character.toUpperCase(first) == Character.toUpperCase(second);
    }

    private List<Integer> reaction(List<Integer> toReduce, int firstPos) {
        toReduce.remove(firstPos);
        toReduce.remove(firstPos);
        return toReduce;
    }

    private List<Integer> reduce(List<Integer> polymer) {
        ReductionResult result = new ReductionResult(polymer, 0, false);

        while (!result.last) {
            result = reduce(result);
        }

        return result.polymer;
    }

    private ReductionResult reduce(ReductionResult result) {
        List<Integer> polymer = result.polymer;
        for (int position = result.position; position < polymer.size(); position++) {
            int secondPositionToAnalyze = position + 1;
            if (secondPositionToAnalyze < polymer.size()) {
                if (canBeReduced(polymer.get(position), polymer.get(secondPositionToAnalyze))) {
                    List<Integer> reducedPolymer = reaction(polymer, position);
                    return new ReductionResult(reducedPolymer, Math.max(0, position - 1), false);
                }
            }
        }
        return new ReductionResult(result.polymer, result.polymer.size(), true);
    }

    public String solvePart1(String input) {
        List<Integer> polymer = stringToCodePoints(input);
        List<Integer> reduce = reduce(polymer);
        StringBuilder stringBuilder = new StringBuilder();
        reduce.forEach(stringBuilder::appendCodePoint);
        return stringBuilder.toString();
    }

    private int solvePart1WithoutChars(String input, String lower) {
        String replaced = input
            .replaceAll(lower, "")
            .replaceAll(lower.toUpperCase(), "");
        return solvePart1(replaced).length();
    }

    public int solvePart2(String input) {

        return input
            .toLowerCase()
            .codePoints()
            .distinct()
            .mapToObj(Character::toChars)
            .map(String::new)
            .parallel()
            .mapToInt(lowerCaseString -> solvePart1WithoutChars(input, lowerCaseString))
            .min()
            .orElse(input.length());
    }

    private static List<Integer> stringToCodePoints(String input) {
        return input.codePoints().boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solver solver = new Solver();
        String input = ResourceLoader.readString("polymer.txt");

        logger.info("Started");

        String stringSolution = solver.solvePart1(input);
        int solution1 = stringSolution.length();

        logger.info("Solution 1: {}", solution1);

        int solution2 = solver.solvePart2(input);

        logger.info("Solution 2: {}", solution2);
    }
}
