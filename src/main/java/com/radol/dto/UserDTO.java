package com.radol.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.radol.model.User.Role;
import com.radol.model.User.Status;

public class UserDTO {

    private Integer userId;
    private String userName;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private Role role;
    private Status status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp lastLogin;
    private String refreshToken;
    private Integer failedLogin;
    private java.util.Date accountLockedUntil;
    
    
	public UserDTO(Integer userId, String userName, String userEmail, String userFirstName, String userLastName,
			Role role, Status status, Timestamp createdAt, Timestamp updatedAt, Timestamp lastLogin,
			String refreshToken, Integer failedLogin, Date accountLockedUntil) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.role = role;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastLogin = lastLogin;
		this.refreshToken = refreshToken;
		this.failedLogin = failedLogin;
		this.accountLockedUntil = accountLockedUntil;
	}


	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Timestamp getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


	public Integer getFailedLogin() {
		return failedLogin;
	}


	public void setFailedLogin(Integer failedLogin) {
		this.failedLogin = failedLogin;
	}


	public java.util.Date getAccountLockedUntil() {
		return accountLockedUntil;
	}


	public void setAccountLockedUntil(java.util.Date accountLockedUntil) {
		this.accountLockedUntil = accountLockedUntil;
	}
	
	
    
    
    
    
    
    
    
}
