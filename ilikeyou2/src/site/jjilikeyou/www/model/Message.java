package site.jjilikeyou.www.model;

public class Message {
private Integer id;
private String message;
private String email;
private String fullname;
private String ip;
private String ipName;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getIpName() {
	return ipName;
}
public void setIpName(String ipName) {
	this.ipName = ipName;
}
@Override
public String toString() {
	return "Message [id=" + id + ", message=" + message + ", email=" + email
			+ ", fullname=" + fullname + ", ip=" + ip + ", ipName=" + ipName
			+ "]";
}

}
