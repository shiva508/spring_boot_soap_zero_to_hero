package com.pool.model.xml;

import java.io.File;

import javax.wsdl.Output;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlWriter {
	public static Node getEmployee(Document doc, String id, String name, String age, String role, String gender) {
		Element employee = doc.createElement("Employee");
		// set id attribute
		employee.setAttribute("id", id);
		// create name element
		employee.appendChild(getEmployeeElements(doc, employee, "name", name));
		// create age element
		employee.appendChild(getEmployeeElements(doc, employee, "age", age));
		// create role element
		employee.appendChild(getEmployeeElements(doc, employee, "role", role));
		// create gender element
		employee.appendChild(getEmployeeElements(doc, employee, "gender", gender));
		return employee;
	}

	public static Node getEmployeeElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dbFactory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element rootElement = doc.createElementNS("https://www.journaldev.com/employee", "Employees");
			doc.appendChild(rootElement);
			rootElement.appendChild(getEmployee(doc, "1", "Pankaj", "29", "Java Developer", "Male"));
			rootElement.appendChild(getEmployee(doc, "2", "Lisa", "35", "Manager", "Female"));
			
			//for output to file, console
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource=new DOMSource(doc);
			
			//for pretty print
			StreamResult streamResult=new StreamResult(System.out);
			StreamResult streamResult2=new StreamResult(new File("your.xml"));
			transformer.transform(domSource, streamResult);
			transformer.transform(domSource, streamResult2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
