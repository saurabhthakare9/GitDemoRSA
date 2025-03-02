package Part3;

import static io.restassured.RestAssured.*;


import org.json.JSONObject;
import org.testng.annotations.*;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class DynamicJson2_DataProvider {

	//Step 1- Post the books using post request
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//The below is multidi,emtional array.For single directional array use new object[]
		//Array - is collection of elements . new object[]={1,2,3,4,5,6}
		//Multidimential array- is collection of array
		return new Object[][] {{"reiafy","88985"},{"ewiok","55897"},{"zweri","88972"}};
	}
	
	//now we are using data provided by dadaprovider above.
	//below code is same as code DynamicJson1 Step 2
	 
		@Test(dataProvider="BooksData")
		public void Addbook(String isbn,String aisle) { //Here we have added argument paramter for method
			//As we are taking 2 parameter aisle,isbn ,if there aremore parameters then we need to pass third parameter 
			//also inside method parameter
			RestAssured.baseURI="http://216.10.245.166";
			String AddBookResponse2= given().log().all().header("Content-Type","application/json")
					.body(Payload.BookPayload1(isbn,aisle)).when()    //here we have added method parameter
					.post("/Library/Addbook.php").then()
					.assertThat().statusCode(200).extract().response().asString();
					
					JSONObject js3 = ReUsableMethods.rawToJson(AddBookResponse2);
					JsonPath js4 = new JsonPath(js3.toString()); 
					String id1=js4.get("ID");
					System.out.println("id is " +id1);
				
		}	
		
		//Step 2- Delete the added books above
		@Test(dataProvider="BooksData")
		public void DeleteBook(String isbn,String aisle) {
			RestAssured.baseURI="http://216.10.245.166";
			given().log().all().header("Content-Type","application/json")
			.body(Payload.BookPayload1(isbn,aisle)).when()    //here we have added method parameter
			.delete("/Library/Addbook.php").then()
			.assertThat().statusCode(200);
		}
	}

