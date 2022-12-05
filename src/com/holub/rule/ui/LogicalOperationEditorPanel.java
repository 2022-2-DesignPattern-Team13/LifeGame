package com.holub.rule.ui;

import com.holub.rule.LogicalAnd;
import com.holub.rule.LogicalOperation;
import com.holub.rule.LogicalOr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogicalOperationEditorPanel extends JPanel {
    private JLabel label;
    private ArrayList<LogicalOperation> logicalOperations;
    private JComboBox<LogicalOperation> logicalOperationJComboBox;
    private JButton addButton;


    public LogicalOperationEditorPanel(JPanel resultPanel){
        label = new JLabel("Logical Operation");
        add(label);

        logicalOperations = new ArrayList<>();
        logicalOperations.add(new LogicalAnd());
        logicalOperations.add(new LogicalOr());

        logicalOperationJComboBox = new JComboBox(logicalOperations.toArray());
        add(logicalOperationJComboBox);

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LogicalOperation logicalOperation = (LogicalOperation) logicalOperationJComboBox.getSelectedItem();
                JTextField result = new JTextField(logicalOperation.toString());
                result.setEditable(false);
                resultPanel.add(result);
                resultPanel.revalidate();
                resultPanel.repaint();
            }
        });
        add(addButton);

    }
}
