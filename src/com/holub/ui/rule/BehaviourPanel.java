package com.holub.ui.rule;

import com.holub.rule.AliveBehaviour;
import com.holub.rule.Behaviour;
import com.holub.rule.DieBehaviour;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class BehaviourPanel extends JPanel {

    private ArrayList<Behaviour> behaviours;

    private ArrayList<JRadioButton> radioButtons;

    private ButtonGroup radioButtonGroup;

    private JPanel radioPanel;

    private Behaviour selectedBehavior;

    public BehaviourPanel() {

        setLayout(new BorderLayout());

        radioButtonGroup = new ButtonGroup();
        behaviours = new ArrayList<>();
        radioButtons = new ArrayList<>();
        radioPanel = new JPanel();

        behaviours.add(new AliveBehaviour());
        behaviours.add(new DieBehaviour());

        for (Behaviour behaviour : behaviours) {
            radioButtons.add(new JRadioButton(behaviour.toString()));
        }

        for (int index = 0; index < radioButtons.size(); index++) {
            JRadioButton radioButton = radioButtons.get(index);
            setSelectedRadioButton(radioButton, index);
            radioButtonGroup.add(radioButton);
            radioPanel.add(radioButton);
        }

        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        setBorder(new TitledBorder(
                null,
                "Choose Condition Result State",
                TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 15)));

        this.add(radioPanel);
    }

    private void setSelectedRadioButton(JRadioButton radioButton, Integer index) {
        radioButton.addActionListener(e -> {
            if (radioButton.isSelected()) {
                selectedBehavior = behaviours.get(index);
            }
        });
    }

    public Behaviour getSelectedBehavior() {
        return selectedBehavior;
    }
}
