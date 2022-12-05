package com.holub.rule.ui;

import javax.swing.*;
import java.awt.*;

public class BehaviourPanel extends JPanel {
    private String[] behaviours = {
            "Alive",
            "Die"
    };
    private JComboBox<String> comboBox;

    public BehaviourPanel(){

        setLayout(new BorderLayout());

        comboBox = new JComboBox<>(behaviours);
        add(comboBox);
    }
}
