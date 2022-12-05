package com.holub.ui.rule;

import javax.swing.*;

public class ConditionEditorPanel extends JPanel {
    private LogicalOperationEditorPanel logicalOperationEditorPanel;
    private ParenthesisPanel parenthesisPanel;
    private NeighbourCountConditionPanel neighborCountConditionPanel;
    private NeighbourLocationConditionPanel neighbourLocationConditionPanel;
    private ConditionResultPanel conditionResultPanel;

    private JButton checkValidButton;

    public ConditionEditorPanel(){
        conditionResultPanel = new ConditionResultPanel();

        logicalOperationEditorPanel = new LogicalOperationEditorPanel(conditionResultPanel);
        add(logicalOperationEditorPanel);

        parenthesisPanel = new ParenthesisPanel(conditionResultPanel);
        add(parenthesisPanel);

        neighborCountConditionPanel = new NeighbourCountConditionPanel(conditionResultPanel);
        add(neighborCountConditionPanel);

        neighbourLocationConditionPanel = new NeighbourLocationConditionPanel(conditionResultPanel);
        add(neighbourLocationConditionPanel);

        add(conditionResultPanel);
    }

    private boolean checkValidness(){
        return false;
    }
}
