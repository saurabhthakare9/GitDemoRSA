package Part1;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class AddRequest1_ValidateStatusCode {

	//Note - We have different url for different request. 
	//FOr ex. if we work in sequence like. 
	//STep 1- I have post student name from No 1 to 10 using post request
	//Step 2- I have retrieve the info from server of this 10 student by using get request.
	//Step 3- i have updated student name on No 2 using update request and again using get request i have retrived the 
	//			info of student.
	//So, for this all request the URl are different.Usually the base url remain same.but apart from that your path parameter,
	//query parameter are different for different request.
	
	//Validate add request for API
	//given -all input details
	//when-submit the API
	//then-validate the response
	
	public static void main(String[] args) {
//we have used json present doc1--> C:\Users\HP\API projects\RahulAcademyAPI
//Ex 1 - Validate the status code as 200
		//Complete URL as per postman - https://reqres.in/api/users?delay=3
		//but here we are dividing this URL in BASE URI, Resource and query param and using this 3 parts as below
		
		RestAssured.baseURI="https://reqres.in";
		given().log().all().queryParam("delay","3")	
		
		//for 2 or more query parameter --> .queryParam("category","electronics").queryParam("price","499.99").queryParam("stock","50")
		//In body , we need to directly paste the request body inside double quote i.e. ,.body(" Request body") and other formatting is done by java automatically
		.body("{\r\n"
				+ "  \"name\": \"John Doe\",\r\n"
				+ "  \"job\": \"Software Engineer\"\r\n"
				+ "}").when().post("api/users")
		
		.then().log().all().assertThat().statusCode(201);
		System.out.println("This changes done on line 1");
		System.out.println("This changes done on line 2");
		System.out.println("This changes done on line 3");
		//In general, status code is 200 but for mock we need to take 201 as we are creating new resourse
	}

}
