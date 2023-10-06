package pojo;

import java.io.Serializable;
import java.util.ArrayList;


public class UserDetailsTemplate implements Serializable{
	private static final long serialVersionUID = -8802198141951416844L;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsTemplate [name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", bloodGroup=");
		builder.append(bloodGroup);
		builder.append(", totalDonation=");
		builder.append(totalDonation);
		builder.append(", lastDonation=");
		builder.append(lastDonation);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", canDonate=");
		builder.append(canDonate);
		builder.append(", area=");
		builder.append(area);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append("]");
		return builder.toString();
	}
	private String name;
    private String email;
    private String password;
    private String bloodGroup;
    private int totalDonation;
    private String lastDonation;
    private String gender;
    private int canDonate;
    private ArrayList<String>area;
    private String mobile;
	
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getTotalDonation() {
		return totalDonation;
	}
	public void setTotalDonation(int totalDonation) {
		this.totalDonation = totalDonation;
	}
	public String getLastDonation() {
		return lastDonation;
	}
	public void setLastDonation(String lastDonation) {
		this.lastDonation = lastDonation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCanDonate() {
		return canDonate;
	}
	public void setCanDonate(int canDonate) {
		this.canDonate = canDonate;
	}
	public ArrayList<String> getArea() {
		return area;
	}
	public void setArea(ArrayList<String> area) {
		this.area = area;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("{ \"name\" :");
//		builder.append("\""+name+"\"");
//		builder.append(", \"email\" :");
//		builder.append("\""+email+"\"");
//		builder.append(", \"password\" :");
//		builder.append("\""+password+"\"");
//		builder.append(", \"bloodGroup\" :");
//		builder.append("\""+bloodGroup+"\"");
//		builder.append(", \"totalDonation\" :");
//		builder.append("\""+totalDonation+"\"");
//		builder.append(", \"lastDonation\" :");
//		builder.append("\""+lastDonation+"\"");
//		builder.append(", \"gender\" :");
//		builder.append("\""+gender+"\"");
//		builder.append(", \"canDonate\" :");
//		builder.append("\""+canDonate+"\"");
//		builder.append(", \"area\" :");
//		builder.append(Arrays.toString(area));
//		builder.append("}");
//		return builder.toString();
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 

    
}
