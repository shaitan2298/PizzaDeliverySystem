package com.cg.pizza.beans;

public class Customer implements Comparable<Customer>
{
    private int custId;
    private String firstName;
    private String lastName;
    private String mobNumber;
    private String emailId;
    private Address address;
    public Order order=new Order();
    
    public Customer()
    {
    
    }

	
    public Customer(String firstName, String lastName, String mobNumber, String emailId, Address address) 
    {
    	super(); 
    	this.firstName = firstName;
    	this.lastName = lastName; 
    	this.mobNumber = mobNumber; 
    	this.emailId = emailId;
    	this.address = address;
    }


	
	public Customer(int custId, String firstName, String lastName, String mobNumber, String emailId, Address address,
			Order order) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.emailId = emailId;
		this.address = address;
		this.order = order;
	}
	
	

	public Customer(int custId, String firstName, String lastName, String mobNumber, String emailId, Address address) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.emailId = emailId;
		this.address = address;
	}


	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + custId;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobNumber == null) ? 0 : mobNumber.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (custId != other.custId)
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobNumber == null) {
			if (other.mobNumber != null)
				return false;
		} else if (!mobNumber.equals(other.mobNumber))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNumber="
				+ mobNumber + ", emailId=" + emailId + ", address=" + address + ", order=" + order + "]";
	}


	@Override
	public int compareTo(Customer o) {
		return custId - o.custId;
	}
     
    
}
