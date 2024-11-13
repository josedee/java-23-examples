package com.example;

import java.util.List;
import java.util.stream.Gatherers;

/// StreamGatherers is a feature which enhances the Stream API to support custom intermediate operations.
/// This `StreamGatherer` class uses some of the features offered by StreamGatherers like fixed and sliding 
/// window functions. This is a second preview feature part of Java 23

public class StreamGatherer {
    public static void main(String[] args) {
        List<String> words = List.of("the", "be", "two", "of", "and", "a", "in", "that");

        List<List<String>> fixedWindows = words.stream()
                .gather(Gatherers.windowFixed(3))
                .toList();

        System.out.println(fixedWindows);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<List<Integer>> slidingWindows = numbers.stream()
                .gather(Gatherers.windowSliding(3))
                .toList();

        System.out.println(slidingWindows);
    }
}
