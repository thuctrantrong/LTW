package vn.iostar.dao;

import java.util.List;

import vn.iostar.model.CategoryModel;

public interface ICategory {
	List<CategoryModel> findAll();
	CategoryModel findByID(int id);
	void insert (CategoryModel category);
	void update (CategoryModel category);
	void delete (int id); 
	List<CategoryModel> findtype(String keyword);
}
