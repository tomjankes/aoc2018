package com.github.tomjankes.aoc2018.day2

import spock.lang.Specification
import spock.lang.Unroll


class LetterCountsTest extends Specification {

    @Unroll
    def "should calculate repeated characters for #input"() {
        when:
        def counts = new LetterCounts(input)

        then:
        counts.hasTwo() == hasTwo
        counts.hasThree() == hasThree

        where:
        input    || hasTwo | hasThree
        "abcdef" || false  | false
        "bababc" || true   | true
        "abbcde" || true   | false
        "abcccd" || false  | true
        "aabcdd" || true   | false
        "abcdee" || true   | false
        "ababab" || false  | true
    }
}
