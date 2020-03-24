package com.trisuliswanto.covid19.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Metadata{

	@SerializedName("lastUpdatedAt")
	private String lastUpdatedAt;

	public void setLastUpdatedAt(String lastUpdatedAt){
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedAt(){
		return lastUpdatedAt;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"lastUpdatedAt = '" + lastUpdatedAt + '\'' + 
			"}";
		}
}