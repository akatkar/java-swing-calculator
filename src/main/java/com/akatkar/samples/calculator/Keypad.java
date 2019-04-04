package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class Keypad extends JPanel{
    
    private final ActionListener actionListener;
    
    Keypad(ActionListener actionListener){
        this.actionListener = actionListener;
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
                JButton btn = new JButton(caption);
                btn.addActionListener(actionListener);
                this.add(btn);
            }
        }
    }   
}
