package Part5;

import java.util.List;

public class MiniJSON_POJOClass5_mobile {
	//As we can see now there no more json inside this and json key value are given string format
	//so here we  can used String , but as we can see there no only single value json 
	//it is an array having 3 different key value pair.
	//FOR this we need to do changes in Parent class i.e.NestedJSON_POJOClass2_Courses as below
	//Earlier -
	//private MiniJSON_POJOClass3_WebAutomation webAutomation;
	//private MiniJSON_POJOClass4_api api;
	//private MiniJSON_POJOClass5_mobile mobile;
	
	//Earlier-Get and set method 
	//public MiniJSON_POJOClass3_WebAutomation getWebAutomation() {
	//return webAutomation;
	//}
	//public void setWebAutomation(MiniJSON_POJOClass3_WebAutomation webAutomation) {
	//this.webAutomation = webAutomation;
	//}

	//Here we need to change datatype to List<> in declaring datatye and in getter setter method
	//After changes-
	//private List<MiniJSON_POJOClass3_WebAutomation> webAutomation;
	//private List<MiniJSON_POJOClass4_api> api;
	//private List<MiniJSON_POJOClass5_mobile> mobile;
	
	//After-Get set method
	//public List<MiniJSON_POJOClass3_WebAutomation> getWebAutomation() {
	//	return webAutomation;
	//}
	//public void setWebAutomation(List<MiniJSON_POJOClass3_WebAutomation> webAutomation) {
	//	this.webAutomation = webAutomation;
	//}
	
	//Similarly applicable to api and mobile
	//if we know only one value is there ,no need mention datatype as string but as usually
	//we dont know how many value are there so use List generally
	private String courseTitle;
	private String price;
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
