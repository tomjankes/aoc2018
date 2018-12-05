package com.github.tomjankes.aoc2018.day1;

import com.github.tomjankes.aoc2018.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<String> input = ResourceLoader.readLines("input.txt");
        logger.info("Started...");
        Solver solver = new Solver();
        long solution1 = solver.solvePart1(input);
        logger.info("Result 1 is {}", solution1);
        long solution2 = solver.solvePart2(input);
        logger.info("Result 2 is {}", solution2);
    }
}
