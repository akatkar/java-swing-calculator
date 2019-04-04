package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JPanel;

class Keypad extends JPanel {

    private static final Pattern DIGIT = Pattern.compile("[\\d]+");
    private static final Pattern OPERATORS = Pattern.compile("[-+x\\/=]");

    private final Calculator calculator;

    Keypad(Calculator calculator) {
        this.calculator = calculator;
        initComponents();
    }
    private void initComponents() {
        this.setLayout(new GridLayout(keyMap.length, keyMap.length));

        for (String[] line : keyMap) {
            for (String caption : line) {
                this.add(getKey(caption));
            }
        }
    }

    private final String[][] keyMap = {
            {"M+","M-","%","C"},
            {"7","8","9","/"},
            {"4","5","6","x"},
            {"1","2","3","-"},
            {"0",".","=","+"}
    };

    private class KeyButton extends JButton implements Command {

        private BiConsumer<Calculator, String> consumer;

        KeyButton(String caption, BiConsumer<Calculator, String> consumer) {
            super(caption);
            this.addActionListener(calculator);
            this.consumer = consumer;
        }

        @Override
        public void execute() {
            consumer.accept(calculator, getText());
        }
    }

    KeyButton getKey(String caption) {
        if (DIGIT.matcher(caption).matches()) {
            return new KeyButton(caption, Calculator::pressedNumber);
        } else if (OPERATORS.matcher(caption).matches()) {
            return new KeyButton(caption, Calculator::pressedOperator);
        } else if ("C".equals(caption)) {
            return new KeyButton(caption, Calculator::pressedClear);
        } else if (".".equals(caption)) {
            return new KeyButton(caption, Calculator::pressedDot);
        } else {
            return new KeyButton(caption, Calculator::pressedEmpty);
        }
    }
}
