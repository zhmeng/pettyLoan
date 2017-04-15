package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.Company;
import com.hl.loan.util.PageModel;

public interface CompanyService {
	// 查出所有开发商
	public List<Company> getAllCompany();

	// 增加开发商信息
	public void addCompany(Company company);

	public PageModel<Company> showCompany(PageModel<Company> pm, Company company);
	
	// 根据ID删除开发商
	public int delCompany(String companyID);
	
	// 根据ID查出开发商信息
	public List<Company> getCompanyByID(String companyID);
	
	// 根据ID修改开发商信息
	public int updateCompanyByID(String companyID, Company company);
	
	public Company getCompany(String companyID);
	
}
