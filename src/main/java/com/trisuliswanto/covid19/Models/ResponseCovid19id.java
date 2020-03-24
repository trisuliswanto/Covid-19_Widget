package com.trisuliswanto.covid19.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseCovid19id{

	@SerializedName("recovered")
	private Recovered recovered;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("activeCare")
	private ActiveCare activeCare;

	@SerializedName("confirmed")
	private Confirmed confirmed;

	@SerializedName("deaths")
	private Deaths deaths;

	public void setRecovered(Recovered recovered){
		this.recovered = recovered;
	}

	public Recovered getRecovered(){
		return recovered;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setActiveCare(ActiveCare activeCare){
		this.activeCare = activeCare;
	}

	public ActiveCare getActiveCare(){
		return activeCare;
	}

	public void setConfirmed(Confirmed confirmed){
		this.confirmed = confirmed;
	}

	public Confirmed getConfirmed(){
		return confirmed;
	}

	public void setDeaths(Deaths deaths){
		this.deaths = deaths;
	}

	public Deaths getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCovid19id{" + 
			"recovered = '" + recovered + '\'' + 
			",metadata = '" + metadata + '\'' + 
			",activeCare = '" + activeCare + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}