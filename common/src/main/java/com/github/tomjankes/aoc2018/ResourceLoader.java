package com.github.tomjankes.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ResourceLoader {

    public static List<String> readLines(String name) {
        try {
            return Files.readAllLines(read(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readBytes(String name) {
        try {
            return Files.readAllBytes(read(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readString(String name) {
        return new String(readBytes(name), StandardCharsets.UTF_8);
    }

    private static Path read(String name) {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        URL resourceURL = classLoader.getResource(name);
        try {
            return Paths.get(resourceURL.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
