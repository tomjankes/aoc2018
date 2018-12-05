package com.github.tomjankes.aoc2018.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.tomjankes.aoc2018.day2.StringUtil.levenshteinDistance;

public class Solver {

    public long solvePart1(List<String> input) {
        List<LetterCounts> counts = input.stream().map(LetterCounts::new).collect(Collectors.toList());

        long countOfTwos = counts.stream().filter(LetterCounts::hasTwo).count();
        long countOfThrees = counts.stream().filter(LetterCounts::hasThree).count();

        return countOfThrees * countOfTwos;
    }

    private static final Logger logger = LoggerFactory.getLogger(Solver.class);

    public String solvePart2(List<String> input) {

        int lastDistance = Integer.MAX_VALUE;
        String minimalFirst = null;
        String minimalSecond = null;

        for (String toCheck: input) {
            for (String toCheck2: input) {
                if (!toCheck.equals(toCheck2)) {
                    int newDistance = levenshteinDistance(toCheck, toCheck2);
                    if (newDistance < lastDistance) {
                        lastDistance = newDistance;
                        minimalFirst = toCheck;
                        minimalSecond = toCheck2;
                    }
                }
            }
        }

        if (lastDistance > 1) {
            throw new RuntimeException("It seems like we couldn't find two IDS that are separate by one char");
        }

        for (int pos = 0; pos < minimalFirst.length(); pos++) {
            if (minimalFirst.charAt(pos) != minimalSecond.charAt(pos)) {
                return StringUtil.removeCharAt(minimalFirst, pos);
            }
        }

        throw new RuntimeException("It seems we didn't find any changes in these two: " + minimalFirst + " " + minimalSecond);
    }
}
