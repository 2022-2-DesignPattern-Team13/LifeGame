package com.holub.ui.rule;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuleFrame extends JFrame {

    private JPanel ruleListPanel;

    private BehaviourPanel behaviourPanel;

    public RuleFrame() {
        super("Rule");

        // Condition 설정 레이아웃
        JPanel conditionContainPanel = new JPanel();
        conditionContainPanel.setLayout(new BorderLayout());
        conditionContainPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        ConditionEditorPanel conditionEditorPanel = new ConditionEditorPanel();
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
        JLabel dummyText = new JLabel("When !@duse djifdj dijf, Cell is die");
        JLabel dummyText2 = new JLabel("When1111 !@duse djifdj dijf, Cell is die");
        ruleListPanel.add(dummyText);
        ruleListPanel.add(dummyText2);


        // 최종 Rule 적용 button
        JButton applyRuleButton = new JButton("Apply Custom Rule >>");


        JPanel panel1 = new JPanel();
        panel1.add(conditionContainPanel);
        panel1.add(addRuleButton);

        JPanel panel2 = new JPanel();
        panel2.add(ruleListPanel);
        panel2.add(applyRuleButton);

        // JFrame 설정
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        add(panel1);
        add(panel2);
    }

    private void setAddRuleBtnActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel dummyText = new JLabel("New Dummy Text add!");
                ruleListPanel.add(dummyText);
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
