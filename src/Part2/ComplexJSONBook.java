package Part2;
import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJSONBook {

	public static void main(String[] args) {
		
	
	//Here we can give the response we got from get request.
	//But for now we already have one json response and for
	//that reponse we are performaing different operation
	
	//Array used in this ex is dynamic,means values like cpurse tile,purchase amount,bokk price changes everyday 
//	Assignment 1-Print no of courses return by the API
	JsonPath js=new JsonPath(Payload.CoursePrice());
	int count=js.getInt("courses.size()");
	
	System.out.println("Size is "+ count);

	//Assignment 2-Print purchase amount
	int TotalAmoumt = js.getInt("dashboard.purchaseAmount");
	System.out.println("Total Amoumt "+ TotalAmoumt);
	
	//Assignment 3-Print Title of the first course
	//first course means it is present in 0 index
	
	String FirstCourseTitle= js.get("courses[0].title");
	System.out.println("First Course Title "+ FirstCourseTitle);
	
	//similarly we can find out 2nd and 3rd course title 
	String SecondCourseTitle= js.get("courses[1].title");
	System.out.println("Second Course Title "+ SecondCourseTitle);
	
	String ThirdCourseTitle= js.get("courses[2].title");
	System.out.println("Third Course Title "+ ThirdCourseTitle);
	
	//Assignment 4-Print All course titles and their respective Prices
	//Here, we have used for loop so that all course print from 0 to 2
	for (int i=0;i<count;i++) {
		String AllCoursestitle=js.get("courses["+i+"].title");
		int AllCoursesprice=js.get("courses["+i+"].price");
		System.out.println(AllCoursestitle);
		System.out.println(AllCoursesprice);
		//we can directly print line 42 and 43 as below
		//System.out.println(js.get("courses["+i+"].price").toString());
			
		}
	
	
	//Assignment 5-Print no of copies sold by RPA Course
	//As array is dynamic sequence of course may differ everytime,hence we need mention condition like fins out copies where course is RPA
	
	for (int i=0;i<count;i++) {
		String AllCoursestitle=js.get("courses["+i+"].title");
	if (AllCoursestitle.equalsIgnoreCase("RPA")) {
		
		int RPACopiescount=js.get("courses["+i+"].copies");
		System.out.println("RPA Copies" + RPACopiescount);
		break;
	//Here, break is used because if we found the copies of RPA then we need not execute the loop for remaing course.
	//As our condition is satisfied,it exits loop.	
	}
	
	}
	
	}

}