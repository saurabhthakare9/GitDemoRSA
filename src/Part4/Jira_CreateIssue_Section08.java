package Part4;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import org.testng.Assert;

public class Jira_CreateIssue_Section08 {
//Create issue in the jira
//Add attachment to the issue in jira
//All information is given in written notes
public static void main(String[] args) {
	
	RestAssured.baseURI="https://sd897402.atlassian.net";
	String createIssueResponse= given().header("Content-Type","application/json")
			.header("Authorization","Basic c2Q4OTc0MDJAZ21haWwuY29tOkFUQVRUM3hGZkdGMGw0ZVJncmZqaV92bFpKUE51MnlqX0tibG1JSWdiR180MGY4N1M2ZWYtX2tKdkc0RHB1YTNDT2RrUEx6VTBUTWI5dHpacGIzMGhyNEhSZnRTcENLOHpWQkpwekR5Rjd3OXpsczRleV9PWFdyVTcyaWdja1lfTHRMOTVNVGJzUEpEbFlKbjdjcnhqSlZsX01kLWZVVDNWWkVzc1Y1RzlSNDJ2TWhkSnE4OV80VT0xN0M0Q0I5Mw==")
			.body("{\r\n"
					+ "    \"fields\": {\r\n"
					+ "    \"project\":\r\n"
					+ "    {\r\n"
					+ "        \"key\":\"SCRUM\"\r\n"
					+ "    },\r\n"
					+ "    \"summary\":\"Links are not working-API Automation\",\r\n"
					+ "    \"issuetype\":\r\n"
					+ "    {\r\n"
					+ "        \"name\":\"Bug\"\r\n"
					+ "    }\r\n"
					+ "    }\r\n"
					+ "}")
			.log().all().post("/rest/api/2/issue").then().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath js=new JsonPath(createIssueResponse);
	String issueId=js.getString("id");
	System.out.println(issueId);
	
//Add Attachment
//Here in 44 line we have pass the path parameter as key-issueId where key can be any name randomly
//but as we wanted to attached scrrenshot on unique issue created in abobe steps we are giving value as issue id 
	//and then in post request on line 48 we are just passing this value in currly braces as {key}
	//Here we checked only status code we can do lot of validation from response 
	//like email address and file name we can do extract from response
	//Similarly we can do Get,put,delete request by ppassing that url ,for that check jira api cloud websitese
	given().header("X-Atlassian-Token","no-check").header("Accept","application/json")
	.header("Authorization","Basic c2Q4OTc0MDJAZ21haWwuY29tOkFUQVRUM3hGZkdGMGw0ZVJncmZqaV92bFpKUE51MnlqX0tibG1JSWdiR180MGY4N1M2ZWYtX2tKdkc0RHB1YTNDT2RrUEx6VTBUTWI5dHpacGIzMGhyNEhSZnRTcENLOHpWQkpwekR5Rjd3OXpsczRleV9PWFdyVTcyaWdja1lfTHRMOTVNVGJzUEpEbFlKbjdjcnhqSlZsX01kLWZVVDNWWkVzc1Y1RzlSNDJ2TWhkSnE4OV80VT0xN0M0Q0I5Mw==")
	.pathParam("key", issueId)
	.multiPart("file",new File("C://Users//HP//Downloads//cartoon-boys-engaged-in-a-quarrel-reacting-to-an-unheard-sound-style-amalgamating-greg-rutkowski-.jpeg"))
	.log().all().post("rest/api/2/issue/{key}/attachments").then().log().all().statusCode(200);
			
}
}
