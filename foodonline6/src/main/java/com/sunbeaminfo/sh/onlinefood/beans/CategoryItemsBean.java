package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.entities.Item;
import com.sunbeaminfo.sh.onlinefood.utils.HbUtil;

public class CategoryItemsBean {
	private String category;
	private List<Item> itemList;
	public CategoryItemsBean() {
		this.category = "";
		this.itemList = new ArrayList<>();
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public void fetchCategoryItems() {
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			HbUtil.beginTransaction();
			this.itemList = dao.getItems(this.category);
			HbUtil.commitTransaction();
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
	}
}
