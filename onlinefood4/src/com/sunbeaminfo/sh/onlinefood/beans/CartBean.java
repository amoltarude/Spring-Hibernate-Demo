package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private String[] itemIds;
	private List<Integer> cart;
	public CartBean() {
		this.itemIds = new String[0];
		this.cart = new ArrayList<Integer>();
	}
	public String[] getItemIds() {
		return itemIds;
	}
	public void setItemIds(String[] itemIds) {
		this.itemIds = itemIds;
	}
	public List<Integer> getCart() {
		return cart;
	}
	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}
	public void addToCart() {
		for(String itemId:this.itemIds) {
			int id = Integer.parseInt(itemId);
			cart.add(id);
		}
	}
}

