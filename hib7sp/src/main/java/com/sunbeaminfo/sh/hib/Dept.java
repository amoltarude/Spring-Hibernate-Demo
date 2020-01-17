package com.sunbeaminfo.sh.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

//@NamedStoredProcedureQuery

@NamedNativeQueries({
	@NamedNativeQuery(name="spUpdateLoc",
				query="CALL SP_DEPTUPDATELOC(:p_deptno, :p_loc)"),
	@NamedNativeQuery(name="spGetAllDepts",
				query="CALL SP_GETALLDEPT()",
				hints={@QueryHint(name="org.hibernate.callable", value="true")},
				resultClass=Dept.class)
})
@Entity
@Table(name="DEPARTMENT")
public class Dept implements Serializable {
	@Id
	@Column
	private int deptno;
	@Column
	private String dname;
	@Column
	private String loc;
	public Dept() {
		this(0, "", "");
	}
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
}
