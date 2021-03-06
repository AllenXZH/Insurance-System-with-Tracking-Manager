package com.springmvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column(length=20)
	private String customerName;

	@Column(length=20)
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=50)
	private String email;

	@Column(length=1)
	private String gender;

	@Column
	private double loan;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Cust_Insurance", joinColumns = { @JoinColumn(name = "CustId") }, inverseJoinColumns = {
			@JoinColumn(name = "InsurId") })
	private Set<Insurance> insurancesOrdered = new HashSet<>();

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "CustId")
	private Set<Query> queriesCreated = new HashSet<>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getLoan() {
		return loan;
	}

	public void setLoan(double loan) {
		this.loan = loan;
	}

	public Set<Insurance> getInsurancesOrdered() {
		return insurancesOrdered;
	}

	public void setInsurancesOrdered(Set<Insurance> insurancesOrdered) {
		this.insurancesOrdered = insurancesOrdered;
	}

	public Set<Query> getQueriesCreated() {
		return queriesCreated;
	}

	public void setQueriesCreated(Set<Query> queriesCreated) {
		this.queriesCreated = queriesCreated;
	}
	
	public Customer(int customerId, String customerName, String email) {
		super();
		this.customerName = customerName;
		this.gender = gender;
	}
	public Customer(int customerId, String customerName, String password, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", gender=" + gender + "]";
	}

}
