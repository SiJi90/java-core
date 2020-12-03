package com.example.demo;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @description:
 * @author: slm
 * @create: 2020/08/30
 */
public class JsonConverter {

    public static Map<Character, String> replacements = new HashMap<>();


    public static void main(String[] args) throws Exception {
        String fileName = null;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("请输入文件名：");
                fileName = in.nextLine();
            }
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(JsonConverter.class.getClassLoader().getResource(fileName).toString());
        Element root = doc.getDocumentElement();
        System.out.println("root = " + root);
        NamedNodeMap attributes = root.getAttributes();
        System.out.println("attributes = " + attributes);
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String textContent = item.getTextContent();
            System.out.println("textContent = " + textContent);
        }

    }



}