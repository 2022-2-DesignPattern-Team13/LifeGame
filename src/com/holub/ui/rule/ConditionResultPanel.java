package com.holub.ui.rule;

import com.holub.rule.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ConditionResultPanel extends JPanel {
    private JLabel label;
    private ArrayList<Object> conditionResult;
    private JButton checkValidnessButton;
    private JTextField validnessResult;
    private ConditionComponent createdCondition;

    private JButton clearButton;
    private HashMap<JTextField, Object> conditionResultMap;

    private JPanel conditionResultPanel;

    public ConditionResultPanel(){
        conditionResult = new ArrayList<>();
        conditionResultPanel = new JPanel();
        conditionResultPanel.setBackground(new Color(255,254,248));
        conditionResultPanel.setLayout(new FlowLayout());

        // Frame ui
        setLayout(new GridLayout(0,1));
        setBackground(new Color(255,254,248));
        label = new JLabel("Condition Result : ");
        label.setFont(new Font("Arial", Font.BOLD, 15));


        // valid ui
        JPanel validPanel = new JPanel();
        checkValidnessButton = new JButton("Check valid :");
        checkValidnessButton.setBackground(Color.blue);
        validnessResult = new JTextField();
        validPanel.setBackground(new Color(255,254,248));
        validPanel.add(checkValidnessButton);
        validPanel.add(validnessResult);

        clearButton = new JButton("clear");
        conditionResultMap = new HashMap<>();

        checkValidnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConditionComponent conditionComponent = makeConditionComponent();
                if(conditionComponent == null)
                    validnessResult.setText("not valid");
                else {
                    validnessResult.setText("valid");
                    createdCondition = conditionComponent;
                }
                revalidate();
                repaint();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JTextField textField : conditionResultMap.keySet()){
                    removeResult(textField);
                }
                conditionResultMap.clear();
            }
        });


        this.add(label);
        this.add(conditionResultPanel);
        this.add(validPanel);
        this.add(clearButton);
    }

    public ConditionComponent getCreatedCondition() {
        return createdCondition;
    }

    public void addResult(Object o){
        conditionResult.add(o);

        JTextField newCondition = new JTextField(o.toString());
        newCondition.setEditable(false);
        newCondition.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeResult(newCondition);
                conditionResultMap.remove(newCondition);
            }
        });

        conditionResultMap.put(newCondition, o);
        conditionResultPanel.add(newCondition);

        revalidate();
        repaint();
    }

    public void removeResult(JTextField textField){
        conditionResult.remove(conditionResultMap.get(textField));
        conditionResultPanel.remove(textField);

        revalidate();
        repaint();
    }

    private boolean checkValidParentheses(){
        Stack resultStack = new Stack();

        for(Object o: conditionResult){
            if(o.toString().compareTo("(") == 0 ||
                    (resultStack.empty() && (o.toString().compareTo("(") == 0 || o.toString().compareTo(")")==0))){
                resultStack.push(o);
            }else if(o.toString().compareTo(")") == 0 && !resultStack.empty() && resultStack.peek().toString().compareTo("(") == 0){
                resultStack.pop();
            }
        }

        return resultStack.empty();
    }

    /**
     * Tree구조의 ConditionComponent 생성
     * 생성 불가라면 null 반환
     * @return ConditionComponenet
     */
    public ConditionComponent makeConditionComponent(){
        try{
            // 1. root 노드 생성
            ConditionComponent result = new Condition(null);

            // 2. Stack 생성
            Stack<Object> stack = new Stack<>();

            // 3. 괄호가 포함된 inorder expression -> tree
            for(Object o : conditionResult){
                System.out.println(o.toString());
                if(o.toString().compareTo("(") == 0){
                    stack.push(o);
                }else if(o.toString().compareTo(")") == 0){
                    ConditionComponent midResult = new Condition(null);

                    while(!stack.empty()){
                        Object top = stack.pop();
                        if(top.toString().compareTo("(") == 0)
                            break;

                        if(top instanceof LogicalOperation){
                            if(midResult.hasOperation())
                                throw new Exception();

                            midResult.setOperation((LogicalOperation) top);
                        }else if(top instanceof ConditionComponent){
                            midResult.addCondition((ConditionComponent) top);
                        }
                    }

                    stack.push(midResult);
                }else{
                    stack.push(o);
                }
            }

            while(!stack.empty()){
                Object top = stack.peek();
                if(top instanceof LogicalOperation){
                    if(result.hasOperation())
                        return null;
                    result.setOperation((LogicalOperation) top);
                }else if(top instanceof ConditionComponent){
                    result.addCondition((ConditionComponent) top);
                }else{
                    return null;
                }
                stack.pop();
            }

            if(result.checkIsValid()){
                return result;
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkValidness(){
        return checkValidParentheses();
    }
}
