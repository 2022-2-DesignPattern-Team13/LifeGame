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
        setLayout(new GridLayout(0,1,-1,-1));
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        conditionResultPanel = new ConditionResultPanel();

        logicalOperationEditorPanel = new LogicalOperationEditorPanel(conditionResultPanel);
        logicalOperationEditorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(logicalOperationEditorPanel);

        parenthesisPanel = new ParenthesisPanel(conditionResultPanel);
        parenthesisPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(parenthesisPanel);

        neighborCountConditionPanel = new NeighbourCountConditionPanel(conditionResultPanel);
        neighborCountConditionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(neighborCountConditionPanel);

        neighbourLocationConditionPanel = new NeighbourLocationConditionPanel(conditionResultPanel);
        neighbourLocationConditionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(neighbourLocationConditionPanel);

        add(conditionResultPanel);
    }

    private boolean checkValidness(){
        return false;
    }
}
