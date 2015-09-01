package com.goeuro.Parser;

import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

import com.goeuro.Client.Position;

/*
 * JSON Parser that parses the json array we fetched from the endpoint 
 * to produce a list of the desired keys 
 */

public class Parser {
	
	//parsing method that accepts the json document as an argument
	public List<Position> parse(String output){
		
	List<Position> positionsList = new Vector<Position>();
	
	try{
		
		
	JSONArray jsonOutput = new JSONArray(output);
	
	for(int i = 0; i < jsonOutput.length(); i++)
	{
			
		JSONObject object = jsonOutput.getJSONObject(i);
		
		Position p = new Position();
		
		p.setId(object.getInt("_id"));
		p.setName(object.getString("name"));
		p.setType(object.getString("type"));
		JSONObject geoPosition = object.getJSONObject("geo_position");
		p.setLatitude(geoPosition.getDouble("latitude"));
		p.setLongitude(geoPosition.getDouble("longitude"));
		
		positionsList.add(p);
	}

}
	 catch (Exception e) {

			e.printStackTrace();

		  }
	 return positionsList;
	}
}
	