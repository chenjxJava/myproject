package com.ideaParseKeyMap.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Created by vigour on 2014-8-13.
 */
public class Action {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XStreamImplicit(itemFieldName = "keyboard-shortcut")
    private List<KeyShortcut> keyShortcut;

    @XStreamImplicit(itemFieldName = "mouse-shortcut")
    private List<MouseShortcut> mouseShortcut;

    public List<KeyShortcut> getKeyShortcut() {
        return keyShortcut;
    }

    public void setKeyShortcut(List<KeyShortcut> keyShortcut) {
        this.keyShortcut = keyShortcut;
    }

    public List<MouseShortcut> getMouseShortcut() {
        return mouseShortcut;
    }

    public void setMouseShortcut(List<MouseShortcut> mouseShortcut) {
        this.mouseShortcut = mouseShortcut;
    }
}
