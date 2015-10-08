package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParser {
	public static void main(String[] a) throws IOException, XMLStreamException {
		URL url = new URL("http://learn2test.net/sdc.xml");
		
		final String element_01 = "forms-action-type";
		final String element_02 = "resultGrade";
		final String element_03 = "kadu-index-info";
		final String element_04 = "response-time";
		
		final String element_05 = "categories";
		
		final String element_name_01 = "Action Type: ";
		final String element_name_02 = "Result: ";
		final String element_name_03 = "Index: ";
		final String element_name_04 = "Response time: ";
		
		final String element_name_05 = "Number of categories: ";
		
		InputStream in = url.openStream();
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		int eventType = reader.getEventType();
		
		while (reader.hasNext()){
			
			eventType = reader.next();
			
			if (eventType == XMLStreamReader.START_ELEMENT){
				if (reader.getLocalName().equals(element_01)){
					System.out.println(element_name_01 + reader.getElementText());
				}
				if (reader.getLocalName().equals(element_02)){
					System.out.println(element_name_02 + reader.getElementText());
				}
				if (reader.getLocalName().equals(element_03)){
					System.out.println(element_name_03 + reader.getElementText());
				}
				if (reader.getLocalName().equals(element_04)){
					System.out.println(element_name_04 + reader.getElementText());
				}
				if (reader.getLocalName().equals(element_05)){
					System.out.println(element_name_05 + reader.getAttributeValue(0));
				}
			}
			
		}
	}

}
