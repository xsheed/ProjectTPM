package com.example.proyektpmsportapidatabase.model.sport;

import com.google.gson.annotations.SerializedName;

public class SportsItem{

	@SerializedName("idSport")
	private String idSport;

	@SerializedName("strFormat")
	private String strFormat;

	@SerializedName("strSport")
	private String strSport;

	@SerializedName("strSportThumb")
	private String strSportThumb;

	@SerializedName("strSportThumbGreen")
	private String strSportThumbGreen;

	@SerializedName("strSportDescription")
	private String strSportDescription;

	public void setIdSport(String idSport){
		this.idSport = idSport;
	}

	public String getIdSport(){
		return idSport;
	}

	public void setStrFormat(String strFormat){
		this.strFormat = strFormat;
	}

	public String getStrFormat(){
		return strFormat;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrSportThumb(String strSportThumb){
		this.strSportThumb = strSportThumb;
	}

	public String getStrSportThumb(){
		return strSportThumb;
	}

	public void setStrSportThumbGreen(String strSportThumbGreen){
		this.strSportThumbGreen = strSportThumbGreen;
	}

	public String getStrSportThumbGreen(){
		return strSportThumbGreen;
	}

	public void setStrSportDescription(String strSportDescription){
		this.strSportDescription = strSportDescription;
	}

	public String getStrSportDescription(){
		return strSportDescription;
	}

	@Override
 	public String toString(){
		return 
			"SportsItem{" + 
			"idSport = '" + idSport + '\'' + 
			",strFormat = '" + strFormat + '\'' + 
			",strSport = '" + strSport + '\'' + 
			",strSportThumb = '" + strSportThumb + '\'' + 
			",strSportThumbGreen = '" + strSportThumbGreen + '\'' + 
			",strSportDescription = '" + strSportDescription + '\'' + 
			"}";
		}
}