package com.example.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Fruit.class})
public class FruitResponse {
	
	@XmlElementWrapper(name = "Fruits")
	@XmlElement(name = "Fruit")
	private List<Fruit> fruitlist;
	public FruitResponse(List<Fruit> fruitlist)
	{
	    this.fruitlist = fruitlist;
	}
	public List<Fruit> getFruitlist() {
		return fruitlist;
	}
	@XmlElementRef
	public void setFruitlist(List<Fruit> fruitlist) {
		this.fruitlist = fruitlist;
	}

}
