package Part1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;

public class GetRequest1 {
public static void main(String[] args) {
	//we have used json present doc1--> C:\Users\HP\API projects\RahulAcademyAPI
//Note- the code is same as update request till row 46.
//Here, by using get request we are checking whatever we have updated is updated or not
		//In this ex,we are updating the things.
		//1.For that we need to grab some unique id from the response   
		
				RestAssured.baseURI="https://reqres.in";
				
	//Here, we are saving response in one string and then we are printing it.
				String response= given().log().all().queryParam("delay","3").header("Content-Type","application/json")	
				.body(Payload.AddRequestPayload())
				
				.when().post("api/users")
				
				.then().log().all().assertThat().statusCode(201).body("job",equalTo("Software Engineer")) //to use equalTo we need import it from hamcrest.Matchers;
				.header("Server","cloudflare").extract().response().asString();
				
				System.out.println( "Response is " + response);
	//Now from this response i want to extract name i.e. some unique value which is present in all the request		
	//for that we need use JsonPath class-->this class takes input as string and covert it to json
				
				JsonPath js = new JsonPath(response);				
				String username=js.get("name");
				System.out.println("name is "+ username);
				
	//Now to use put method
	//here,in body we need to pass our unique i.e. name we have already saved it.for this name i want to change job hence pass that name below in body		
				given().log().all().queryParam("delay","1").header("Content-Type","application/json")	
				.body("{\r\n"
						+ "  \"name\": \""+username+"\",\r\n"
						+ "  \"job\": \"Product Manager\"\r\n"
						+ "}\r\n"
						+ "")
				
				.when().put("api/users/2")
				.then().assertThat().statusCode(200).body("job",equalTo("Product Manager"));
		
	

//Get request 
//In row 55,if we have some unique value as which is value of username from above code as in row 33.
//then we are sending like below as in 53
//So we are saving response in one string and then extracting the value which we have updated				

String getResponse = given().log().all().queryParam("page","2").queryParam("name",username)
.when().get("api/users").then().assertThat().log().all().statusCode(200).extract().response().asString();

JsonPath js1= new JsonPath(getResponse);
String actualJob = js1.getString("job") ;

}
}