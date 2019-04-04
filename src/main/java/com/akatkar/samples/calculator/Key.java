package com.akatkar.samples.calculator;

import java.util.function.BiConsumer;

enum Key {
    // Numbers
    ZERO    ("0", Calculator::pressedNumber),
    ONE     ("1", Calculator::pressedNumber),
    TWO     ("2", Calculator::pressedNumber),
    THREE   ("3", Calculator::pressedNumber),
    FOUR    ("4", Calculator::pressedNumber),
    FIVE    ("5", Calculator::pressedNumber),
    SIX     ("6", Calculator::pressedNumber),
    SEVEN   ("7", Calculator::pressedNumber),
    EIGHT   ("8", Calculator::pressedNumber),
    NINE    ("9", Calculator::pressedNumber),
    // Operators
    DIVIDE  ("/", Calculator::pressedOperator),
    MULTIPLY("x", Calculator::pressedOperator),
    MINUS   ("-", Calculator::pressedOperator),
    EQUAL   ("=", Calculator::pressedOperator),
    PLUS    ("+", Calculator::pressedOperator),
    // Other Keys
    MPLUS   ("M+",Calculator::pressedEmpty),
    MMINUS  ("M-",Calculator::pressedEmpty),
    PERCENT ("%", Calculator::pressedEmpty),
    DOT     (".", Calculator::pressedDot),
    CLEAR   ("C", Calculator::pressedClear);

    private String caption;
    private BiConsumer<Calculator,String> action;

    Key(String caption, BiConsumer<Calculator,String> action){
        this.caption = caption;
        this.action = action;
    }

    @Override
    public String toString() {
        return caption;
    }

    public BiConsumer<Calculator, String> getAction() {
        return action;
    }
}

