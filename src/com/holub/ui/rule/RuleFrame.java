package com.holub.ui.rule;

import com.holub.life.Cell;
import com.holub.rule.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class RuleFrame extends JFrame {

    private JPanel ruleListPanel;

    private BehaviourPanel behaviourPanel;

    private ConditionEditorPanel conditionEditorPanel;

    private ConditionComponent createdCondtion;

    private Behaviour selectedBehavior;

    private Rule rules;
    private Cell outermostCell;
    private HashMap<JPanel,RuleItem> panelRuleItemHashMap;

    public RuleFrame(Cell outermostCell) {
        super("Rule");

        // ruleComponent new
        rules = new Rule();

        panelRuleItemHashMap = new HashMap<>();

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
        JPanel addButtonPanel = new JPanel();
        addButtonPanel.add(addRuleButton);
        addButtonPanel.setAlignmentX(CENTER_ALIGNMENT);

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


        // JFrame 설정
        this.setVisible(true);
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.add(conditionSettingPanel);
        this.add(addButtonPanel);
        this.add(Box.createVerticalStrut(10));
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

            RuleItem ruleItem = new RuleItem(createdCondtion, selectedBehavior);

            rules.addRule(ruleItem);

            JPanel ruleLabelPanel = new JPanel();
            ruleLabelPanel.setLayout(new FlowLayout());
            ruleLabelPanel.setBackground(Color.white);
            ruleLabelPanel.add(new JLabel("Rule: "));
            ruleLabelPanel.add(labelBehavior);
            ruleLabelPanel.add(new JLabel(", when cell is "));
            ruleLabelPanel.add(labelRule);

            JButton removeButton = new JButton("-");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ruleListPanel.remove(ruleLabelPanel);
                    panelRuleItemHashMap.remove(ruleLabelPanel);
                    rules.removeRule(ruleItem);
                    revalidate();
                    repaint();
                }
            });
            ruleLabelPanel.add(removeButton);

            panelRuleItemHashMap.put(ruleLabelPanel, ruleItem);
            ruleListPanel.add(ruleLabelPanel);
            revalidate();
            repaint();
        });
    }

    private void setApplyBtnActionListener(JButton button) {
        button.addActionListener(e -> {
            // apply 버튼 클릭
            outermostCell.setRule(rules);
        });
    }
}
