package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }
}
