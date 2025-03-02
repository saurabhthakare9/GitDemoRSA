package Part5;

public class Deserialization_POJOclass1_GetCourse {

//We are creating this variable because these are the 6 objects in out json response.
//To do this Go to https://codebeautify.org/online-json-editor and left side paste your response
//Hence on RHS you will get formatted response mentioning 6 objects.Similarly you can do all others response

	//To create get set method ,we can used shortcut Alt+SHift+S
	//1.select all strings,
    //2.Press Alt+SHift+S ,pop up open from that click generate getter and setters,select string for which
	//you want to create getter setter method
	//3.click on generate

//As we can see the json is nested json and not simple in this ex so for the courses as 3 more variables are 
//inside courses hence we treet this as another json and we need to create one more POJO class for this
//courses separately.Hence we created another pojo class NestedJSON_POJOClass2_Courses

//As we are creating mini json for courses,we need to declare class name i.e object of class as datatype 
//and written type for courses in Main json in declaring variable,get and set method as on line 26, 56 and 59
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private NestedJSON_POJOClass2_Courses Courses;
	private String linkedIn;
	
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	//As we have created separate mini json for courses ,so return type for get and set should be class name
	//as on line 62 and 66
	public NestedJSON_POJOClass2_Courses getCourses() {
		return Courses;
	}
	public void setCourses(NestedJSON_POJOClass2_Courses courses) {
		Courses = courses;
	}
	
	
	
	
	
}
