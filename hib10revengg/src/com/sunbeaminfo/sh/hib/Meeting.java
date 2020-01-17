package com.sunbeaminfo.sh.hib;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MEETING database table.
 * 
 */
@Entity
@Table(name="MEETING")
@NamedQuery(name="Meeting.findAll", query="SELECT m FROM Meeting m")
public class Meeting implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date meetdate;
	private String subject;
	private List<Emp> employees;

	public Meeting() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MEETDATE")
	public Date getMeetdate() {
		return this.meetdate;
	}

	public void setMeetdate(Date meetdate) {
		this.meetdate = meetdate;
	}


	@Column(name="SUBJECT")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	//bi-directional many-to-many association to Emp
	@ManyToMany(mappedBy="meetings")
	public List<Emp> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

}