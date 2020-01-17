package com.sunbeaminfo.sh.hib;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting implements Serializable {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="SUBJECT")
	private String subject;
	@Column(name="MEETDATE")
	private Date meetDate;
	@ManyToMany(mappedBy="meetingList")
	private List<Emp> empList;
	public Meeting() {
		this(0, "", new Date());
	}
	public Meeting(int id, String subject, Date meetDate) {
		this.id = id;
		this.subject = subject;
		this.meetDate = meetDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return String.format("Meeting [id=%s, subject=%s, meetDate=%s]", id, subject, meetDate);
	}
}
