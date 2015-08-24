/**
 * 
 */
package com.anil.xml;

/**
 * @author anila
 *
 */
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXMLTable {
        private static List myEmpls;
        private static Document dom;
        
        private Map fieldTypeMap = new HashMap();
        
        private void addEntriesToMap(){
        	fieldTypeMap.put("STRING", "VARCHAR");
        	fieldTypeMap.put("DATE", "DATE");
        	fieldTypeMap.put("NUMBER", "NUMBER");
        	//Add more mappins here
        }

        public ReadXMLTable()
        {
                // create a list to hold the employee objects
                myEmpls = new ArrayList();
                addEntriesToMap();
        }

        private void createSQLFile(String xmlFileName, String sqlFileName){
        	FileOutputStream out;
            PrintStream p;
           
            try {
                    File fXmlFile = new File(xmlFileName);
                    try {
                            out = new FileOutputStream(sqlFileName);
                            p = new PrintStream(out);

                            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                                            .newInstance();
                            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                            Document doc = dBuilder.parse(fXmlFile);
                            Element docEle = doc.getDocumentElement();
                            docEle.normalize();
                            System.out.println("Root element :"
                                            + docEle.getNodeName());
                            NodeList nList = doc.getElementsByTagName(docEle.getNodeName());
                            System.out.println("-----------------------");

                            p.println("-- GENERATED FILE : "
                                            + docEle.getNodeName() + ".sql");

                            for (int temp = 0; temp < nList.getLength(); temp++) {

                                    Node nNode = nList.item(temp);
                                    System.out.println("Before Enter IF");

                                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                            Element eElement = (Element) nNode;


                                            p.println("-- Table Description :"
                                                            + getTagValue("TABLE_DESC", eElement));
                                            p.println("");
                                            p.println("Drop table "
                                                            + docEle.getNodeName() + ";");
                                            p.println("");
                                            p.println("Drop synonym "
                                                            + getTagValue("TABLE_SYN", eElement) + ";");
                                            p.println("");
                                            p.println("Create Table "
                                                            + docEle.getNodeName()
                                                            + "   (");
                                            p.println("");

                                            NodeList fieldsElement = docEle.getElementsByTagName("FIELDS");
                                            Node nl = fieldsElement.item(0);

                                            NodeList childNodes = nl.getChildNodes();

                                            String fieldType=null;
                                            String output = null;
                                            
                                            if (childNodes != null && childNodes.getLength() > 0)
                                            {
                                                    System.out.println("nl.getLength():" + childNodes.getLength());
                                                    for (int i = 0; i < childNodes.getLength(); i++)
                                                    {

                                                            Node el = childNodes.item(i);
                                                       
                                                            if (el.getNodeName()!=null && !el.getNodeName().equals("#text"))
                                                            {
                                                                   NodeList nl2=  el.getChildNodes();
                                                                    for (int i1 = 0; i1 < nl2.getLength(); i1++){
                                                                    	//Get the field Type
                                                                    	if (nl2.item(i1).getNodeName().equalsIgnoreCase("FIELD_TYPE"))  {
                                                                    		fieldType = nl2.item(i1).getChildNodes().item(0).getNodeValue();
                                                                    	}       
                                                                    	System.out.println(fieldType + ":" + this.fieldTypeMap.get(fieldType)+ ":" + nl2.item(i1).getNodeName()+ ":" + nl2.item(i1).getNodeType() + ":" + nl2.item(i1).getNodeValue());
                                                                        if(nl2.item(i1).getNodeName().equalsIgnoreCase("FIELD_SIZE")){
                                                                             output = "      "+el.getNodeName() + " ";
                                                                             output += this.fieldTypeMap.get(fieldType);
                                                                             String value = nl2.item(i1).getChildNodes().item(0).getNodeValue();
                                                                             if (!(value ==null || "".equals(value.trim()))){
                                                                            	 output+=" (" + value + "),";
                                                                             }else{
                                                                            	 output+=",";
                                                                             }
                                                                             p.println(output);
                                                                        }
                                                                    }
                                                                   
                                                            }

                                                    }
                                            }
                                            p.print(");");
                                            p.close();
                                    }
                            }
                    }
                    catch (Exception e)
                    {
                            System.err.println("Error writing to file");
                            e.printStackTrace();
                    }
            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
        }
        
        
        public static void main(String argv[]) {

        	ReadXMLTable read =  new ReadXMLTable();
        	read.createSQLFile("C:\\Anil Allewar\\Trainings\\DCM.xml", "C:\\Anil Allewar\\Trainings\\DCM.sql");
                

        }

        private String getTagValue(String sTag, Element eElement) {
                NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
                                .getChildNodes();
                Node nValue = (Node) nlList.item(0);

                return nValue.getNodeValue();

        }
}
