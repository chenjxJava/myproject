package com.ideaParseKeyMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Sets;
import com.ideaParseKeyMap.entity.Action;
import com.ideaParseKeyMap.entity.Component;
import com.ideaParseKeyMap.entity.KeyShortcut;
import com.ideaParseKeyMap.entity.Keymap;
import com.ideaParseKeyMap.entity.MouseShortcut;
import com.thoughtworks.xstream.XStream;

/**
 * Created by vigour on 2014-8-13.
 */
public class Parser {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "keymap/Eclipse_copy.xml";
        String resultFilePath = "keymap1.txt";
        //demo1();
        printTxtFromXml(srcFilePath, resultFilePath);

    }

    /**
     * 将idea中快捷键的配置文件输出
     * @param srcFilePath  源keymap文件
     * @param resultFilePath 输出文件路径
     */
    private static void printTxtFromXml(String srcFilePath, String resultFilePath) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Parser myParse = new Parser();

        {
            URL url = loader.getResource(srcFilePath);
            myParse.parse(url.getPath());
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(resultFilePath);

            for (String key : myParse.map.keySet()) {
								String temp = key + "\t" +
									Joiner.on("|").join(myParse.map.get(key)) + "\n";
								System.out.println(temp);
								writer.write(temp);
						}
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void demo1() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Parser defaultParser = new Parser();
        Parser emacsParser = new Parser();

        {
            URL url = loader.getResource("keymap/Keymap_Emacs.xml");
            emacsParser.parse(url.getPath());
        }
        {
            URL url2 = loader.getResource("keymap/Keymap_Default.xml");
            defaultParser.parse(url2.getPath());
        }

        for (String key : emacsParser.map.keySet()) {
            System.out.println(key + "\t" +
                    Joiner.on("|").join(emacsParser.map.get(key)));
        }

        System.out.println("_______");

        Set<String> diffKeys = Sets.difference(defaultParser.map.keySet(),
                emacsParser.map.keySet());
        for (String key : diffKeys) {
            System.out.println(key + "\t" +
                    Joiner.on("|").join(defaultParser.map.get(key)));
        }
    }

    private LinkedListMultimap<String, String> map = LinkedListMultimap.create();

    public void parse(String path) {
        XStream stream = new XStream();
        stream.processAnnotations(Component.class);

        File f = new File(path);
        Component c = (Component) stream.fromXML(f);
        traverse(c);
        System.out.println(map);
    }


    private void traverse(KeyShortcut shortcut, String actionId) {
        if (shortcut == null) {
            return;
        }
        map.put(actionId, shortcut.getKeyStroke());
    }

    private void traverse(MouseShortcut shortcut, String actionId) {
        if (shortcut == null) {
            return;
        }
        map.put(actionId, shortcut.getKeyStroke());
    }

    private void traverse(Keymap keymap) {
        if (keymap == null) {
            return;
        }
        for (Action action : keymap.getActions()) {
            traverse(action);
        }
    }

    private void traverse(Component component) {
        if (component == null) {
            return;
        }
        for (Keymap keymap : component.getKeymaps()) {
            traverse(keymap);
        }
    }

    private void traverse(Action action) {
        if (action == null) {
            return;
        }
        if (action.getKeyShortcut() != null) {
            for (KeyShortcut shortcut : action.getKeyShortcut()) {
                traverse(shortcut, action.getId());
            }
        }
        if (action.getMouseShortcut() != null) {
            for (MouseShortcut shortcut : action.getMouseShortcut()) {
                traverse(shortcut, action.getId());
            }
        }
    }
}

