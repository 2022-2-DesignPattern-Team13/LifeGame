package com.holub.rule.ui;

import com.holub.rule.LogicalAnd;
import com.holub.rule.LogicalOperation;
import com.holub.rule.LogicalOr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ParenthesisPanel extends JPanel {
    private JLabel label;
    private String[] parenthesisArr = {"(", ")"};
    private JComboBox<String> parenthesisComboBox;
    private JButton addButton;


    public ParenthesisPanel(JPanel resultPanel){
        label = new JLabel("Parenthesis");
        add(label);

        parenthesisComboBox = new JComboBox<>(parenthesisArr);
        add(parenthesisComboBox);

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.add(new JTextField((String)parenthesisComboBox.getSelectedItem()));
                resultPanel.revalidate();
                resultPanel.repaint();
            }
        });
        add(addButton);
    }
}
