package com.holub.rule.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeighbourLocationConditionPanel extends JPanel {

    private JLabel label;
    private LocationPanel locationPanel;
    private IsAlivePanel isAlivePanel;
    private JButton addButton;

    public NeighbourLocationConditionPanel(JPanel resultPanel) {
        label = new JLabel("Neighbour location condition");
        locationPanel = new LocationPanel();
        isAlivePanel = new IsAlivePanel();

        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.add(new JTextField(locationPanel.getSelected()+" "+isAlivePanel.getSelected()));
                resultPanel.revalidate();
                resultPanel.repaint();
            }
        });

        add(label);
        add(locationPanel);
        add(isAlivePanel);
        add(addButton);
    }

    private class LocationPanel extends JPanel{
        private JLabel label;
        private JComboBox<String> selectLocationComboBox;

        public LocationPanel(){
            label = new JLabel("location");
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
            label = new JLabel("Is alive");
            add(label);

            isAliveCheckBox = new JCheckBox();
            add(isAliveCheckBox);
        }

        public boolean getSelected(){
            return isAliveCheckBox.isSelected();
        }
    }
}