package vn.iostar.dao.ipl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBconnect;
import vn.iostar.dao.ICategory;
import vn.iostar.model.CategoryModel;

public class ICategoryDao extends DBconnect implements ICategory {

	public Connection conn = null ; 
	public PreparedStatement ps = null ; 
	public ResultSet rs = null ; 
	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list ; 
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	@Override
	public CategoryModel findByID(int id) {
		String sql = "Select * from categories where categoryid = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category ; 
			}
			conn.close();
			ps.close();
			rs.close();
			}
		catch (Exception e)
		{
			
		}		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into categories(categoryname,images,status) values (?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			}
		catch (Exception e)
		{
			
		}			
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "update categories Set categoryname = ? , images = ? , status = ? where categoryid = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			}
		catch (Exception e)
		{
			
		}	
	}

	@Override
	public void delete(int id) {
		String sql = "Delete from categories where categoryid = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			}
		catch (Exception e)
		{
			
		}			
	}

	@Override
	public List<CategoryModel> findtype(String keyword) {
		String sql = "Select * from categories where categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list ; 
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

}
