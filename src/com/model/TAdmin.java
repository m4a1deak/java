package com.model;

/**
 * TAdmin generated by MyEclipse Persistence Tools
 */

public class TAdmin implements java.io.Serializable {

	// Fields

	private Integer id;

	private String username;//用户名

	private String password;

	// Constructors

	/** default constructor */
	public TAdmin() {
	}

	/** full constructor */
	public TAdmin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}