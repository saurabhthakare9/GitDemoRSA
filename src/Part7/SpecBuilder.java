package Part7;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Part6.BaseClass1_AddPlace;
import Part6.BaseClass2_Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	public static void main(String[] args) {

		//Creating object for base class and use set method 
		BaseClass1_AddPlace b =new BaseClass1_AddPlace();
		b.setAccuracy(50);
		b.setAddress("29, side layout, cohen 09");
		b.setLangauge("French-IN");
		b.setName("Frontline house");
		b.setWebsite("http://google.com");
		
		List<String> mylist =new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");		
		b.setTypes(mylist);
			
		BaseClass2_Location l= new BaseClass2_Location();
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		b.setLocation(l);

//we used the same things till line 38
//Now we have Base uri,content type ,query par common for different request hence we can use below format by creating object of
//RequestSpecBuilder() class and return type RequestSpecification
//Similarly we have status code and content type common after then() so we need to create object of RequestSpecBuilder() class
//and return type as ResponseSpecification
		
		 RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
		.setContentType(ContentType.JSON).build();
		 
		 ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		 RequestSpecification res=given().spec(req).body(b);
		
		Response response = res.when().post("/maps/api/place/add/json")
					.then().spec(resspec).extract().response();
	 
		String responseString=response.asString();
		System.out.println(responseString);
		

	}
}
