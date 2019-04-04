package com.akatkar.samples.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Calculator extends JFrame implements ActionListener {

    private static final Pattern DIGIT = Pattern.compile("[\\d]+");
    private static final Pattern OPERATORS = Pattern.compile("[-+x\\/=]");

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

    private void pressedNumber(String number) {
        display.append(number);
    }

    private void pressedClear() {
        expression.clear();
        display.clear();
    }

    private void pressedOperator(Operator operator) {
        display.setValue(expression.calculate(operator, display.getValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();
        String token = src.getText();
        if (DIGIT.matcher(token).matches()) {
            pressedNumber(token);
        } else if (OPERATORS.matcher(token).matches()) {
            pressedOperator(Operator.fromString(token).get());
        } else if ("C".equals(token)) {
            pressedClear();
        } else if (".".equals(token)){
            display.dotPressed();
        }
    }
}
