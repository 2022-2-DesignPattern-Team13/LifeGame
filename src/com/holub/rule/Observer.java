package com.holub.rule;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<RuleItem> rules);
}
