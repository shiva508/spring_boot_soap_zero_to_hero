package com.pool.richerdatatype;

import java.io.Serializable;

public class Player implements Serializable{
private String name;
private String nikename;
public Player(String name, String nikename) {
	super();
	this.name = name;
	this.nikename = nikename;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNikename() {
	return nikename;
}
public void setNikename(String nikename) {
	this.nikename = nikename;
}

}
