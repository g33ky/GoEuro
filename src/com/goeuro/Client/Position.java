package com.goeuro.Client;

public class Position {

	
private int  _id;
private String name;
private String type;
private double longitude;
private double latitude;

/*
 * _id getter method
 */

public int getId(){
	return _id;
}

/*
 * _id setter method
 */

public void setId(Integer _id){
	this._id = _id;
}

/*
 * name getter method
 */
public String getName(){
	return name;
}

/*
 * name setter method
 */

public void setName(String name){
	this.name = name;
}

/*
 * type getter method
 */

public String getType(){
	return type;
}

/*
 * type setter method
 */

public void setType(String type){
	this.type = type;
}

/*
 * latitude getter method
 */

public double getLatitude() {
    return latitude;
 
}

/*
 * latitude setter method
 */
public void setLatitude(double latitude) {
      this.latitude = latitude;
}

/*
 * longitude getter method
 */

public double getLongitude() {
    return longitude;
}

/*
 * longitude setter method
 */

public void setLongitude(double longitude) {
      this.longitude = longitude;
}

/*
 * overriding the toString method to return the comma separated values 
 * that are going to be exported to csv
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return String.format("%d,%s,%s,%f,%f",_id,name,type,latitude,longitude);
	
}

}

