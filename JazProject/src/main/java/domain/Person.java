package domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
	
	private String firstName = "";
	private String lastName = "";
	private String zipCode = "";
	private String town = "";
	private String pin = "";
	private Date dateOfBirth = new Date();
	
	@Size(min = 2, max = 20)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Size(min = 2, max = 20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	@Size(min = 4, max = 4)
	@Pattern(regexp = "[0-9]{4}")
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@Past
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
