package com.pool.service.main;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

import com.infinity.service.TimeServerImpl;

public class TimeServerPublisher {

	public static void main(String[] args) {
		
		System.out.println("got");
		Endpoint.publish(" http://192.168.1.96:8088/timerService", new TimeServerImpl());

	}

}
