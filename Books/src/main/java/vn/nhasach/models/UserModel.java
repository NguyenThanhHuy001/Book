package vn.nhasach.models;

import java.sql.Date;
public class UserModel
{ 
	private int Id;
	private String Username;
	private String Password;
	private String Mail;
	private int Roleid;
	private String Fullname;
	private Date Createdate;
	private String Avatar;
	private String Phone;
	private String Code;
	private int Status;
	public UserModel(int id, String username, String password, String mail, int roleid, String fullname,
			Date createdate, String avatar, String phone, String code, int status) {
		super();
		Id = id;
		Username = username;
		Password = password;
		Mail = mail;
		Roleid = roleid;
		Fullname = fullname;
		Createdate = createdate;
		Avatar = avatar;
		Phone = phone;
		Code = code;
		Status = status;
	}
	public UserModel() {
		super();
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public int getRoleid() {
		return Roleid;
	}
	public void setRoleid(int roleid) {
		Roleid = roleid;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public Date getCreatedate() {
		return Createdate;
	}
	public void setCreatedate(Date createdate) {
		Createdate = createdate;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "UserModel [Id=" + Id + ", Username=" + Username + ", Password=" + Password + ", Mail=" + Mail
				+ ", Roleid=" + Roleid + ", Fullname=" + Fullname + ", Createdate=" + Createdate + ", Avatar=" + Avatar
				+ ", Phone=" + Phone + ", Code=" + Code + ", Status=" + Status + "]";
	}
	
	

}
