package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class ScientificCalculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[18];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, clrButton, delButton, negButton;
    JButton sqrtButton, powButton, sinButton, cosButton, tanButton;
    JButton logButton,xsqButton,absButton; // Empty spaces for future expansion
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    ScientificCalculator() {

        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 500, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        sqrtButton = new JButton("√");
        powButton = new JButton("^");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");

        logButton = new JButton("log");
        absButton = new JButton("abs");
        xsqButton = new JButton("x^2");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        functionButtons[9] = sqrtButton;
        functionButtons[10] = powButton;
        functionButtons[11] = sinButton;
        functionButtons[12] = cosButton;
        functionButtons[13] = tanButton;

        functionButtons[14] = logButton; // Empty space 1
        functionButtons[15] = absButton; // Empty space 2
        functionButtons[16] = xsqButton; // Empty space 3

        for (int i = 0; i < 17; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 600, 100, 50);
        delButton.setBounds(150, 600, 100, 50);
        clrButton.setBounds(250, 600, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 500, 450);
        panel.setLayout(new GridLayout(6, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add additional scientific buttons to the panel
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);

        // Add empty spaces to the panel
        panel.add(logButton);
        panel.add(absButton);
        panel.add(xsqButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    // Implement the actionPerformed method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Handle decimal button
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // Handle basic arithmetic operations
        if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton
                || e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = e.getActionCommand().charAt(0);
            textField.setText("");
        }

        // Handle scientific operations
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == powButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        } else if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        }

        // Handle equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

                case '^':
                    result = Math.pow(num1, num2);
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Handle clear button
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Handle delete button
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        // Handle negate button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        
        if (e.getSource() == logButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.log10(num1);
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == absButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.abs(num1);
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == xsqButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.pow(num1, 2);
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String args[]) {
        // Create an instance of the ScientificCalculator class
        ScientificCalculator calc = new ScientificCalculator();
    }
}
