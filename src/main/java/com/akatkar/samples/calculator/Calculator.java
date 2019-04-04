package com.akatkar.samples.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Calculator extends JFrame implements ActionListener {

    private final Expression expression = new Expression();
    private Display display;

    public Calculator() {
        super("Calculator");
        initComponents();
        setSize(230, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        display = new Display();
        panel.add(display);

        panel.add(new Keypad(this));
        this.add(panel);
    }

    void pressedNumber(String number) {
        display.append(number);
    }

    void pressedClear() {
        expression.clear();
        display.clear();
    }

    void pressedOperator(Operator operator) {
        display.setValue(expression.calculate(operator, display.getValue()));
    }

    void pressedDot() {
        display.dotPressed();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command command = (Command) e.getSource();
        command.execute();
    }
}
