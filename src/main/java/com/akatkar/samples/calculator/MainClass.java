package com.akatkar.samples.calculator;

import java.awt.EventQueue;

public class MainClass {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Calculator calc = new Calculator();
                calc.setVisible(true);
            }
        });
    }
}
