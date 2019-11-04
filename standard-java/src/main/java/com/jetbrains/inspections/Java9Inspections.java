package com.jetbrains.inspections;

import java.util.*;

import static java.util.Arrays.asList;

@SuppressWarnings("unused")
public class Java9Inspections {
    private static final List<String> EXAMPLE_LIST =
            List.<String>of("aaa", "bbb", "ccc", "ddd", "eee");

    private static final Set<String> EXAMPLE_SET
            = Set.<String>of("HAPPY", "SAD");

    private static final Map<String, Integer> WORD_TO_SCORE = Map.<String, Integer>ofEntries(Map.entry("happy", 3),
            Map.entry("good", 3),
            Map.entry("great", 3),
            Map.entry("keen", 2),
            Map.entry("awesome", 2),
            Map.entry("marvelous", 2),
            Map.entry("yay", 14),
            Map.entry("pleased", 14),
            Map.entry("sad", 1),
            Map.entry("mad", 1),
            Map.entry("blargh", 8),
            Map.entry("boo", 8),
            Map.entry("terrible", 8),
            Map.entry("horrible", 2),
            Map.entry("bad", 2),
            Map.entry("awful", 2));


    private String useNewObjectsStaticMethod() {

        return Objects.requireNonNullElse(getSomeValue(), "default");
    }

    private String getSomeValue() {
        return null;
    }
}
