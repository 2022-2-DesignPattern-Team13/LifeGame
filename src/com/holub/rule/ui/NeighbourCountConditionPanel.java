package com.holub.rule.ui;

import com.holub.rule.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeighbourCountConditionPanel extends JPanel {
    private JLabel label;
    private TargetCountPanel targetCountPanel;
    private ComparePanel comparePanel;
    private JButton addButton;
    private JPanel resultPanel;
    public NeighbourCountConditionPanel(ConditionResultPanel resultPanel){
        this.resultPanel = resultPanel;

        label = new JLabel("Neighbor Count Conditon");
        targetCountPanel = new TargetCountPanel();
        comparePanel = new ComparePanel();
        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.addResult(targetCountPanel.getSelected());
            }
        });

        add(label);
        add(targetCountPanel);
        add(comparePanel);
        add(addButton);
    }

    private class NeighbourCountCondition{

    }

    private class TargetCountPanel extends JPanel{
        private JLabel label;
        private JComboBox<Integer> targetCountComboBox;

        public TargetCountPanel(){
            label = new JLabel("target count");
            add(label);

            targetCountComboBox = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
            add(targetCountComboBox);
        }

        public Integer getSelected(){
            return (Integer) targetCountComboBox.getSelectedItem();
        }
    }

    private class ComparePanel extends JPanel{
        private JLabel label;
        private JComboBox<Compare> compareJComboBox;

        public ComparePanel(){
            label = new JLabel("comparator");
            add(label);

            compareJComboBox = new JComboBox<>(new Compare[]{new CompareEqual(), new CompareEqualOrMoreThan()});
            add(compareJComboBox);
        }

        public Compare getSelected(){
            return (Compare) compareJComboBox.getSelectedItem();
        }
    }
}
