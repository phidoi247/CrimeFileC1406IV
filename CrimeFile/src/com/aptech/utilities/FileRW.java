/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.utilities;

import java.io.IOException;
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
    
    public static void main(String[] args) {
        FileRW fileRW = new FileRW();
        fileRW.readConfigFile("config.xml");
        System.out.println(fileRW.databaseName);
        System.out.println(fileRW.port);
        System.out.println(fileRW.user);
        System.out.println(fileRW.password);
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
