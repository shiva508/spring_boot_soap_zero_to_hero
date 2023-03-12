package com.pool.model.xml;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlReader {
	private static final String CONFIG_FILE = "/employee.xml";
	URL patUrl = getClass().getResource(CONFIG_FILE);

	public static Employee getEmployee(Node node) {
		Employee employee = new Employee();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			employee.setName(getTagValue("name", element));
			employee.setAge(Integer.parseInt(getTagValue("age", element)));
			employee.setGender(getTagValue("gender", element));
			employee.setRole(getTagValue("role", element));
		}
		return employee;
	}

	public static String getTagValue(String tag, Element element) {
		NodeList list = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = list.item(0);
		return node.getNodeValue();
	}

	public static void main(String[] args) {
		XmlReader x = new XmlReader();

		File xmlFile = new File(x.patUrl.getFile());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element:" + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("Employee");
			List<Employee> empList = new LinkedList<>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				empList.add(getEmployee(nodeList.item(i)));
			}
			for (Employee employee : empList) {
				System.out.println(employee);
			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.getStackTrace();
		}

	}

}
