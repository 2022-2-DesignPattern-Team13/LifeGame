package com.holub.ui.rule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParenthesisPanel extends JPanel {
    private JLabel label;
    private String[] parenthesisArr = {"(", ")"};
    private JComboBox<String> parenthesisComboBox;
    private JButton addButton;


    public ParenthesisPanel(ConditionResultPanel resultPanel){
        setLayout(new BorderLayout());
        JPanel selectPanel = new JPanel();

        label = new JLabel("Parenthesis : ");
        selectPanel.add(label);

        parenthesisComboBox = new JComboBox<>(parenthesisArr);
        selectPanel.add(parenthesisComboBox);

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.addResult(parenthesisComboBox.getSelectedItem());
            }
        });
        this.add(selectPanel, BorderLayout.WEST);
        this.add(addButton, BorderLayout.EAST);
    }
}
