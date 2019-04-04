package com.akatkar.samples.calculator;

import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

enum Operator {
    EQUAL   ("=", (x, y) -> {throw new UnsupportedOperationException();}),
    PLUS    ("+", (x, y) -> x + y),
    MINUS   ("-", (x, y) -> x - y),
    MULTIPLY("x", (x, y) -> x * y),
    DIVIDE  ("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    private Operator(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, Operator> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    // Returns Operation for string, if any
    public static Optional<Operator> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
