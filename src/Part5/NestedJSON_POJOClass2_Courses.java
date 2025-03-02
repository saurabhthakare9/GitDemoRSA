package Part5;

import java.util.List;

public class NestedJSON_POJOClass2_Courses {

	//As we can see the main json is nested json and not simple in this ex so for the courses as 3 more variables are 
	//inside courses hence we treet this as another json and we need to create one more POJO class for this
	//courses separately.Hence we created another pojo class NestedJSON_POJOClass2_Courses
    //In this course we have 3 different variable as webAutomation,api and mobile
	//We treat it as another mini json and do the same as we do for POJO class

	//Now if we look at json we have array created for this 3 items that means we have again
	//separate mini json all these 3 items.Hence we need to create separate POJO class for
	//all these and for that 3 POJO classes,parent class is this class i.e NestedJSON_POJOClass2_Courses
	//Hence we have created 3 mini class for webAutomation,api and mobile
	//and return type and declaration variable we need to set as class name as object of class
	//instead of string
	
	//Mini Pojo classes created
	//1.webAutomation- MiniJSON_POJOClass3_WebAutomation
	//2.api- MiniJSON_POJOClass4_api
	//3.mobile- MiniJSON_POJOClass5_mobile
	private List<MiniJSON_POJOClass3_WebAutomation> webAutomation;
	private List<MiniJSON_POJOClass4_api> api;
	private List<MiniJSON_POJOClass5_mobile> mobile;
	
	public List<MiniJSON_POJOClass3_WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<MiniJSON_POJOClass3_WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<MiniJSON_POJOClass4_api> getApi() {
		return api;
	}
	public void setApi(List<MiniJSON_POJOClass4_api> api) {
		this.api = api;
	}
	public List<MiniJSON_POJOClass5_mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<MiniJSON_POJOClass5_mobile> mobile) {
		this.mobile = mobile;
	}
	
	
	
}
