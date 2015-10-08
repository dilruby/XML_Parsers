package core;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserr extends DefaultHandler {
	public static void main(String[] a) throws ParserConfigurationException, SAXException, IOException {
		String url = "http://learn2test.net/sdc.xml";

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

		// Create a "parser factory" for creating SAX parsers
		SAXParserFactory f = SAXParserFactory.newInstance();

		// Now use the parser factory to create a SAXParser object
		SAXParser p = f.newSAXParser();

		// Create an instance of this class; it defines all the handler methods
		DefaultHandler h = new DefaultHandler() {
			boolean handler_01 = false;
			boolean handler_02 = false;
			boolean handler_03 = false;
			boolean handler_04 = false;
			boolean handler_05 = false;
			String attribute_01;

			// a - uri; b - localName; c - qName; d - attributes
			public void startElement(String a, String b, String c, Attributes d) {
				if (c.equalsIgnoreCase(element_01)) {
					handler_01 = true;
				}
				if (c.equalsIgnoreCase(element_02)) {
					handler_02 = true;
				}
				if (c.equalsIgnoreCase(element_03)) {
					handler_03 = true;
				}
				if (c.equalsIgnoreCase(element_04)) {
					handler_04 = true;
				}
				if (c.equalsIgnoreCase(element_05)) {
					handler_05 = true;
					attribute_01 = d.getValue("count");
				}
			}

			public void endElement(String a, String b, String c) throws SAXException {

			}

			public void characters(char ch[], int start, int length) {
				if (handler_01) {
					System.out.println(element_name_01 + new String(ch, start, length));
					handler_01 = false;
				}
				if (handler_02) {
					System.out.println(element_name_02 + new String(ch, start, length));
					handler_02 = false;
				}
				if (handler_03) {
					System.out.println(element_name_03 + new String(ch, start, length));
					handler_03 = false;
				}
				if (handler_04) {
					System.out.println(element_name_04 + new String(ch, start, length));
					handler_04 = false;
				}
				if (handler_05) {
					System.out.println(element_name_05 + attribute_01);
					handler_05 = false;
				}
			}
		};
		p.parse(url, h);
	}
}
