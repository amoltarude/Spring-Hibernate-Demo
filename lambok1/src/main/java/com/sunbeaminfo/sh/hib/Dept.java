package com.sunbeaminfo.sh.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="DEPARTMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
	@GeneratedValue()
	@Id
	@Column
	private int deptno;
	@Column
	private String dname;
	@Column
	private String loc;
}
