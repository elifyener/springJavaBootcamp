package com.godoro.spring.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerId;
	
	private String playerName;
	
	private double avarageScore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

	public Player() {
	}
	
	public Player(long playerId, String playerName, double avarageScore) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.avarageScore = avarageScore;
	}
	
	public long getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public double getAvarageScore() {
		return avarageScore;
	}
	
	public void setAvarageScore(double avarageScore) {
		this.avarageScore = avarageScore;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
