package pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
public class testPojo {
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	
	    @JsonProperty("id") 
	    public int getId() { 
			 return this.id; } 
	    public void setId(int id) { 
			 this.id = id; } 
	    int id;
	    @JsonProperty("name") 
	    public String getName() { 
			 return this.name; } 
	    public void setName(String name) { 
			 this.name = name; } 
	    String name;
	    @JsonProperty("email") 
	    public String getEmail() { 
			 return this.email; } 
	    public void setEmail(String email) { 
			 this.email = email; } 
	    String email;
	    @JsonProperty("password") 
	    public String getPassword() { 
			 return this.password; } 
	    public void setPassword(String password) { 
			 this.password = password; } 
	    String password;
	    @JsonProperty("bloodGroup") 
	    public String getBloodGroup() { 
			 return this.bloodGroup; } 
	    public void setBloodGroup(String bloodGroup) { 
			 this.bloodGroup = bloodGroup; } 
	    String bloodGroup;
	    @JsonProperty("totalDonation") 
	    public int getTotalDonation() { 
			 return this.totalDonation; } 
	    public void setTotalDonation(int totalDonation) { 
			 this.totalDonation = totalDonation; } 
	    int totalDonation;
	    @JsonProperty("lastDonation") 
	    public String getLastDonation() { 
			 return this.lastDonation; } 
	    public void setLastDonation(String lastDonation) { 
			 this.lastDonation = lastDonation; } 
	    String lastDonation;
	    @JsonProperty("gender") 
	    public String getGender() { 
			 return this.gender; } 
	    public void setGender(String gender) { 
			 this.gender = gender; } 
	    String gender;
	    @JsonProperty("canDonate") 
	    public int getCanDonate() { 
			 return this.canDonate; } 
	    public void setCanDonate(int canDonate) { 
			 this.canDonate = canDonate; } 
	    int canDonate;
	    @JsonProperty("area") 
	    public ArrayList<String> getArea() { 
			 return this.area; } 
	    public void setArea(ArrayList<String> area) { 
			 this.area = area; } 
	    ArrayList<String> area;
	}



