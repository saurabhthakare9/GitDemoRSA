package Part3;

import org.json.JSONObject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
  
class DynamicJSON1 {

	@Test
	public void Addbook() {

		//Step 1-Grab the id from the response of Post Request
		RestAssured.baseURI="http://216.10.245.166";
		String AddBookResponse= given().log().all().header("Content-Type","application/json").body(Payload.BookPayload())
		.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		
		JSONObject js = ReUsableMethods.rawToJson(AddBookResponse);
		JsonPath js2 = new JsonPath(js.toString()); 
		String id=js2.get("ID");
		System.out.println("step 1 id " + id);
		System.out.println("***********Step 1 completed*************");
		
		//Step 2- In step one we are sending the Request body we have which is present inside BookPayLoad method.
		//but , what if want to post request with different aisle
		//for that we need to changes some parameters.Here we are sending paramter in .body to retirve particular info
		// of book with aisle and isbn
		//Now next time if we want to retrieve id of another book then just pass aisle and isbn value here inside body(Payload.BookPayload1("adsfs","6464"))
				String AddBookResponse2= given().log().all().header("Content-Type","application/json")
				.body(Payload.BookPayload1("adsfs","6464")).when().post("/Library/Addbook.php").then()
				.assertThat().statusCode(200).extract().response().asString();
				
				JSONObject js3 = ReUsableMethods.rawToJson(AddBookResponse2);
				JsonPath js4 = new JsonPath(js3.toString()); 
				String id1=js4.get("ID");
				System.out.println("step 2 id " +id1);
				System.out.println("***********Step 2 completed*************");
	}
	
	
		
	
}
