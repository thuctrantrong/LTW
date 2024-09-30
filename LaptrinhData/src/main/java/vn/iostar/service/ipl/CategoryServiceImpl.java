package vn.iostar.service.ipl;

import java.util.List;

import vn.iostar.dao.ICategory;
import vn.iostar.dao.ipl.ICategoryDao;
import vn.iostar.model.CategoryModel;
import vn.iostar.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	public ICategory cateDao= new ICategoryDao();

	
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findByID(int id) {
		return cateDao.findByID(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cateModel = new CategoryModel();
		cateModel = cateDao.findByID(category.getCategoryid());
		if (cateModel != null)
		{
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cateModel = new CategoryModel();
		cateModel = cateDao.findByID(id);
		if (cateModel != null)
		{
			cateDao.delete(id);
		}		
	}

	@Override
	public List<CategoryModel> findtype(String keyword) {
		return cateDao.findtype(keyword);
	}

}
