package com.sunbeaminfo.sh.hib;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPADDRESS database table.
 * 
 */
@Entity
@Table(name="EMPADDRESS")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empid;
	private String addr;
	private String country;
	private Emp employee;

	public Address() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPID")
	public int getEmpid() {
		return this.empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}


	@Column(name="ADDR")
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Column(name="COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	//bi-directional one-to-one association to Emp
	@OneToOne(mappedBy="empaddress")
	public Emp getEmployee() {
		return this.employee;
	}

	public void setEmployee(Emp employee) {
		this.employee = employee;
	}

}