package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.Company;
import com.hl.loan.util.PageModel;

public interface CompanyDao {

	// 查出所有开发商
	public List<Company> getAllCompany();

	// 增加开发商
	public void addCompany(Company company);

	public PageModel<Company> showCompany(PageModel<Company> pm, Company company);
	
	public int delCompany(String companyID);
	
	// 根据ID查出开发商信息
	public List<Company> getCompanyByID(String companyID);
	
	// 根据ID修改开发商信息
	public int updateCompanyByID(String companyID, Company company);
	
	public Company load(String companyID);
	
}
