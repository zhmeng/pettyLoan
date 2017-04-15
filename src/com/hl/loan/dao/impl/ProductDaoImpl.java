package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.ProductDao;
import com.hl.loan.pojo.Product;
import com.hl.loan.util.PageModel;
import org.hibernate.Query;

@SuppressWarnings("unchecked")
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public PageModel<Product> showProduct(PageModel<Product> pm, Product product) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from Product where 1=1 and productFlag!=4");
		List ulist = new ArrayList();
		if (product != null) {
			if (product.getProductKey() != null && !product.getProductKey().equals("")) {
				ulist.add(product.getProductKey());
				hql.append(" and productKey=?");
			}

			if (product.getProductName() != null && !product.getProductName().equals("")) {
				hql.append(" and productName like :productName");
			}
		}
		Query query = this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys = this.getSession().createQuery(hql.toString());
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}
		}
		if (product != null) {
			if (product.getProductName() != null && !product.getProductName().equals("")) {
				query.setParameter("productName", "%" + product.getProductName().trim() + "%");
				querys.setParameter("productName", "%" + product.getProductName().trim() + "%");
			}
		}
		List<Product> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public void addProduct(Product product) {
		this.getHibernateTemplate().persist(product);
	}

	@Override
	public int delProduct(String productID) {
		Query query = this.getSession().createQuery("update Product set ProductFlag=4 where 1=1 and ProductID=?");
		query.setParameter(0, productID);
		return query.executeUpdate();
	}

	@Override
	public int updateProductByID(String productID, Product product) {
		this.getSession().saveOrUpdate(productID, product);
		return 1;
	}

	@Override
	public Product load(String productID) {
		return (Product) this.getHibernateTemplate().get(Product.class, Long.parseLong(productID));
	}

	@Override
	public List<Product> getAllProduct() {
		/*return this.getHibernateTemplate().find(" from Product");*/
		return this.getHibernateTemplate().find(" from Product where 1=1 and productFlag =1");
	}
}
