package com.holub.ui.rule;

import com.holub.life.Cell;
import com.holub.rule.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RuleFrame extends JFrame {

    private JPanel ruleListPanel;

    private BehaviourPanel behaviourPanel;

    private ConditionEditorPanel conditionEditorPanel;

    private ConditionComponent createdCondtion;

    private Behaviour selectedBehavior;

    private RuleComponent ruleComponent;
    private Cell outermostCell;

    public RuleFrame(Cell outermostCell) {
        super("Rule");

        // ruleComponent new
        ruleComponent = new Rule();

        this.outermostCell = outermostCell;

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
        setAddRuleButtonActionListener(addRuleButton);

        // 생성된 Rule List 레이아웃
        ruleListPanel = new JPanel();
        ruleListPanel.setLayout(new GridLayout(0, 1));
        ruleListPanel.setBackground(Color.white);
        ruleListPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));


        // 최종 Rule 적용 button
        JButton applyRuleButton = new JButton("Apply Custom Rule >>");
        setApplyBtnActionListener(applyRuleButton);
        JPanel applyButtonPanel = new JPanel();
        applyButtonPanel.add(applyRuleButton);
        applyButtonPanel.setAlignmentX(CENTER_ALIGNMENT);


        JPanel conditionSettingPanel = new JPanel();
        conditionSettingPanel.add(conditionContainPanel);
        conditionSettingPanel.add(addRuleButton);


        // JFrame 설정
        this.setVisible(true);
        this.setSize(800, 900);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.add(conditionSettingPanel);
        this.add(ruleListPanel);
        this.add(applyButtonPanel);
    }

    private void setAddRuleButtonActionListener(JButton button) {
        button.addActionListener(e -> {
            createdCondtion = conditionEditorPanel.getCreatedComponent();
            if(createdCondtion == null)
                return;

            JLabel labelRule = new JLabel(createdCondtion.toString());
            labelRule.setFont(new Font(null, Font.BOLD, 13));

            selectedBehavior = behaviourPanel.getSelectedBehavior();
            JLabel labelBehavior = new JLabel(selectedBehavior.toString());
            labelBehavior.setFont(new Font(null, Font.BOLD, 13));

            ruleComponent.addRule(new RuleItem(createdCondtion, selectedBehavior));


            JPanel ruleLabelPanel = new JPanel();
            ruleLabelPanel.setLayout(new FlowLayout());
            ruleLabelPanel.setBackground(Color.white);
            ruleLabelPanel.add(new JLabel("Rule: "));
            ruleLabelPanel.add(labelRule);
            ruleLabelPanel.add(new JLabel(", when cell is "));
            ruleLabelPanel.add(labelBehavior);

            ruleListPanel.add(ruleLabelPanel);
            revalidate();
            repaint();
        });
    }

    private void setApplyBtnActionListener(JButton button) {
        button.addActionListener(e -> {
            // apply 버튼 클릭
            outermostCell.setRule(ruleComponent);
        });
    }

//    static class Test {
//        public static void main(String[] args) {
//            new RuleFrame(outermostCell);
//        }
//    }
}
