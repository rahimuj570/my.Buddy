package pojo;

public class LoginTemplate {
 public String email;
 public String password;
 
public LoginTemplate(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

@Override
public String toString() {
	return "{\"email\" :" +"\""+ email +"\""+ ","
			+ "\"password\" :" + "\""+password+"\""+"}";
}
 
}
