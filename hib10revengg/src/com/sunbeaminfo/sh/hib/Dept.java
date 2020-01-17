package com.sunbeaminfo.sh.hib;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="DEPARTMENT")
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String dname;
	private String loc;
	private List<Emp> employees;

	public Dept() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPTNO")
	public int getDeptno() {
		return this.deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Lob
	@Column(name="DNAME")
	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}


	@Lob
	@Column(name="LOC")
	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}


	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="department")
	public List<Emp> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

	public Emp addEmployee(Emp employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Emp removeEmployee(Emp employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

}