package com.github.tomjankes.aoc2018.day1

import spock.lang.Specification
import spock.lang.Unroll

class SolverTest extends Specification {

    def solver = new Solver()

    @Unroll
    def "should sum all frequency changes for #input"() {
        given:
        def parsed = input.split(",").collect { it.trim() }

        when:
        def solution = solver.solvePart1(parsed)

        then:
        solution == expected

        where:
        input        || expected
        "+1, +1, +1" || 3L
        "+1, +1, -2" || 0L
        "-1, -2, -3" || -6L
    }

    @Unroll
    def "should find firs repeated frequency for input #input"() {
        given:
        def parsed = input.split(",").collect { it.trim() }

        when:
        def solution = solver.solvePart2(parsed)

        then:
        solution == expected

        where:
        input                || expected
        "+1, -1"             || 0L
        "+3, +3, +4, -2, -4" || 10L
        "-6, +3, +8, +5, -6" || 5L
        "+7, +7, -2, -7, -4" || 14L
    }
}
