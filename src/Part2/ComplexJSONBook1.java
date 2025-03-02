package Part2;
import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;
public class ComplexJSONBook1 {
	//Assignment 6-Verify if Sum of all Course prices matches with Purchase Amount
//Used TestNG here, hence we dont need main method here
	@Test
public void sumOfCouses() {
		int sum=0;
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int count=js.getInt("courses.size()");
		for (int i=0;i<count;i++) {
		
			int Coursesprice=js.get("courses["+i+"].price");
			int Coursecopies=js.get("courses["+i+"].copies");
			int Courseamount= Coursesprice * Coursecopies;
			System.out.println(Courseamount);
			sum =sum + Courseamount;	
		}
		System.out.println("Total sum " + sum);
		
		int Purchaseamount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum,Purchaseamount);
}
}
