package com.holub.rule.ui;

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
            ConditionComponent result = new Condition(new NullLogicalOperation());

            Stack<Object> stack = new Stack<>();
            for(Object o : conditionResult){
                if(o.toString().compareTo("(") == 0){
                    stack.push(o);
                }else if(o.toString().compareTo(")") == 0){
                    ConditionComponent midResult = new Condition(new NullLogicalOperation());

                    while(!stack.empty() || stack.peek().toString().compareTo("(") == 0){
                        if(stack.peek() instanceof LogicalOperation){
                            midResult.setOperation((LogicalOperation) stack.peek());
                        }else if(stack.peek() instanceof ConditionComponent){
                            midResult.addCondition((ConditionComponent) stack.peek());
                        }
                        stack.pop();
                    }
                }
            }

            return result;
        }catch(Exception e){
            return null;
        }


//        try{
//            ConditionComponent conditionComponent = new Condition(new NullLogicalOperation());
//
//            for(int i=index; i<conditionResult.size(); i++){
//                if(conditionResult.get(i).toString().compareTo("(") == 0){
//                    ConditionComponent left = makeConditionComponent(i+1);
//                }else if(conditionResult.get(i).toString().compareTo(")") == 0){
//                    return conditionComponent;
//                }else if(conditionResult.get(i) instanceof ConditionComponent){
//                    conditionComponent.addCondition((ConditionComponent) conditionResult.get(i));
//                }else if(conditionResult.get(i) instanceof LogicalOperation){
//                    conditionComponent.setOperation((LogicalOperation) conditionResult.get(i));
//                }else{
//                    throw new Exception();
//                }
//            }
//
//            return conditionComponent;
//
//        }catch(Exception e){
//            return null;
//        }
    }

    public boolean checkValidness(){
        return checkValidParentheses();
    }
}
