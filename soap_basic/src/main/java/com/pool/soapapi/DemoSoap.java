package com.pool.soapapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import com.sun.xml.internal.ws.resources.SoapMessages;

public class DemoSoap {
	private static final String LocalName ="TimeRequest";
	private static final String Namespace ="http://service.infinity.com/";
	private static final String NamespacePrefix= "ms";
	private ByteArrayOutputStream out=null;
	private ByteArrayInputStream in=null;
	public static void main(String[] args) {
new DemoSoap().request();
	}
private void request() {

	try {
		SOAPMessage msg=cretatesoapmessage();
		SOAPEnvelope env=msg.getSOAPPart().getEnvelope();
		Name lookupName=createQName(msg);
		SOAPHeader hdr=env.getHeader();
		hdr.addHeaderElement(lookupName).addTextNode("time_request");
		
		out=new ByteArrayOutputStream();
		msg.writeTo(out);
		
		SOAPMessage response=processRequest();
		extractContentAndPrint(response);
	} catch (Exception e) {
		e.printStackTrace();
	}
}


private SOAPMessage processRequest() {
	processIncomingSoap();
	coordinateStreams();
	return createSoapMessage(in);
}

private void coordinateStreams() {
	in=new ByteArrayInputStream(out.toByteArray());
	out.reset();
}
private void processIncomingSoap() {
	try {
		SOAPMessage msg=createSoapMessage(in);
		Name lookUpQName=createQName(msg);
		SOAPHeader header=msg.getSOAPHeader();
		Iterator it=header.getChildElements(lookUpQName);
		Node next=(Node) it.next();
		String value=(next==null)?"Error":next.getValue();
		if(value.toLowerCase().contains("time_request")) {
			String now=new Date().toString();
			SOAPBody body=msg.getSOAPBody();
			body.addBodyElement(lookUpQName).addTextNode(now);
			msg.saveChanges();
			msg.writeTo(out);
			System.out.println("PROCESSING :"+msg);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
private SOAPMessage createSoapMessage(ByteArrayInputStream in) {
	SOAPMessage msg=null;
	try {
		MessageFactory mf=MessageFactory.newInstance();
		msg=mf.createMessage(null,in);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
}
private void extractContentAndPrint(SOAPMessage msg) {
	try {
		SOAPBody body=msg.getSOAPBody();
		Name lookupQName=createQName(msg);
		Iterator it=body.getChildElements(lookupQName);
		Node next=(Node) it.next();
		String value=(next==null)?"ERROR":next.getValue();
		System.out.println("extractContentAndPrint:::"+value);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
private Name createQName(SOAPMessage msg) {
	Name name=null;
	try {
		SOAPEnvelope env=msg.getSOAPPart().getEnvelope();
		name=env.createName(LocalName, NamespacePrefix, Namespace);
	} catch (SOAPException e) {
		e.printStackTrace();
	}
	return name;
}
private SOAPMessage cretatesoapmessage() {
	SOAPMessage msg=null;
	try {
		MessageFactory mf=MessageFactory.newInstance();
		msg=mf.createMessage();
	} catch (SOAPException e) {
		e.printStackTrace();
	}
	return msg;
}
}
