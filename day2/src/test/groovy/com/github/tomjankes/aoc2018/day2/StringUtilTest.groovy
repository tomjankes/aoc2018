package com.github.tomjankes.aoc2018.day2

import spock.lang.Specification
import spock.lang.Unroll


class StringUtilTest extends Specification {

    @Unroll
    def "should remove character from string #input"() {
        when:
        def removed = StringUtil.removeCharAt(inputString, index)

        then:
        removed == expected

        where:
        inputString | index || expected
        "elo"       | 1     || "eo"
        "elo"       | 2     || "el"
        "elo"       | 0     || "lo"
    }
}
