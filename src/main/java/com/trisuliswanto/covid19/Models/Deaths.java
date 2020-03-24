package com.trisuliswanto.covid19.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Deaths{

	@SerializedName("value")
	private int value;

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Deaths{" + 
			"value = '" + value + '\'' + 
			"}";
		}
}