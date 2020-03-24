package com.trisuliswanto.covid19.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

@Generated("com.robohorse.robopojogenerator")
public class ResponseCovid19{

	@SerializedName("lastupdate")
	@Expose
	private String lastupdate;

	@SerializedName("meninggal")
	@Expose
	private String meninggal;

	@SerializedName("positif")
	@Expose
	private String positif;

	@SerializedName("sembuh")
	@Expose
	private String sembuh;

	@SerializedName("name")
	@Expose
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

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCovid19{" + 
			"meninggal = '" + meninggal + '\'' + 
			",positif = '" + positif + '\'' + 
			",sembuh = '" + sembuh + '\'' + 
			",name = '" + name + '\'' +
			",lastupdate = '" + lastupdate + '\'' +
			"}";
		}
}