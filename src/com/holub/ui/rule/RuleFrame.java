package com.holub.ui.rule;

import com.holub.ui.ColorChooser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RuleFrame extends JFrame {

    public RuleFrame(){
        super("Rule");
        JPanel panel = new JPanel();
        ConditionEditorPanel conditionEditorPanel = new ConditionEditorPanel();
        conditionEditorPanel.setBorder(new TitledBorder(
                null, "Make your own Custom Condition", TitledBorder.LEADING, TitledBorder.TOP));

        panel.add(conditionEditorPanel);
        panel.add(new BehaviourPanel());

        setVisible(true);
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(panel);
    }

    static class Test {
        public static void main(String[] args) {
            new RuleFrame();
        }
    }
}
