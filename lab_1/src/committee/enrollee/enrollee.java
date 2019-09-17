package committee.enrollee;

import committee.enrollee.address.address;

public class enrollee {
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	private address address;
	
	public enrollee()
	{
		
	}
	
	public enrollee(String firstName, String middleName, String lastName, address address)
	{
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		
		setAddress(address);
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	
	
	
	
}
