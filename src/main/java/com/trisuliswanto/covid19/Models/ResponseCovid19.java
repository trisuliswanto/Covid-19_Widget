package com.trisuliswanto.covid19.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseCovid19{

	@SerializedName("meninggal")
	private String meninggal;

	@SerializedName("positif")
	private String positif;

	@SerializedName("sembuh")
	private String sembuh;

	@SerializedName("name")
	private String name;

	public void setMeninggal(String meninggal){
		this.meninggal = meninggal;
	}

	public String getMeninggal(){
		return meninggal;
	}

	public void setPositif(String positif){
		this.positif = positif;
	}

	public String getPositif(){
		return positif;
	}

	public void setSembuh(String sembuh){
		this.sembuh = sembuh;
	}

	public String getSembuh(){
		return sembuh;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCovid19{" + 
			"meninggal = '" + meninggal + '\'' + 
			",positif = '" + positif + '\'' + 
			",sembuh = '" + sembuh + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}