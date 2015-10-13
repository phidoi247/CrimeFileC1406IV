/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 *
 * @author MyPC
 */
public class FileRW {

    private String databaseName = null;
    private String port = null;
    private String user = null;
    private String password = null;

    public boolean readConfigFile(String xml) {
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(xml);
            Element doc = dom.getDocumentElement();
            databaseName = getTextValue(databaseName, doc, "databaseName");
            port = getTextValue(port, doc, "port");
            user = getTextValue(user, doc, "user");
            password = getTextValue(password, doc, "password");

            return true;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(FileRW.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    public void writeConfigFile(String xml, String _databaseName, String _port, String _user, String _password) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(xml, "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            writer.println("<config>");
            writer.println("<databaseName>" + _databaseName + "</databaseName>");
            writer.println("<port>" + _port + "</port>");
            writer.println("<user>" + _user + "</user>");
            writer.println("<password>" + _password + "</password>");
            writer.println("</config>");
            
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
