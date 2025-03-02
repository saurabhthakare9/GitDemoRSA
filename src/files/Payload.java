package files;

public class Payload {

	//Part 1
	public static String AddRequestPayload(){
		return "{\r\n"
				+ "  \"name\": \"John Doe\",\r\n"
				+ "  \"job\": \"Software Engineer\"\r\n"
				+ "}\r\n"
				+ "";
		
	}
	
	//Part 2
	//This is payload for COmplexJson Example
	//Below response is course,price,book and this response saved in complexjsonBookPrice doc in Rahulsheety Academy folder C:\Users\HP\API projects\RahulAcademyAPI
	public static String CoursePrice() {
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 1162,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Appium\",\r\n"
				+ "\"price\": 36,\r\n"
				+ "\"copies\": 7\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}
		//Part 3 -Step 1
		//Here instead of directly returning we are saving our code to string then returning it
		public static String BookPayload(){
			String AddBookPayload = "{\r\n"
					+ "\r\n"
					+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
					+ "\"isbn\":\"bcd\",\r\n"
					+ "\"aisle\":\"227\",\r\n"
					+ "\"author\":\"John foe\"\r\n"
					+ "}\r\n"
					+ "";
			
			return AddBookPayload;	
		}
		//Part 3-step 2
		public static String BookPayload1(String aisle,String isbn){
			String AddBookPayload1 = "{\r\n"
					+ "\r\n"
					+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
					+ "\"isbn\":\""+isbn+"\",\r\n"
					+ "\"aisle\":\""+aisle+"\",\r\n"
					+ "\"author\":\"John foe\"\r\n"
					+ "}\r\n"
					+ "";
			
			return AddBookPayload1;	
		}
}