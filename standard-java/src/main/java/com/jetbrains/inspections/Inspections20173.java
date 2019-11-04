package com.jetbrains.inspections;

import java.util.*;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Inspections20173 {

    private List<String> mutableCollection = new ArrayList<>();

    private Map<String, Integer> mapWithDuplicateKeys = new HashMap<>() {{
        put("a", 1);
        put("b", 2);
        put("a", 3);
    }};

    private Set<String> setWithDuplicateValues = new HashSet<>() {{
        add("a");
        add("b");
        add("a");
    }};

    public List<String> getList() {
        return Collections.unmodifiableList(mutableCollection);
    }

    public boolean compareWith1(CharSequence charSequence) {
        final StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.equals(charSequence);
    }

    public boolean compareWith2(CharSequence charSequence) {
        return "Some String".contentEquals(charSequence);
    }

    public void regexp() {
        final Pattern pattern = Pattern.compile("[.]");
    }

    public void quickFix(String someValue) {
        //ignore
    }

    //intention
    public void unrollLoop() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
    }

    public boolean compare(MyClass myClass) {
        return myClass.equals(new MyClass());
    }

    private final class MyClass {
    }
}
