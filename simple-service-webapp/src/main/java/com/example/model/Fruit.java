package com.example.model;


public class Fruit {
	public String engName;
	public String frName;
	public String color;
	
	
	public Fruit(){}
	
	public Fruit(String engName, String frName, String color) {
		super();
		this.engName = engName;
		this.frName = frName;
		this.color = color;
	}


	public String getEngName() {
		return engName;
	}


	public void setEngName(String engName) {
		this.engName = engName;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

}
