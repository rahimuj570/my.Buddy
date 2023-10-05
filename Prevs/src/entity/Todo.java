package entity;

import java.io.Serializable;

public class Todo implements Serializable{
	private String title;
	private String desc;
	private String date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Todo(String title, String desc, String date) {
		super();
		this.title = title;
		this.desc = desc;
		this.date = date;
	}
	public Todo() {
		super();
	}
	
}
