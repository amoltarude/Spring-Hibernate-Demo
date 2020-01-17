package com.sunbeaminfo.sh.onlinefood.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="qryCategoryItems", query="from Item i where i.category=:p_category"),
	@NamedQuery(name="qryCategories", query="select distinct i.category from Item i")
})
@Entity
@Table(name="ITEMS")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String category;
	@Column
	private String info;
	@Column
	private double price;
	public Item() {
		
	}
	public Item(int id, String name, String category, String info, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", info=" + info + ", price=" + price
				+ "]";
	}
}
