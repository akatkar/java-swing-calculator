package com.akatkar.samples.calculator;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

enum Operator {
    EQUAL("="),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("x"),
    DIVIDE("/");

    private final String symbol;

    private Operator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, Operator> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    // Returns Operation for string, if any
    public static Optional<Operator> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
