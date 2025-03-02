package Part6;

import io.restassured.RestAssured;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

public class Serialization_GoogleMaps {
public static void main(String[] args) {

	//Creating object for base class and use set method 
	BaseClass1_AddPlace b =new BaseClass1_AddPlace();
	b.setAccuracy(50);
	b.setAddress("29, side layout, cohen 09");
	b.setLangauge("French-IN");
	b.setName("Frontline house");
	b.setWebsite("http://google.com");
	
	//Here return type for types in List, so we need to build list first and then 
	//we need to pass that list in settypes() method
	List<String> mylist =new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	
	b.setTypes(mylist);
	
	//Now for location we have another sub class and return type is class
	//so we need to create object of that class first and then we need to pass set values as below
	
	BaseClass2_Location l= new BaseClass2_Location();
	
	l.setLat(-38.383494);
	l.setLng(33.427362);
	
	//Now we need to pass this above object simply in b.setLocation(l);
	b.setLocation(l);
	
	//Now our main base class is BaseClass1_AddPlace so in body we need to pass object of this class as we have already created 
	//in line 20 
	RestAssured.baseURI="https://rahulshettyacademy.com";
 
	Response res=given().log().all().queryParam("key","qaclick123")
 .body(b).when().post("/maps/api/place/add/json")
 .then().assertThat().statusCode(200).extract().response();
 
	String responseString=res.asString();
	System.out.println(responseString);
	

}
}
