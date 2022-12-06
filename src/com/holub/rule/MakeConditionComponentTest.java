package com.holub.rule;

import com.holub.tools.Log;
import com.holub.ui.rule.ConditionResultPanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MakeConditionComponentTest {

    // condition1
    @Test
    public void testOneCondition(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();

        ConditionComponent conditionComponent = new ConditionItem();
        conditionResultPanel.addResult(conditionComponent);

        ConditionComponent result = conditionResultPanel.makeConditionComponent();


        assertNotEquals(null, result);
    }

    // condition1 && condition2
    @Test
    public void testCompositeCondition(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();

        ConditionComponent condition1 = new ConditionItem();
        ConditionComponent condition2 = new ConditionItem();

        conditionResultPanel.addResult(condition1);
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(condition2);

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertNotEquals(null, result );
    }

    // ( condition1 && condition2 ) || condition3
    @Test
    public void testCompositeConditionWithParentheses(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();

        ConditionComponent condition1 = new ConditionItem();
        ConditionComponent condition2 = new ConditionItem();
        ConditionComponent condition3 = new ConditionItem();

        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(condition1);
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(condition2);
        conditionResultPanel.addResult(")");
        conditionResultPanel.addResult(new LogicalOr());
        conditionResultPanel.addResult(condition3);

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertNotEquals(null, result);
    }


    // (condition1 && condition2) || (condition3 && condition4)
    @Test
    public void testCompositeConditionWithTwoSubtrees(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();

        ConditionComponent condition1 = new ConditionItem();
        ConditionComponent condition2 = new ConditionItem();
        ConditionComponent condition3 = new ConditionItem();
        ConditionComponent condition4 = new ConditionItem();

        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(condition1);
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(condition2);
        conditionResultPanel.addResult(")");
        conditionResultPanel.addResult(new LogicalOr());
        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(condition3);
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(condition4);
        conditionResultPanel.addResult(")");

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertNotEquals(null, result);
    }


    // (()
    @Test
    public void testInvalidParentheses(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(")");

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertEquals(null, result);
    }

    // condition1 &&
    @Test
    public void testInvalidOperator(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(new LogicalAnd());

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertEquals(null, result);
    }

    // condition1 && &&
    @Test
    public void testInvalidOperator2(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(new LogicalAnd());

        ConditionComponent result = conditionResultPanel.makeConditionComponent();

        assertEquals(null, result);
    }

    // condition1 condition2
    @Test
    public void testNoLogicalOperator(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(new ConditionItem());

        assertEquals(null, conditionResultPanel.makeConditionComponent());
    }

    // ( condition1 && condition2 ) condition3
    @Test
    public void testNoLogicalOperator2(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(")");
        conditionResultPanel.addResult(new ConditionItem());

        assertEquals(null, conditionResultPanel.makeConditionComponent());
    }


    // ( && condition1 condition2 )
    @Test
    public void testInvalidOrder(){
        ConditionResultPanel conditionResultPanel = new ConditionResultPanel();
        conditionResultPanel.addResult("(");
        conditionResultPanel.addResult(new LogicalAnd());
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(new ConditionItem());
        conditionResultPanel.addResult(")");

        assertEquals(null, conditionResultPanel.makeConditionComponent());
    }
}
