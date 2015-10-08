package core;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParser {
	public static void main(String[] a) throws ParserConfigurationException, IOException, SAXException{
		
		String url = "http://learn2test.net/sdc.xml";
		
		String node = "kadu-response";
		
		String element_01 = "forms-action-type";
		String element_02 = "resultGrade";
		String element_03 = "kadu-index-info";
		String element_04 = "response-time";
		String element_05 = "categories";
		String attribute_01 = "count";
		
		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		
		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();
		
		// Load and Parse the XML document contains the complete XML as a Tree.
		Document doc = b.parse(url);
		
		// Optional
		doc.getDocumentElement().normalize();
		
		// Parsing elements
		NodeList nList = doc.getElementsByTagName(node);
		
		for (int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Action Type: "
						+ eElement.getElementsByTagName(element_01).item(0)
						.getChildNodes().item(0).getNodeValue());
				System.out.println("Result: "
						+ eElement.getElementsByTagName(element_02).item(0)
						.getChildNodes().item(0).getNodeValue());
				System.out.println("Index: "
						+ eElement.getElementsByTagName(element_03).item(0)
						.getChildNodes().item(0).getNodeValue());
				System.out.println("Response time: "
						+ eElement.getElementsByTagName(element_04).item(0)
						.getChildNodes().item(0).getNodeValue());
				
			}
		}
		
		// Parsing attribute
		NodeList nList2 = doc.getElementsByTagName(element_05);
		
		for (int i = 0; i < nList.getLength(); i++){
			Node nNode = nList2.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Number of categories: "
						+ eElement.getAttribute(attribute_01).trim());
				
			}
		}
				
	}

}
