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

        for (JRadioButton radioButton : radioButtons) {
            radioButtonGroup.add(radioButton);
            radioPanel.add(radioButton);
        }

        radioPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));

        setBorder(new TitledBorder(
                null, "Choose Condition Behavior", TitledBorder.LEADING, TitledBorder.TOP));

        this.add(radioPanel);
    }
}
