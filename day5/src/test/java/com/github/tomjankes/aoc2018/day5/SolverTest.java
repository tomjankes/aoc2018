package com.github.tomjankes.aoc2018.day5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolverTest {
    private final Solver solver = new Solver();

    @Test
    public void shouldSolveFirstExample() {
        //given
        String firstExample = "dabAcCaCBAcCcaDA";

        //when
        String output = solver.solvePart1(firstExample);

        //then
        assertEquals("dabCBAcaDA", output);
        assertEquals(10, output.length());
    }
}