package com.example.proyektpmsportapidatabase.model.sport;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SportResponse{

	@SerializedName("sports")
	private ArrayList<SportsItem> sports;

	public void setSports(ArrayList<SportsItem> sports){
		this.sports = sports;
	}

	public ArrayList<SportsItem> getSports(){
		return sports;
	}

	@Override
 	public String toString(){
		return 
			"SportResponse{" + 
			"sports = '" + sports + '\'' + 
			"}";
		}
}