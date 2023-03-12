package com.pool.richerdatatype;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public class Teams {
private TeamsUtility utils;
public Teams() {
	utils=new TeamsUtility();
	utils.makeTestTeam();
}
@WebMethod
public Team getTeam(String name) {
	return utils.getTeam(name);
}
@WebMethod
public List<Team> getTeamList(){
	return utils.getTeams();
}
}
