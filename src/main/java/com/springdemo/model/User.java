package com.springdemo.model;

import java.io.Serializable;

public class User implements Serializable {

	public User(String name,String password) {
		super();
		//this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public User() {
	}
	
	private int id;
	private String name;
	private String password;
	
	private Scores scores;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", scores=" + scores + "]";
	}

	
}
