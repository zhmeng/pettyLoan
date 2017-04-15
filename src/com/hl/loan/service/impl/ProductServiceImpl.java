package com.hl.loan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.ProductDao;
import com.hl.loan.pojo.Product;
import com.hl.loan.service.ProductService;
import com.hl.loan.util.PageModel;

@Service("productDao")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public PageModel<Product> showProduct(PageModel<Product> pm, Product product) {
		return productDao.showProduct(pm, product);
	}

	@Override
	public int delProduct(String productID) {
		int result = productDao.delProduct(productID);
		return result;
	}

	@Override
	public int updateProductByID(String productID, Product product) {
		int result = productDao.updateProductByID(productID, product);
		return result;
	}

	@Override
	public Product getProductByID(String productID) {
		return productDao.load(productID);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
}
