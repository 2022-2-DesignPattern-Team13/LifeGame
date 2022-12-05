package com.holub.ui.rule;

import com.holub.rule.LogicalAnd;
import com.holub.rule.LogicalOperation;
import com.holub.rule.LogicalOr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogicalOperationEditorPanel extends JPanel {
    private JLabel label;
    private ArrayList<LogicalOperation> logicalOperations;
    private JComboBox<LogicalOperation> logicalOperationJComboBox;
    private JButton addButton;


    public LogicalOperationEditorPanel(ConditionResultPanel resultPanel){
        setLayout(new BorderLayout());

        JPanel selectPanel = new JPanel();
        label = new JLabel("Logical Operation : ");
        selectPanel.add(label);

        logicalOperations = new ArrayList<>();
        logicalOperations.add(new LogicalAnd());
        logicalOperations.add(new LogicalOr());

        logicalOperationJComboBox = new JComboBox(logicalOperations.toArray());
        selectPanel.add(logicalOperationJComboBox);

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.addResult(logicalOperationJComboBox.getSelectedItem());
            }
        });
        this.add(selectPanel, BorderLayout.WEST);
        this.add(addButton, BorderLayout.EAST);
    }
}
