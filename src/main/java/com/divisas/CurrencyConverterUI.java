package com.divisas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CurrencyConverterUI {
    private JFrame frame;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private CurrencyConverter converter;

    public CurrencyConverterUI() {
        try {
            converter = new CurrencyConverter("USD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAndShowGUI() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(10, 20, 80, 25);
        panel.add(fromLabel);

        fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        fromCurrency.setBounds(100, 20, 165, 25);
        panel.add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(10, 50, 80, 25);
        panel.add(toLabel);

        toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        toCurrency.setBounds(100, 50, 165, 25);
        panel.add(toCurrency);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 80, 80, 25);
        panel.add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(100, 80, 165, 25);
        panel.add(amountField);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 110, 150, 25);
        panel.add(convertButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 140, 300, 25);
        panel.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();
                double amount = Double.parseDouble(amountField.getText());
                double result = converter.convert(from, to, amount);
                resultLabel.setText("Result: " + result);
            }
        });
    }
}
