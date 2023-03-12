package com.pool.service;

import javax.jws.WebService;
import com.infinity.model.Score;
@WebService
public class ScoreService {
private static Score score=new Score();
public Score getScore() {
	return score;
}
public Score updateScore(int wins,int loose,int ties) {
	score.setWins(wins);
	score.setTies(ties);
	score.setLoose(loose);
	return score;
}
}
