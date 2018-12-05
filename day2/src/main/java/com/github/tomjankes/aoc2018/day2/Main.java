package com.github.tomjankes.aoc2018.day2;

import com.github.tomjankes.aoc2018.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<String> ids = ResourceLoader.readLines("input.txt");

        Solver solver = new Solver();

        logger.info("Starting");
        long checksum = solver.solvePart1(ids);

        logger.info("Solution 1: {}", checksum);

        String commonChars = solver.solvePart2(ids);

        logger.info("Solution 2: {}", commonChars);
    }
}
