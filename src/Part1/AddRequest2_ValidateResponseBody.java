package Part1;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddRequest2_ValidateResponseBody {
	//we have used json present doc1--> C:\Users\HP\API projects\RahulAcademyAPI
//Ex 2 - Validate the content of response body and header
//TO check headers ,after hitting request in Postman click on Headers and you will get different header there.
//from that diff headers you can validate any header
//for this response in API, we have header as c=PostmanRuntime/7.43.0
	public static void main(String[] args) {
		
	
	RestAssured.baseURI="https://reqres.in";
	given().log().all().queryParam("delay","3").header("Content-Type","application/json")	
	.body("{\r\n"
			+ "  \"name\": \"John Doe\",\r\n"
			+ "  \"job\": \"Software Engineer\"\r\n"
			+ "}\r\n"
			+ "")
	
	.when().post("api/users")
	
	.then().log().all().assertThat().statusCode(201).body("job",equalTo("Software Engineer")) //to use equalTo we need import it from hamcrest.Matchers;
	.header("Server","cloudflare");
	//In Response body, we can validate content of that body as per above code in line 15.
	//if we have more than 2 thing to validate then--> .body("key",equalTo("value")).body("key",equalTo("value")).body("key",equalTo("value"))
	//In this ex we have key job and its value is Software Engineer in response body hence we are validating it
}
}
