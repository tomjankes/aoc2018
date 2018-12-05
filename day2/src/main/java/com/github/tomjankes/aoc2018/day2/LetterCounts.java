package com.github.tomjankes.aoc2018.day2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LetterCounts {

    private final Set<Long> frequencies;

    LetterCounts(String input) {
        this.frequencies = calculateFrequencies(input);
    }

    public boolean hasTwo() {
        return frequencies.contains(2L);
    }

    public boolean hasThree() {
        return frequencies.contains(3L);
    }

    private static Set<Long> calculateFrequencies(String input) {
        Collection<Long> counts = input.codePoints()
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values();
        return new HashSet<>(counts);
    }
}
