package com.pool.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name="TimeServer",targetNamespace="http://service.infinity.com")
@SOAPBinding(style= Style.RPC)
public interface TimeServer {
	@WebMethod
	@WebResult(partName="return")
	String getTimeAsString();
	@WebMethod
	@WebResult(partName="return")
	Long getTimeAsElapsed();

}
