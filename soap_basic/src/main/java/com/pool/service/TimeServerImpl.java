package com.pool.service;

import java.util.Date;

import javax.jws.WebService;
@WebService(endpointInterface="com.infinity.service.TimeServer")
public class TimeServerImpl implements TimeServer {

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	public Long getTimeAsElapsed() {
		return new Date().getTime();
	}

}
