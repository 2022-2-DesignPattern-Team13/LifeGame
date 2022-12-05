package com.holub.ui.rule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParenthesisPanel extends JPanel {
    private JLabel label;
    private String[] parenthesisArr = {"(", ")"};
    private JComboBox<String> parenthesisComboBox;
    private JButton addButton;


    public ParenthesisPanel(ConditionResultPanel resultPanel){
        label = new JLabel("Parenthesis");
        add(label);

        parenthesisComboBox = new JComboBox<>(parenthesisArr);
        add(parenthesisComboBox);

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.addResult(parenthesisComboBox.getSelectedItem());
            }
        });
        add(addButton);
    }
}
