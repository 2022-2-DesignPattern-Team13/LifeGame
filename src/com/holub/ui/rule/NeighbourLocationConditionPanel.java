package com.holub.ui.rule;

import com.holub.rule.NeighborLocationCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeighbourLocationConditionPanel extends JPanel {

    private JLabel label;
    private LocationPanel locationPanel;
    private IsAlivePanel isAlivePanel;
    private JButton addButton;

    public NeighbourLocationConditionPanel(ConditionResultPanel resultPanel) {
        setLayout(new BorderLayout());

        JPanel selectPanel = new JPanel();
        label = new JLabel("Neighbour Location condition");
        label.setFont(new Font(null, Font.BOLD, 13));
        selectPanel.add(label);

        locationPanel = new LocationPanel();
        isAlivePanel = new IsAlivePanel();

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.addResult(new NeighborLocationCondition(locationPanel.getSelected(), isAlivePanel.getSelected()));
            }
        });

        selectPanel.add(locationPanel);
        selectPanel.add(isAlivePanel);

        this.add(selectPanel, BorderLayout.WEST);
        this.add(addButton, BorderLayout.EAST);
    }

    private class LocationPanel extends JPanel{
        private JLabel label;
        private JComboBox<String> selectLocationComboBox;

        public LocationPanel(){
            label = new JLabel("location :");
            add(label);
            selectLocationComboBox = new JComboBox<>(new String[] {
                    "north",
                    "south",
                    "east",
                    "west",
                    "northeast",
                    "northwest",
                    "southeast",
                    "southwest",

            });
            add(selectLocationComboBox);
        }

        public String getSelected(){
            return (String) selectLocationComboBox.getSelectedItem();
        }
    }

    private class IsAlivePanel extends JPanel{
        private JLabel label;
        private JCheckBox isAliveCheckBox;

        public IsAlivePanel(){
            label = new JLabel("Is alive :");
            add(label);

            isAliveCheckBox = new JCheckBox();
            add(isAliveCheckBox);
        }

        public boolean getSelected(){
            return isAliveCheckBox.isSelected();
        }
    }
}