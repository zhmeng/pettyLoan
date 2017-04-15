package com.hl.loan.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.CityService;
import com.hl.loan.service.ComLpService;
import com.hl.loan.service.CompanyService;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;

@Namespace("/action/comLp")
@ResultPath("/")
public class ComLpAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);

	@Autowired
	private ComLpService comLpService;
	private CityService cityService;
	private CompanyService companyService;
	private ComLp comLp;
	private PageModel<ComLp> pm;

	public ComLp getComLp() {
		return comLp;
	}

	public void setComLp(ComLp comLp) {
		this.comLp = comLp;
	}

	public PageModel<ComLp> getPm() {
		return pm;
	}

	public void setPm(PageModel<ComLp> pm) {
		this.pm = pm;
	}
	
	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	// 按条件查找相应楼盘信息
	@Action(value = "goComLpList", results = { @Result(name = "success", location = "/comLp/comLp_list.jsp") })
	public String goComLpList() {
		List<Buttons> blist=this.getUrlRight(1);//权限控制
		ComLp comLp = getComLp();
		PageModel<ComLp> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = comLpService.showComLp(pm, comLp);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("comLp", comLp);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	// 跳转到添加楼盘页面
	@Action(value = "toAddComLp", results = { @Result(name = "success", location = "/comLp/comLp_add.jsp") })
	public String toAddComLp() {
		this.getUrlRight(2);//权限判断
		List<City> cityList = cityService.getAllCity();    // 查出所有城市
		List<Company> companyList = companyService.getAllCompany();  // 查出所有开发商
		this.getRequest().setAttribute("cityList", cityList);
		this.getRequest().setAttribute("companyList", companyList);
		return "success";
	}

	// 添加楼盘信息
	@Action(value = "addComLp")
	public void addComLp() {
		String lpKey = this.getRequest().getParameter("lpKey");
		String lpName = this.getRequest().getParameter("lpName");
		String lpState = this.getRequest().getParameter("lpState");
		String lpTel = this.getRequest().getParameter("lpTel");
		String lpGM = this.getRequest().getParameter("lpGM");
		String lpAddr = this.getRequest().getParameter("lpAddr");
		String cityID = this.getRequest().getParameter("cityID");
		String companyID = this.getRequest().getParameter("companyID");
		
		try {
			ComLp comLp = new ComLp();
			comLp.setLpKey(lpKey);
			comLp.setLpName(lpName);
			comLp.setLpState(Integer.valueOf(lpState));
			comLp.setLpGM(lpGM);
			comLp.setLpTel(lpTel);
			comLp.setLpAddr(lpAddr);
			comLp.setCityID(Long.parseLong(cityID));
			comLp.setCompanyID(Long.parseLong(companyID));
			comLp.setCreateById(sysUser.getUserID().longValue());
			comLp.setCreateTime(new Date());
			comLpService.addComLp(comLp);
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 根据ID删除楼盘
	@Action(value = "delComLp")
	public void delComLp() {
		this.getUrlRight(4);//权限判断
		String lpID = this.getRequest().getParameter("lpID");
		try {
			int result = comLpService.delComLp(lpID);
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 跳转到修改楼盘页面
	@Action(value = "toUpdateComLp", results = { @Result(name = "success", location = "/comLp/comLp_update.jsp") })
	public String toUpdateComLp() {
		this.getUrlRight(8);
		String lpID = this.getRequest().getParameter("lpID");
		List<ComLp> comLp = comLpService.getComLpByID(lpID);
		List<City> cityList = cityService.getAllCity();    // 查出所有城市
		List<Company> companyList = companyService.getAllCompany();  // 查出所有开发商
		this.getRequest().setAttribute("comLp", comLp);
		this.getRequest().setAttribute("cityList", cityList);
		this.getRequest().setAttribute("companyList", companyList);
		return "success";
	}

	// 修改楼盘信息
	@Action(value = "updateComLp")
	public void updateComLp() {
		String lpID = this.getRequest().getParameter("lpID");
		String lpKey = this.getRequest().getParameter("lpKey");
		String lpName = this.getRequest().getParameter("lpName");
		String lpState = this.getRequest().getParameter("lpState");
		String lpTel = this.getRequest().getParameter("lpTel");
		String lpGM = this.getRequest().getParameter("lpGM");
		String lpAddr = this.getRequest().getParameter("lpAddr");
		String cityID = this.getRequest().getParameter("cityID");
		String companyID = this.getRequest().getParameter("companyID");
		
		try {
			ComLp comLp = comLpService.getComLp(lpID);
			comLp.setLpKey(lpKey);
			comLp.setLpName(lpName);
			comLp.setLpState(Integer.valueOf(lpState));
			comLp.setLpGM(lpGM);
			comLp.setLpTel(lpTel);
			comLp.setLpAddr(lpAddr);
			comLp.setCityID(Long.parseLong(cityID));
			comLp.setCompanyID(Long.parseLong(companyID));
			comLp.setUpdateById(sysUser.getUserID().longValue());
			comLp.setUpdateTime(new Date());
			int result = comLpService.updateComLpByID(lpID, comLp);
			if (result == 1) {
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}