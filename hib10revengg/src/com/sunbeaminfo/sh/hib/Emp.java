package com.sunbeaminfo.sh.hib;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name="Emp.findAll", query="SELECT e FROM Emp e")
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empno;
	private String ename;
	private double sal;
	private List<Meeting> meetings;
	private Address empaddress;
	private Dept department;

	public Emp() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPNO")
	public int getEmpno() {
		return this.empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}


	@Lob
	@Column(name="ENAME")
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	@Column(name="SAL")
	public double getSal() {
		return this.sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}


	//bi-directional many-to-many association to Meeting
	@ManyToMany
	@JoinTable(
		name="EMPMEETING"
		, joinColumns={
			@JoinColumn(name="EMPID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="EMPID")
			}
		)
	public List<Meeting> getMeetings() {
		return this.meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}


	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="EMPNO")
	public Address getEmpaddress() {
		return this.empaddress;
	}

	public void setEmpaddress(Address empaddress) {
		this.empaddress = empaddress;
	}


	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPTNO")
	public Dept getDepartment() {
		return this.department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

}