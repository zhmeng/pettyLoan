package com.hl.loan.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.CompanyService;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;

@Namespace("/action/company")
@ResultPath("/")
public class CompanyAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);

	@Autowired
	private CompanyService companyService;
	private Company company;
	private PageModel<Company> pm;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public PageModel<Company> getPm() {
		return pm;
	}

	public void setPm(PageModel<Company> pm) {
		this.pm = pm;
	}

	/*
	 * 按条件查找相应开发商信息
	 */
	@Action(value = "goCompanyList", results = { @Result(name = "success", location = "/company/company_list.jsp") })
	public String goCompanyList() {
		List<Buttons> blist=this.getUrlRight(1);
		Company company = getCompany();
		if (company != null) {
			String companyKey = company.getCompanyKey().trim();
			String companyName = company.getCompanyName().trim();
			company.setCompanyKey(companyKey);
			company.setCompanyName(companyName);
		}
		PageModel<Company> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = companyService.showCompany(pm, company);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("company", company);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	/*
	 * 跳转到添加开发商页面
	 */
	@Action(value = "toAddCompany", results = { @Result(name = "success", location = "/company/company_add.jsp") })
	public String toAddCompany() {
		this.getUrlRight(2);//权限判断
		return "success";
	}

	/*
	 * 添加开发商信息
	 */
	@Action(value = "addCompany")
	public void addCompany() {
		String companyKey = this.getRequest().getParameter("companyKey");
		String companyName = this.getRequest().getParameter("companyName");
		String companyState = this.getRequest().getParameter("companyState");
		String companyFName = this.getRequest().getParameter("companyFName");
		String companyFTel = this.getRequest().getParameter("companyFTel");
		String companyBankNameA = this.getRequest().getParameter("companyBankNameA");
		String companyAccoutA = this.getRequest().getParameter("companyAccoutA");
		String companyBankNameB = this.getRequest().getParameter("companyBankNameB");
		String companyAccoutB = this.getRequest().getParameter("companyAccoutB");
		String delayCostRate = this.getRequest().getParameter("delayCostRate");
		String delayInterestRate = this.getRequest().getParameter("delayInterestRate");
		
		try {
			Company company = new Company();
			company.setCompanyKey(companyKey);
			company.setCompanyName(companyName);
			company.setCompanyState(Integer.valueOf(companyState));
			company.setCompanyFName(companyFName);
			company.setCompanyFTel(companyFTel);
			company.setCompanyBankNameA(companyBankNameA);
			company.setCompanyAccoutA(companyAccoutA);
			company.setCompanyBankNameB(companyBankNameB);
			company.setCompanyAccoutB(companyAccoutB);
			company.setCreateById(sysUser.getUserID().longValue());
			company.setDelayCostRate(new BigDecimal(delayCostRate));
			company.setDelayInterestRate(new BigDecimal(delayInterestRate));
			company.setCreateTime(new Date());
			companyService.addCompany(company);
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据ID删除开发商
	 */
	@Action(value = "delCompany")
	public void delCompany() {
		this.getUrlRight(4);//权限判断
		String companyID = this.getRequest().getParameter("companyID");
		try {
			int result = companyService.delCompany(companyID);
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 跳转到修改开发商信息页面
	@Action(value = "toUpdateCompany", results = { @Result(name = "success", location = "/company/company_update.jsp") })
	public String toUpdateCompany() {
		this.getUrlRight(8);//权限判断
		String companyID = this.getRequest().getParameter("companyID");
		List<Company> company = companyService.getCompanyByID(companyID);
		this.getRequest().setAttribute("company", company);
		return "success";
	}

	// 修改开发商信息
	@Action(value = "updateCompany")
	public void updateCompany() {
		String companyID = this.getRequest().getParameter("companyID");
		String companyKey = this.getRequest().getParameter("companyKey");
		String companyName = this.getRequest().getParameter("companyName");
		String companyState = this.getRequest().getParameter("companyState");
		String companyFName = this.getRequest().getParameter("companyFName");
		String companyFTel = this.getRequest().getParameter("companyFTel");
		String companyBankNameA = this.getRequest().getParameter("companyBankNameA");
		String companyAccoutA = this.getRequest().getParameter("companyAccoutA");
		String companyBankNameB = this.getRequest().getParameter("companyBankNameB");
		String companyAccoutB = this.getRequest().getParameter("companyAccoutB");
		String delayCostRate = this.getRequest().getParameter("delayCostRate");
		String delayInterestRate = this.getRequest().getParameter("delayInterestRate");
		
		try {
			Company company = companyService.getCompany(companyID);
			company.setCompanyKey(companyKey);
			company.setCompanyName(companyName);
			company.setCompanyState(Integer.valueOf(companyState));
			company.setCompanyFName(companyFName);
			company.setCompanyFTel(companyFTel);
			company.setCompanyBankNameA(companyBankNameA);
			company.setCompanyAccoutA(companyAccoutA);
			company.setCompanyBankNameB(companyBankNameB);
			company.setCompanyAccoutB(companyAccoutB);
			company.setUpdateById(sysUser.getUserID().longValue());
			company.setDelayCostRate(new BigDecimal(delayCostRate));
			company.setDelayInterestRate(new BigDecimal(delayInterestRate));
			company.setUpdateTime(new Date());
			int result = companyService.updateCompanyByID(companyID, company);
			if (result == 1) {
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}