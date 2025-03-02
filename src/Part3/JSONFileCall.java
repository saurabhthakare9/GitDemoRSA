package Part3;
import org.json.JSONObject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import org.testng.annotations.*;
public class JSONFileCall {

	//Here instead of passing request body , we are taking path of json file as request body which is in our PC
	//This is imp one as we need to use like this
	@Test
	public void Jsondirectcall() throws IOException {
	RestAssured.baseURI="https://reqres.in";
	given().log().all().queryParam("delay","3")	
	.body(new String(Files.readAllBytes(Paths.get("C:\\API projects\\RahulAcademyAPI\\Part 3-Handling Dynamic json with parameterization\\Jsonfile1.json"))))
	.when().post("api/users")
	.then().log().all().assertThat().statusCode(201);
	}
}
