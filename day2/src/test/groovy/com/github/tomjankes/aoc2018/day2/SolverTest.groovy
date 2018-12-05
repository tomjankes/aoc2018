package com.github.tomjankes.aoc2018.day2

import spock.lang.Specification

class SolverTest extends Specification {

    def solver = new Solver()

    def "should calculate checksum of exampel input"() {
        given:
        def exampleInput = [
            "abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"
        ]

        when:
        def solution = solver.solvePart1(exampleInput)

        then:
        solution == 12
    }
}
