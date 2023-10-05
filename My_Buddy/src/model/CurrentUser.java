package model;

public class CurrentUser {
	private String name;
    private String email;
    private String password;
    private String bloodGroup;
    private int totalDonation;
    private String lastDonation;
    private String gender;
    private int canDonate;
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
	void me(CurrentUser me) {
		this.name = me.name;
		this.email = me.email;
		this.password = me.password;
		this.bloodGroup = me.bloodGroup;
		this.totalDonation = me.totalDonation;
		this.lastDonation = me.lastDonation;
		this.gender = me.gender;
		this.canDonate = me.canDonate;
	}

    
}
