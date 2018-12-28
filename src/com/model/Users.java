package com.model;

public class Users {

	private Integer id;
	private String no;
	private String password;
	private String realname;
	private String tel;
	private int ksid;
	private String ksnames;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getKsid() {
		return ksid;
	}

	public void setKsid(int ksid) {
		this.ksid = ksid;
	}

	public String getKsnames() {
		return ksnames;
	}

	public void setKsnames(String ksnames) {
		this.ksnames = ksnames;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
