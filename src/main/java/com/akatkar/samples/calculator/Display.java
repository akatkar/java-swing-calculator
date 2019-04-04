package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Display extends JPanel {
    private JTextField display;

    Display() {
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new GridLayout(1, 1));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        this.add(display);
    }

    void setValue(String value) {
        this.display.setText(value);
    } 
}
