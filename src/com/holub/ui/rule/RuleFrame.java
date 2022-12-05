package com.holub.ui.rule;

import com.holub.rule.Behaviour;
import com.holub.rule.ConditionComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuleFrame extends JFrame {

    private JPanel ruleListPanel;

    private BehaviourPanel behaviourPanel;

    private ConditionEditorPanel conditionEditorPanel;


    private ConditionComponent createdRule;

    private String selectedBehavior;

    public RuleFrame() {
        super("Rule");

        // Condition 설정 레이아웃
        JPanel conditionContainPanel = new JPanel();
        conditionContainPanel.setLayout(new BorderLayout());
        conditionContainPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        conditionEditorPanel = new ConditionEditorPanel();
        conditionEditorPanel.setBorder(new TitledBorder(
                null,
                "Make your own Custom Condition",
                TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 15)));

        conditionContainPanel.add(conditionEditorPanel, BorderLayout.NORTH);
        behaviourPanel = new BehaviourPanel();
        conditionContainPanel.add(behaviourPanel, BorderLayout.CENTER);

        // Rule 생성 button
        JButton addRuleButton = new JButton("+ Add new rule");
        setAddRuleBtnActionListener(addRuleButton);

        // 생성된 Rule List 레이아웃
        ruleListPanel = new JPanel();
        ruleListPanel.setLayout(new GridLayout(0, 1));
        ruleListPanel.setBackground(Color.white);
        ruleListPanel.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));


        // 최종 Rule 적용 button
        JButton applyRuleButton = new JButton("Apply Custom Rule >>");


        JPanel conditionSettingPanel = new JPanel();
        conditionSettingPanel.add(conditionContainPanel);
        conditionSettingPanel.add(addRuleButton);


        // JFrame 설정
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.add(conditionSettingPanel);
        this.add(ruleListPanel);
        this.add(new JPanel().add(applyRuleButton));
    }

    private void setAddRuleBtnActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createdRule = conditionEditorPanel.getCreatedComponent();
                JLabel labelRule = new JLabel(createdRule.toString());
                labelRule.setFont(new Font(null, Font.BOLD, 13));

                selectedBehavior = "Die!!!!";
                JLabel labelBehavior = new JLabel(selectedBehavior.toString());
                labelBehavior.setFont(new Font(null, Font.BOLD, 13));

                JPanel ruleLabelPanel = new JPanel();
                ruleLabelPanel.setLayout(new FlowLayout());
                ruleLabelPanel.add(new JLabel("Rule: "));
                ruleLabelPanel.add(labelRule);
                ruleLabelPanel.add(new JLabel(", when cell is "));
                ruleLabelPanel.add(labelBehavior);


                ruleListPanel.add(ruleLabelPanel);
                revalidate();
                repaint();
            }
        });
    }

    static class Test {
        public static void main(String[] args) {
            new RuleFrame();
        }
    }
}
