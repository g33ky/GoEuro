package com.goeuro.CsvCreator;
import java.util.List;

import com.goeuro.Client.Position;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * CSV exporter class
 */
public class CsvCreator {
private static final String DATAFILE = "goEuro.csv";
private static final String HEADER = "_id,name,type,latitude,longitude";
private static final String NEW_LINE = "\n";
/* 
 * method to create a new csv file  
 * and export the positions list to the new csv file
 * @params file
 * 			
 */
public static void creatFile(List<Position> file) throws IOException{
	
	
	//delte the file if it exists before creating a new file
	CsvCreator.deleteFile();
	
	BufferedWriter handler = new BufferedWriter(new FileWriter(DATAFILE));
	
	try{
		handler.append(HEADER);
		handler.append(NEW_LINE);
		
		for(Position positions : file )
		{
			
			handler.write(positions.toString());
			handler.append(NEW_LINE);
		}
		handler.close();
	}
	
		catch (Exception e) {
			e.printStackTrace();
	}
		finally{
			handler.close();
	}
}

/*
 * method to delete the csv file from the directory if it exists
 */

public static void deleteFile() throws IOException {
	Path path = Paths.get(DATAFILE);
	Files.deleteIfExists(path);
}

}



