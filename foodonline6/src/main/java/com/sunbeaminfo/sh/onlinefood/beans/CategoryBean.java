package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.utils.HbUtil;

public class CategoryBean {
	private List<String> categoryList;
	public CategoryBean() {
		this.categoryList = new ArrayList<String>();
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public void fetchCategories() {
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			HbUtil.beginTransaction();
			this.categoryList = dao.getCategories();
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
	}
}
