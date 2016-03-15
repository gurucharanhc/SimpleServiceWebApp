package com.example.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.Service.FruitService;
import com.example.model.Fruit;

@Path("fruits")
// xml or json because we are returning array
//@Produces({"application/xml", "application/json"})
public class Fruits {
	public static Fruit[]  fruits={
				 new Fruit ("raspberry","framboise","red"),
				 new Fruit("Orange", "Orange", "orange"),
				 new Fruit("lemon","citron","yellow"),
				 new Fruit("lime","citron vert","green"),
				 new Fruit("blueberry","myrtille","blue"),
				 new Fruit("blackberry","mure","black"),
		};
		
	/**
	 * If there is no query parameter then assign default
	 * Ex: http://localhost:8081/simple-service-webapp/webapi/fruits
	 * Ex: http://localhost:8081/simple-service-webapp/webapi/fruits?color=red
	 * @param color
	 * @return
	 */
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getFruit(	@DefaultValue("any") @QueryParam("color") String color){
		FruitService fruitServiceObj = new FruitService();
		return fruitServiceObj.getFruits(color, fruits);
	}
	
	/**
	 * Ex: http://localhost:8081/simple-service-webapp/webapi/fruits/1
	 * Make sure to add accept-language = fr in your url to test fr locale
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	public String getFruitByIndex(@PathParam("id") Integer id, @HeaderParam("accept-language") String locale){
		FruitService fruitServiceObj = new FruitService();
		return fruitServiceObj.getFruitsByArrayIndex(id, fruits, locale);
	}
	
	
	/**
	 * http://localhost:8081/simple-service-webapp/webapi/fruits/2
	 * Note use DELETE in postmanclient or any other Rest client
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	public String deleteFruitByIndex(@PathParam("id") Integer id){
		FruitService fruitServiceObj = new FruitService();
		return fruitServiceObj.deleteFruitByArrayIndex(id, fruits);
	}
	
	
}
