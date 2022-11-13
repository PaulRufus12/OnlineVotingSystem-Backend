package org.society.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Election_Officer")
public class ElectionOfficer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "officer_id")
	private int officerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(name = "gender")
	private String gender;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@Column(name = "district")
	private String district;
	@Column(name = "pincode")
	private int pincode;

	public ElectionOfficer() {}

	public ElectionOfficer(int officerId, String firstName, String lastName, String password, String gender,
			String mobileno, String emailId, String address1, String address2, String district, int pincode) {

		this.officerId = officerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.district = district;
		this.pincode = pincode;
	}

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "ElectionOfficer [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", gender=" + gender + ", mobileno=" + mobileno + ", emailId=" + emailId
				+ ", address1=" + address1 + ", address2=" + address2 + ", district=" + district + ", pincode="
				+ pincode + "]";
	}




}
