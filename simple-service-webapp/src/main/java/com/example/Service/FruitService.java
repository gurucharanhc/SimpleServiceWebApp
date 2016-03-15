package com.example.Service;

import com.example.model.Fruit;

public class FruitService {
	
	public String getFruits(String color, Fruit[] fruitArray){
		StringBuilder strBuilder= new StringBuilder();
		if(color.equalsIgnoreCase("any")){
			int rand=(int) ((Math.random()*100)%fruitArray.length);
			System.out.println("Random pick :: "+ rand);
			strBuilder.append(fruitArray[rand].getEngName());
			strBuilder.append(" : ");
			strBuilder.append(fruitArray[rand].getFrName());
			return strBuilder.toString();
		}
		for(int i=0; i< fruitArray.length;i++){
			if(fruitArray[i].getColor().equals(color)){
				strBuilder.append(fruitArray[i].getEngName());
				strBuilder.append(" : ");
				strBuilder.append(fruitArray[i].getFrName());
				break;
			}
		}
		return strBuilder.toString();
	}
	
	public String getFruitsByArrayIndex(int id, Fruit[] fruitArray, String locale){
		if(id>= fruitArray.length || id < 0){
			return "Index out of bound exception :: fruit not found";
		}
		if(locale.equalsIgnoreCase("fr")){
			return "French name of the fruit : "+ fruitArray[id].getFrName();
		}
		return "English name of the fruit : "+fruitArray[id].getEngName();
	}
	
	
	public String deleteFruitByArrayIndex(int id, Fruit[] fruitArray){
		if(id>= fruitArray.length || id < 0){
			return "Index out of bound exception :: fruit not found";
		}
		return "Deleted Fruit :: "+ fruitArray[id].getEngName();
	}

}
