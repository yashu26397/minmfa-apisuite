package com.minmfa.apisuite.dto;

import java.io.Serializable;
import java.time.Instant;

public class MfaUserDTO implements Serializable {

	private static final long serialVersionUID = -4359131428710075759L;

	private Long id;

	private String firstName;

	private String lastName;

	private String middleName;

	private String email;

	private String mobileNumber;

	private Boolean isInvited;

	private Instant invitedOn;

	private Boolean active;

	private String username;

	private String source;

	private Boolean autoInvite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Boolean getIsInvited() {
		return isInvited;
	}

	public void setIsInvited(Boolean isInvited) {
		this.isInvited = isInvited;
	}

	public Instant getInvitedOn() {
		return invitedOn;
	}

	public void setInvitedOn(Instant invitedOn) {
		this.invitedOn = invitedOn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getAutoInvite() {
		return autoInvite;
	}

	public void setAutoInvite(Boolean autoInvite) {
		this.autoInvite = autoInvite;
	}

	@Override
	public String toString() {
		return "MfaUserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", isInvited=" + isInvited
				+ ", invitedOn=" + invitedOn + ", active=" + active + ", username=" + username + ", source=" + source
				+ ", autoInvite=" + autoInvite + "]";
	}
}
