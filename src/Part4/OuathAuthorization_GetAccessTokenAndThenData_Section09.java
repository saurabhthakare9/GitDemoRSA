package Part4;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import org.testng.Assert;

public class OuathAuthorization_GetAccessTokenAndThenData_Section09 {

	public static void main(String[] args) {
	
//1.Getting access token
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type","client_credentials")
		.formParam("scope","trust").when().log().all()
		.post("/oauthapi/oauth2/resourceOwner/token").asString();
		
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String accesstoken=js.getString("access_token");
		System.out.println("Access Token" + accesstoken);
		
//2.Getting details using the access token
		
		String response2=given().queryParams("access_token",accesstoken).when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		
		System.out.println(response2);
	}
}
