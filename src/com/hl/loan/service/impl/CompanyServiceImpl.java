package com.hl.loan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.CompanyDao;
import com.hl.loan.pojo.Company;
import com.hl.loan.service.CompanyService;
import com.hl.loan.util.PageModel;

@Service("companyDao")
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> getAllCompany() {
		return companyDao.getAllCompany();
	}

	@Override
	public void addCompany(Company company) {
		companyDao.addCompany(company);
	}

	@Override
	public PageModel<Company> showCompany(PageModel<Company> pm, Company company) {
		return companyDao.showCompany(pm, company);
	}

	@Override
	public int delCompany(String companyID) {
		int result = companyDao.delCompany(companyID);
		return result;
	}

	@Override
	public List<Company> getCompanyByID(String companyID) {
		return companyDao.getCompanyByID(companyID);
	}

	@Override
	public int updateCompanyByID(String companyID, Company company) {
		int result = companyDao.updateCompanyByID(companyID, company);
		return result;
	}

	@Override
	public Company getCompany(String companyID) {
		return companyDao.load(companyID);
	}
}
