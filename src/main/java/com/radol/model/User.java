package com.radol.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "INT UNSIGNED")
    private Integer userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 99)
    private String userName;

    @Column(name = "user_password", nullable = false, unique = true, length = 99)
    private String userPassword;

    @Column(name = "user_email", nullable = false, unique = true, length = 99)
    private String userEmail;

    @Column(name = "user_first_name", nullable = false, length = 99)
    private String userFirstName;

    @Column(name = "user_last_name", nullable = false, length = 99)
    private String userLastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER; // Default role
    public enum Role {
        USER,
        ADMIN
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACTIVE; // Default status
    
    public enum Status {
        ACTIVE,
        INACTIVE,
        BANNED,
        PENDING
    }

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "refresh_token", length = 300)
    private String refreshToken;

    @Column(name = "failed_login", nullable = false)
    private Integer failedLogin = 0;

    @Column(name = "account_locked_until")
    private java.util.Date accountLockedUntil;

    // Getters and Setters

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
