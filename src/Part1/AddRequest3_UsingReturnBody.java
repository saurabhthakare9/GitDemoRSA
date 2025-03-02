package Part1;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
//we have used json present doc1--> C:\Users\HP\API projects\RahulAcademyAPI
public class AddRequest3_UsingReturnBody {
	public static void main(String[] args) {
		
//In this ex, we have created one method in other package,we are storing our payload there and in body we are just calling\
//that method, so we dont need to mention our total payload here in body.we can just call that method as in row 14
		
		RestAssured.baseURI="https://reqres.in";
		given().log().all().queryParam("delay","3").header("Content-Type","application/json")	
		.body(Payload.AddRequestPayload())
		
		.when().post("api/users")
		
		.then().log().all().assertThat().statusCode(201).body("job",equalTo("Software Engineer")) //to use equalTo we need import it from hamcrest.Matchers;
		.header("Server","cloudflare");
		
	}
}
