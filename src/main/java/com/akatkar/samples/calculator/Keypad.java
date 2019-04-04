package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import java.util.function.BiConsumer;
import javax.swing.JButton;
import javax.swing.JPanel;

import static com.akatkar.samples.calculator.Key.*;

class Keypad extends JPanel {

    private final Calculator calculator;

    Keypad(Calculator calculator) {
        this.calculator = calculator;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(keyMap.length, keyMap.length));

        for (Key[] line : keyMap) {
            for (Key key : line) {
                this.add(new KeyButton(key));
            }
        }
    }

    private final Key[][] keyMap = {
            {MPLUS, MMINUS, PERCENT, CLEAR    },
            {SEVEN, EIGHT,  NINE,    DIVIDE   },
            {FOUR,  FIVE,   SIX,     MULTIPLY },
            {ONE,   TWO,    THREE,   MINUS    },
            {ZERO,  DOT,    EQUAL,   PLUS     }
    };

    private class KeyButton extends JButton implements Command {

        private BiConsumer<Calculator, String> consumer;

        KeyButton(Key key) {
            super(key.toString());
            this.addActionListener(calculator);
            this.consumer = key.getAction();
        }

        @Override
        public void execute() {
            consumer.accept(calculator, getText());
        }
    }
}
