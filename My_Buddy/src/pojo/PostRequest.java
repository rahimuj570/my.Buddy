package pojo;

import java.io.Serializable;

public class PostRequest implements Serializable{
	private static final long serialVersionUID = 3966146321131707446L;
	private String mobile;
	private String cause;
	private String date;
	private String blood;
	private String area;
	private String hospital;
	private String name;
	private String authorMail;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorMail() {
		return authorMail;
	}
	public void setAuthorMail(String authorMail) {
		this.authorMail = authorMail;
	}
	
	
}
