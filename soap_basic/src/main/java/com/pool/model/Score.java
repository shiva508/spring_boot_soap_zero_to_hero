package com.pool.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Score {
private int wins,loose,ties;

public Score() {
	super();
}

public int getWins() {
	return wins;
}

public void setWins(int wins) {
	this.wins = wins;
}

public int getLoose() {
	return loose;
}

public void setLoose(int loose) {
	this.loose = loose;
}

public int getTies() {
	return ties;
}

public void setTies(int ties) {
	this.ties = ties;
}

@Override
public String toString() {
	return "Score [wins=" + wins + ", loose=" + loose + ", ties=" + ties + "]";
}

}
