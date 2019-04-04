package com.akatkar.samples.calculator;

import java.awt.EventQueue;

public class MainClass {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
}
