package com.pool.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.infinity.service.TimeServer;

public class TimeClient {

	public static void main(String[] args) throws MalformedURLException {
	URL url=new URL("http://192.168.1.96:8088/timerService?wsdl");
	QName qName=new QName("http://service.infinity.com/","TimeServerImplService");
	Service service=Service.create(url, qName);
	TimeServer timeServer=service.getPort(TimeServer.class);
	System.out.println(timeServer.getTimeAsString());
	System.out.println(timeServer.getTimeAsElapsed());

	}

}
