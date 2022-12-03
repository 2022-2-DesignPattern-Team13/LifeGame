package com.holub.rule;

import javax.swing.*;

public class AddRulePanel extends JPanel {
    public AddRulePanel(){

    }
}

class ConditionBehaviourPanel extends JPanel{
    public ConditionBehaviourPanel(){

    }
}

class ConditionPanel extends JPanel{
    private JList list;
    private DefaultListModel model;

    public ConditionPanel(){
        list = new JList(model);
        model.addElement("Neighbor count");
        model.addElement("Neighbor location");
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}