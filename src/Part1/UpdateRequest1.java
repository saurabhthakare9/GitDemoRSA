package Part1;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;

public class UpdateRequest1 {
	//we have used json present doc1--> C:\Users\HP\API projects\RahulAcademyAPI
	public static void main(String[] args) {
		
		//In this ex,we are updating the things.
		//1.For that we need to grab some unique id from the responese   
		
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
				String username=js.get("name"); //.get("name")-->Here name is path of the json from the response body.
				System.out.println("name is "+ username);
				
	//Now to use put method
	//here,in body we need to pass our unique i.e. name we have already saved it.for this name i want to change job hence pass that name below in body		
	//this path is directly heading is json.if suppose name is inside one heading StsudentName then in that case path will be StudentName.Name
	//In this ex, for this name we are changing job description to Product manager, so it should get updated
				String NewJobDescription="Product Manager";
				
				given().log().all().queryParam("delay","1").header("Content-Type","application/json")	
				.body("{\r\n"
						+ "  \"name\": \""+username+"\",\r\n"
						+ "  \"job\": \""+ NewJobDescription+"\"\r\n"
						+ "}\r\n"
						+ "")
				
				.when().put("api/users/2")
				.then().assertThat().statusCode(200).body("job",equalTo("Product Manager"));
	
	//Now after updating if we want to verify whatever changes updated or not , we will use get request 
	// Get request 
	// TO validate this, we need to extract value of job description  "Product Manager"from get response and then need to compare it with job
	//			description we have updateded in put request.As we are comparing we have saved that new job description to one string
	// as on line 39
			
		String GetNewJobDescResponse = given().log().all().queryParam("delay","1").queryParam("name","John")
				.when().get("api/users/name").then().statusCode(200).extract().response().asString();
		
		JsonPath js1= new JsonPath(GetNewJobDescResponse);
		String ActualJob=js1.getString("job");
	
	//now here we need to compare ActualJob and NewJobDescription	
	//Below comparison is done by using testng framework
		Assert.assertEquals(ActualJob, NewJobDescription);
	
	}
	
	
}
