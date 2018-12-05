package com.github.tomjankes.aoc2018.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solver {

    private static final Logger logger = LoggerFactory.getLogger(Solver.class);

    public long solvePart1(List<String> frequencies) {
        return frequencies
            .stream()
            .mapToLong(Long::parseLong)
            .sum();
    }

    public long solvePart2(List<String> frequencies) {
        long currentFrequency = 0L;
        HashSet<Long> metFrequencies = new HashSet<>();
        metFrequencies.add(currentFrequency);
        List<Long> steps = frequencies.stream().map(Long::parseLong).collect(toList());


        while (true) {
            for (Long step : steps) {
                currentFrequency += step;
                if (metFrequencies.contains(currentFrequency)) {
                    return currentFrequency;
                }
                metFrequencies.add(currentFrequency);
            }
        }
    }
}
