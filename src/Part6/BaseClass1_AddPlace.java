package Part6;

import java.util.List;

public class BaseClass1_AddPlace {

			
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String langauge;
	private List<String> types;
	private BaseClass2_Location location;
	
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLangauge() {
		return langauge;
	}
	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public BaseClass2_Location getLocation() {
		return location;
	}
	public void setLocation(BaseClass2_Location location) {
		this.location = location;
	}

}