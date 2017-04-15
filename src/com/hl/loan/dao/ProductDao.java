package com.hl.loan.dao;

import java.util.List;
import com.hl.loan.pojo.Product;
import com.hl.loan.util.PageModel;

public interface ProductDao {

	// 增加业务
	public void addProduct(Product product);

	public PageModel<Product> showProduct(PageModel<Product> pm, Product product);
	
	// 根据ID删除业务
	public int delProduct(String productID);
	
	// 根据ID修改业务信息
	public int updateProductByID(String productID, Product product);
	
	public Product load(String productID);
	
	// 得到所有业务信息
	public List<Product> getAllProduct();
}
