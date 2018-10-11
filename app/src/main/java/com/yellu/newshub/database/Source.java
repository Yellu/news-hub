package com.yellu.newshub.database;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Source{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Object id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Source{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}