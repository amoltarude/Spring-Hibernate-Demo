package com.sunbeaminfo.sh.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(generator="gen", strategy=GenerationType.IDENTITY)
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String info;
	@Column
	private double price;
	public Item() {
		
	}
	public Item(int id, String name, String info, double price) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", info=" + info + ", price=" + price + "]";
	}
}
