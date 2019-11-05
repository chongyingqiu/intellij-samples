package com.jetbrains.inspections;

import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

@SuppressWarnings({"unused", "StatementWithEmptyBody"})
public class Inspections20182 {

    private static final int BIG_BUTTON_WIDTH = 10;
    private static final int BUTTON_HEIGHT = 3;
    private static final int[] BUTTON_Y = {5, 6, 7};

    private void addToExistingCatchBlock() {
        try {
            methodCanThrowExceptionOne();
            methodCanThrowExceptionTwo();
            //delete ExceptionTwo from the line below to see this working
        } catch (ExceptionOne | ExceptionTwo e) {
            System.out.println(e);
        }
    }

    private void canReplaceRemoveWithListClear(List<String> list) {
        list.subList(3, 8).clear();
    }

    private void warnOnListRemoveInsideCountedLoop(List<String> someList) {
        for (int i = 0; i < 10; i++) {
            if (booleanExpression()) {
                someList.remove(i);
            }
        }
    }

    private void canUnrollDecreasingLoops() {
        System.out.println(10);
        System.out.println(9);
        System.out.println(8);
        System.out.println(7);
        System.out.println(6);
        System.out.println(5);
        System.out.println(4);
        System.out.println(3);
        System.out.println(2);
        System.out.println(1);
        System.out.println(0);
    }

    private void canReplaceMapForEachWithEntrySetLoop(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (k.isEmpty()) continue;
            System.out.println("Key: " + k + "; value: " + v);
        }
    }

    private void canReplaceMapForEachWithEntrySetLoop(Map<String, Integer> map, Map<String, Integer> otherMap) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            otherMap.putIfAbsent(key, value);
        }
    }

    private <T> LinkedList<T> suggestsAtomicOperationForLinkedListFromCollection(Collection<T> collection) {
        return new LinkedList<>(collection);
    }

    private void canExtractCommonConditionsFromIfStatements(Event event) {
        if (firstCondition(event)) {
            if (event.getType() == 3) {
                //do something
            } else if (event.getType() == 4) {
                //do something else
            } else if (event.getType() == 5) {
                //do another thing
            }
        }
    }

    private boolean canSimplifyIfElse() {
        return booleanExpression() || anotherBooleanExpression();
    }

    private boolean moreBooleanExpressionsCanBeSimplified(boolean a, boolean b) {
        return a;
    }

    private void suggestsAvoidingCompareToForPrimitives(Foo foo, Bar bar) {
        if (foo.getValue() == bar.getValue()) {
            //do something here
        }
    }

    private static Long suggestsUsingAPrimitiveInsteadOfWrapper(List<? extends Long> totals) {
        return totals.stream().mapToLong(element -> element == null ? 0 : element).sum();
    }

    private void suggestsLocalVariableTypeCanBeMoreSpecific() {
        String obj = getString();
        System.out.println(obj.trim());
    }

    Number stringValue = null;
    private void suggestsChangingTheFieldOrVariableType(final AnotherClass target) {
        //uncomment to see suggestions
        target.transform(stringValue);
    }

    private Event getEvent(Class<? extends Event> eventClass) throws Exception {
        Event event;
        try {
            event = eventClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new Exception("The argument event class"
                    + eventClass.getName() // will always print java.lang.Class, not actual event class
                    + " could not be instantiated with a default constructor",
                    e);
        }
        return event;
    }

    //remove the quotes from theValue to see this in action
    @MyAnnotation(value = "theValue")
    private void wrapAsString() {
    }

    private Integer showsRedundantGenericParams() {
        return Integer.getInteger("p");
    }

    //remove the T from A to see this working
    class A<T> extends B<T> {

    }

    //requires "Implicit usage of platform's default charset" inspection (not enabled by default)
    private void suggestsUtF8CharsetWhenUsingPlatformDefaultCharset(OutputStream os) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, StandardCharsets.UTF_8);
    }

    private String canIntroduceLocalVariableForReturnExpression(List<String> params) {
        String secondParameter = params.get(1);
        return secondParameter;
    }

    private void warnsAboutComparingOptionalToNull() {
        final Optional<String> optional = getSomeOptionalValue();
        if (optional.isPresent()) {
            //do something
        }
    }

    private void suggestsStringAppendForStringJoiner() {
        String s = "ab";
    }

    //private helper methods to make examples clearer
    private void methodCanThrowExceptionTwo() throws ExceptionTwo {
        throw new ExceptionTwo();
    }

    private void methodCanThrowExceptionOne() throws ExceptionOne {
        throw new ExceptionOne();
    }

    private boolean firstCondition(Event event) {
        return true;
    }

    private Optional<String> getSomeOptionalValue() {
        return Optional.empty();
    }

    private boolean anotherBooleanExpression() {
        return false;
    }

    private boolean booleanExpression() {
        return false;
    }

    @NotNull
    private String getString() {
        return "";
    }

    //private classes for examples
    private class ExceptionOne extends Exception {
    }

    private class ExceptionTwo extends Exception {
    }

    private class Event {
        private int type;

        int getType() {
            return type;
        }
    }

    interface Foo {
        int getValue();
    }

    interface Bar {
        int getValue();
    }

    private class B<T> {
    }

    class AnotherClass {
        void transform(Number arg) {
        }
    }
}
