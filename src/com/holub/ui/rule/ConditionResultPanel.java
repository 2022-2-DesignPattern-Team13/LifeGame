package com.holub.ui.rule;

import com.holub.rule.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class ConditionResultPanel extends JPanel {
    private JLabel label;
    private ArrayList<Object> conditionResult;
    private JButton checkValidnessButton;
    private JTextField validnessResult;
    public ConditionResultPanel(){
        conditionResult = new ArrayList<>();

        label = new JLabel("Condition Result");
        add(label);

        checkValidnessButton = new JButton("check");
        validnessResult = new JTextField();

        checkValidnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConditionComponent conditionComponent = makeConditionComponent();
                if(conditionComponent == null)
                    validnessResult.setText("not valid");
                else
                    validnessResult.setText("valid");
                revalidate();
                repaint();
            }
        });
        add(checkValidnessButton);
        add(validnessResult);
    }

    public void addResult(Object o){
        conditionResult.add(o);
        add(new JTextField(o.toString()));

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
                if(o.toString().compareTo("(") == 0){
                    stack.push(o);
                }else if(o.toString().compareTo(")") == 0){
                    ConditionComponent midResult = new Condition(null);

                    while(!stack.empty()){
                        Object top = stack.pop();
                        if(top instanceof LogicalOperation){
                            if(midResult.hasOperation())
                                throw new Exception();

                            midResult.setOperation((LogicalOperation) stack.peek());
                        }else if(top instanceof ConditionComponent){
                            midResult.addCondition((ConditionComponent) stack.peek());
                        }else if(top.toString().compareTo("(") == 0){
                            break;
                        }
                    }

                    stack.push(midResult);
                }else{
                    stack.push(o);
                }
            }

            while(!stack.empty()){
                System.out.println(stack.peek().toString());
                if(stack.peek() instanceof LogicalOperation){
                    if(result.hasOperation())
                        return null;
                    result.setOperation((LogicalOperation) stack.peek());
                }else if(stack.peek() instanceof ConditionComponent){
                    result.addCondition((ConditionComponent) stack.peek());
                }
                stack.pop();
            }

            if(result.checkIsValid())
                return result;
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public boolean checkValidness(){
        return checkValidParentheses();
    }
}