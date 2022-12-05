package com.holub.ui.rule;

import javax.swing.*;

public class RuleFrame extends JFrame {

    public RuleFrame(){
        super("Rule");
        setVisible(true);
        setSize(800, 500);

        add(new ConditionEditorPanel());
    }
}
