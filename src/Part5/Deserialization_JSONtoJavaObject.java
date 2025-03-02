package Part5;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

public class Deserialization_JSONtoJavaObject {

	public static void main(String[] args) {
	
//For example 3 in this we need to compare expected and actual title hence for expected title we are creating array for course title
		String[] ExpectedcourseTitles= {"Selenium Webdriver Java", "Cypress","Protractor"};
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
		
//2.Deserialization 
//This is same as Oath in part 4
//but here we are taking output just by using get method as we are deserializing to json object
//hence we have mention obj type as our main parent class
//and also .as(Serialization_POJOclass1_GetCourse.class); on line 35		
		 Deserialization_POJOclass1_GetCourse obj =given().queryParams("access_token",accesstoken).expect().defaultParser(Parser.JSON).when()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(Deserialization_POJOclass1_GetCourse.class);

		//we can values now by simply calling obj.getmethod
		System.out.println(obj.getLinkedIn());
		System.out.println(obj.getInstructor());
		
		//Here, we are grabbing course title present in API om index 1
		//Similarly you can retrieve any value from json
		String APICourseTitle=obj.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(APICourseTitle);
		
		//but here we know the course title SoapUI Webservices testing is present on 1 index in api array
		//there is price also for this course title as 40.
		//If we want to retrieve this price for the course and if index for this course title
		//is dynamically changing then we can not do hardocre as getApi().get(1).getCourseTitle();
		//Hence to achieve this we can do it as below
		//We need to declare list and data type as class name for which we are taking the values
	//Example-Print the course price for SoapUI Webservices testing if index of course is not known 	
	List<MiniJSON_POJOClass4_api> apiCourses= obj.getCourses().getApi();
	for (int i=0;i< apiCourses.size();i++) {
		if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
			System.out.println(apiCourses.get(i).getPrice());
			}
		
	}
	
	//Example 2-Print all course title for WebAutomation 
	List<MiniJSON_POJOClass3_WebAutomation> WebAutomationCourses= obj.getCourses().getWebAutomation();
	for (int i=0;i<WebAutomationCourses.size();i++) {
	
		System.out.println(WebAutomationCourses.get(i).getCourseTitle());
	}
	
	//Example 3- Find Expected and Actual title are matching
	//for this we have already declared array for expected course tiel at start of program in main method
	//ArrayList - Arraylist is more prefarable than List as if suppose json is dynamic
	//if suppose some more items get added in that json so Arryalist can adjust size 
	//dynamically but for List size is fixed so List can not used.
	//List will used when the content of ajson are fixed in size
	
	ArrayList<String> a=new ArrayList<String>();
	List<MiniJSON_POJOClass3_WebAutomation> WebAutomationCourses2= obj.getCourses().getWebAutomation();
	for (int j=0;j<WebAutomationCourses2.size();j++) {
		a.add(WebAutomationCourses2.get(j).getCourseTitle());

	}
	//We have array for expected course title in in List 
	//As we having actual course title in Arryalist hence we need to convert List to ArrayList
	//For this below steps are done
	
	List <String> expectedList=Arrays.asList(ExpectedcourseTitles);
	Assert.assertTrue(a.equals(expectedList));
	System.out.println("Expected and Actual results are matching");
	}
}
