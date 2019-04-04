package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JPanel;

class Keypad extends JPanel{

    private static final Pattern DIGIT = Pattern.compile("[\\d]+");
    private static final Pattern OPERATORS = Pattern.compile("[-+x\\/=]");

    private final Calculator calculator;

    Keypad(Calculator calculator){
        this.calculator = calculator;
        initComponents();
    }

    private final String[][] keyMap = {
            {"M+","M-","%","C"},
            {"7","8","9","/"},
            {"4","5","6","x"},
            {"1","2","3","-"},
            {"0",".","=","+"}
    };

    private void initComponents(){
        this.setLayout(new GridLayout(keyMap.length,keyMap.length));
        for(String[] line : keyMap){
            for(String caption: line){
                if (DIGIT.matcher(caption).matches()) {
                    this.add(new DigitKey(caption, calculator));
                } else if (OPERATORS.matcher(caption).matches()) {
                    this.add(new OperatorKey(caption, calculator));
                } else if ("C".equals(caption)) {
                    this.add(new ClearKey(caption, calculator));
                } else if (".".equals(caption)){
                    this.add(new DotKey(caption, calculator));
                } else {
                    this.add(new EmptyKey(caption, calculator));
                }
            }
        }
    }

    class OperatorKey extends JButton implements Command {

        private Calculator calculator;

        OperatorKey(String caption, Calculator calculator) {
            super(caption);
            this.addActionListener(calculator);
            this.calculator = calculator;
        }

        @Override
        public void execute() {
            Operator.fromString(getText())
                    .ifPresent(op->calculator.pressedOperator(op));
        }
    }

    class DigitKey extends JButton implements Command {

        private Calculator calculator;

        DigitKey(String caption, Calculator calculator) {
            super(caption);
            this.addActionListener(calculator);
            this.calculator = calculator;
        }

        @Override
        public void execute() {
            calculator.pressedNumber(getText());
        }
    }

    class ClearKey extends JButton implements Command {

        private Calculator calculator;

        ClearKey(String caption, Calculator calculator) {
            super(caption);
            this.addActionListener(calculator);
            this.calculator = calculator;
        }

        @Override
        public void execute() {
            calculator.pressedClear();
        }
    }

    class DotKey extends JButton implements Command {

        private Calculator calculator;

        DotKey(String caption, Calculator calculator) {
            super(caption);
            this.addActionListener(calculator);
            this.calculator = calculator;
        }

        @Override
        public void execute() {
            calculator.pressedDot();
        }
    }

    class EmptyKey extends JButton implements Command {

        private Calculator calculator;

        EmptyKey(String caption, Calculator calculator) {
            super(caption);
            this.addActionListener(calculator);
            this.calculator = calculator;
        }

        @Override
        public void execute() {
        }
    }
}
