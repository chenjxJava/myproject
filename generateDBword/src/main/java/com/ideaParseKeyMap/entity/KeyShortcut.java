package com.ideaParseKeyMap.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by vigour on 2014-8-13.
 */
public class KeyShortcut {
    @XStreamAsAttribute
    @XStreamAlias("first-keystroke")
    private String keyStroke;

    public String getKeyStroke() {
        return keyStroke;
    }

    public void setKeyStroke(String keyStroke) {
        this.keyStroke = keyStroke;
    }
}
