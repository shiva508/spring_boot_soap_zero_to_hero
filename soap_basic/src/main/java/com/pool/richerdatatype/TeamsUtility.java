package com.pool.richerdatatype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamsUtility implements Serializable{
public  Map<String, Team> teamMap;
public TeamsUtility(){
	teamMap=new HashMap<String, Team>();
}
	public void makeTestTeam() {
		List<Team> teams=new ArrayList<Team>();
		Player chico = new Player("Leonard Marx","Chico");
		Player groucho = new Player("JuliusMarx", "Groucho");
		Player harpo = new Player("Adolph Marx","Harpo");
		
		List<Player> mb = new ArrayList<Player>();
		mb.add(chico); 
		mb.add(groucho);
		mb.add(harpo);
		Team marx_brothers = new Team(mb,"Marx Brothers");
		teams.add(marx_brothers);
		stoteTeams(teams);
		
	}

	private void stoteTeams(List<Team> teams) {
		for (Team team : teams) {
			teamMap.put(team.getName(), team);
		}
	}
	public Team getTeam(String name) {
		return teamMap.get(name);
	}

	public List<Team> getTeams() {
		List<Team> list=new ArrayList<Team>();
		Set<String> all=teamMap.keySet();
		for (String kename : all) {
			list.add(teamMap.get(kename));
		}
		return list;
	}

}
