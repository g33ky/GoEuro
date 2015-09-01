package com.goeuro.Client;
import java.util.List;

import com.goeuro.CsvCreator.CsvCreator;
import com.goeuro.Parser.Parser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/*
 * Rest client to fetch the json document and produce the csv file
 */
public class RestClient {
	
	// API endpoint from which we will fetch the json document
	private static final String ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	
	public void run(String cityName){
	try {

		Client client = Client.create();

		WebResource resource = client
		   .resource(ENDPOINT+cityName);

		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Http Error : " + response.getStatus());
		}
		
		//the the response from the requested endpoint
		String output = response.getEntity(String.class);
		
		Parser outputParser = new Parser();
		
		//calling the parser to parse the response to obtain the keys
		List<Position> list  = outputParser.parse(output);
		
		//calling the csv exporter method
		CsvCreator.creatFile(list);
		
	  } catch (Exception e) {

		e.printStackTrace();

	  }
		
	}
}
