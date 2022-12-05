package com.holub.ui.rule;

import javax.swing.*;
import java.awt.*;

public class ConditionEditorPanel extends JPanel {
    private LogicalOperationEditorPanel logicalOperationEditorPanel;
    private ParenthesisPanel parenthesisPanel;
    private NeighbourCountConditionPanel neighborCountConditionPanel;
    private NeighbourLocationConditionPanel neighbourLocationConditionPanel;
    private ConditionResultPanel conditionResultPanel;

    private JButton checkValidButton;

    public ConditionEditorPanel(){

        JPanel conditionGridPanel = new JPanel();
        conditionGridPanel.setLayout(new GridLayout(0,1,-1,-1));
        conditionGridPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));

        conditionResultPanel = new ConditionResultPanel();

        logicalOperationEditorPanel = new LogicalOperationEditorPanel(conditionResultPanel);
        logicalOperationEditorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        conditionGridPanel.add(logicalOperationEditorPanel);

        parenthesisPanel = new ParenthesisPanel(conditionResultPanel);
        parenthesisPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        conditionGridPanel.add(parenthesisPanel);

        neighborCountConditionPanel = new NeighbourCountConditionPanel(conditionResultPanel);
        neighborCountConditionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        conditionGridPanel.add(neighborCountConditionPanel);

        neighbourLocationConditionPanel = new NeighbourLocationConditionPanel(conditionResultPanel);
        neighbourLocationConditionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        conditionGridPanel.add(neighbourLocationConditionPanel);

        this.setLayout(new BorderLayout());
        this.add(conditionResultPanel, BorderLayout.SOUTH);
        this.add(conditionGridPanel, BorderLayout.CENTER);
    }

    private boolean checkValidness(){
        return false;
    }
}
