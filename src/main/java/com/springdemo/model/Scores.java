package com.springdemo.model;

import java.io.Serializable;

public class Scores implements Serializable {

	public Scores(String name, int score) {
		super();
		// this.id = id;
		this.name = name;
		this.score = score;
	}

	
	  public Scores() { }
	 

	private int id;
	private String name;
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Scores [id=" + id + ",name=" + name + ",score=" + score + "]";
	}
}
