package com.ideaParseKeyMap.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Created by vigour on 2014-8-13.
 */
public class Keymap {
    @XStreamImplicit(itemFieldName = "action")
    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
