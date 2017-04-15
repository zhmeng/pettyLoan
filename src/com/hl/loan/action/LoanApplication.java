package com.hl.loan.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.hl.loan.pojo.APPLYCustInfo;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.pojo.CustomerFance;
import com.hl.loan.pojo.CustomerLoan;
import com.hl.loan.pojo.ImgInfo;
import com.hl.loan.pojo.Product;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.APPLYCustInfoService;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.service.CityService;
import com.hl.loan.service.ComLpService;
import com.hl.loan.service.CompanyService;
import com.hl.loan.service.CustomerCompanyService;
import com.hl.loan.service.CustomerFanceService;
import com.hl.loan.service.CustomerLoanService;
import com.hl.loan.service.ImgInfoService;
import com.hl.loan.service.ProcedureService;
import com.hl.loan.service.ProductService;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.vi.Procedure;

import org.apache.commons.io.FileUtils;

@Namespace("/loanApp")
@ResultPath("/")
public class LoanApplication extends BaseAction{
	protected final Logger log = Logger.getLogger(LoanApplication.class);
	@Autowired
	private APPLYCustInfoService aPPLYCustInfoService;
	@Autowired
	private ApplyInfoService applyInfoService;
	@Autowired
	private CustomerCompanyService customerCompanyService;
	@Autowired 
	private CustomerFanceService customerFanceService;
	@Autowired
	private CustomerLoanService customerLoanService;
	@Autowired
	private ImgInfoService imgInfoService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CityService cityService;
	@Autowired
	private ComLpService comLpService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProcedureService procedureService;
	private String modId;
	private APPLYCustInfo acust;
	private ApplyInfo ainfo;
	private CustomerCompany company;
	private CustomerFance fance;
	private CustomerLoan loan;
	private CustomerLoan loan2;
	private CustomerLoan loan3;
	
	private List<String> imageFileName;
	private List<File> image;
	private ImgInfo imgInfo;
	
	private Company cp;
	private City city;
	private ComLp comLp;
	private Product product;
	private String pd;
	
	
	public String getModId() {
		return modId;
	}
	public void setModId(String modId) {
		this.modId = modId;
	}
	public String getPd() {
		return pd;
	}
	public void setPd(String pd) {
		this.pd = pd;
	}
	private Long applyID;
	
	
	public Long getApplyID() {
		return applyID;
	}
	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}
	public Company getCp() {
		return cp;
	}
	public void setCp(Company cp) {
		this.cp = cp;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public ComLp getComLp() {
		return comLp;
	}
	public void setComLp(ComLp comLp) {
		this.comLp = comLp;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ImgInfo getImgInfo() {
		return imgInfo;
	}
	public void setImgInfo(ImgInfo imgInfo) {
		this.imgInfo = imgInfo;
	}
	public List<File> getImage() {
		return image;
	}
	public void setImage(List<File> image) {
		this.image = image;
	}
	public List<String> getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}
	public APPLYCustInfo getAcust() {
		return acust;
	}
	public void setAcust(APPLYCustInfo acust) {
		this.acust = acust;
	}
	public CustomerLoan getLoan3() {
		return loan3;
	}
	public void setLoan3(CustomerLoan loan3) {
		this.loan3 = loan3;
	}
	public ApplyInfo getAinfo() {
		return ainfo;
	}
	public void setAinfo(ApplyInfo ainfo) {
		this.ainfo = ainfo;
	}
	
	public CustomerCompany getCompany() {
		return company;
	}
	public void setCompany(CustomerCompany company) {
		this.company = company;
	}
	public CustomerFance getFance() {
		return fance;
	}
	public void setFance(CustomerFance fance) {
		this.fance = fance;
	}
	public CustomerLoan getLoan() {
		return loan;
	}
	public void setLoan(CustomerLoan loan) {
		this.loan = loan;
	}
	public CustomerLoan getLoan2() {
		return loan2;
	}
	public void setLoan2(CustomerLoan loan2) {
		this.loan2 = loan2;
	}
	//去增加
	@Action(value="toAddLoanApp", results={
			@Result(name="success",location="/apply/loanApp2.jsp")
	})
	public String toAddLoanApp(){
		this.getUrlRight(2);
		Long ainfoID = getApplyID();
		
		APPLYCustInfo acust=null;
		
		ApplyInfo applyInfo=null;
		CustomerFance fance=null;
		CustomerCompany company=null;
		
		Company cp=null;
		City city=null;
		ComLp comLp=null;
		Product product=null;
		if(ainfoID!=null){
			acust=aPPLYCustInfoService.getCustInfoByAplyID(Long.valueOf(ainfoID));
			
			fance=customerFanceService.getCustomerFanceByAplyID(Long.valueOf(acust.getId()));
			company=customerCompanyService.getCustomerCompanyByAplyID(Long.valueOf(acust.getId()));
			applyInfo=applyInfoService.getApplyInfoByID(ainfoID+"");
			
			cp = applyInfoService.getCompanyByApplyID(Long.valueOf(applyInfo.getCompanyID()));
			city = applyInfoService.getCityByCityID(Long.valueOf(applyInfo.getCityID()));
			comLp = applyInfoService.getComLpByApplyID(Long.valueOf(applyInfo.getLpID()));
			product = applyInfoService.getProductByProductID(Long.valueOf(applyInfo.getProductID()));
		}
		this.cp=cp;
		this.city=city;
		this.comLp=comLp;
		this.product=product;
		
		
		this.acust=acust;
		this.fance=fance;
		this.company=company;
		this.ainfo = applyInfo;
		List<Company> companyList = companyService.getAllCompany();//所有开发商信息
		List<City> cityList = cityService.getAllCity();//所有城市信息
		List<ComLp> cLpList = comLpService.getAllLp();//所有楼盘信息
		List<Product> productList = productService.getAllProduct();
		this.getRequest().setAttribute("companyList", companyList);
		this.getRequest().setAttribute("cityList", cityList);
		this.getRequest().setAttribute("cLpList", cLpList);
		this.getRequest().setAttribute("productList", productList);
		return SUCCESS;
	}
	
	
	//查看贷款信息
		@Action(value="toShowLoanApp", results={
				@Result(name="success",location="/apply/showLoanApp.jsp"),
				@Result(name="updates",location="/apply/loanApp2.jsp"),
				@Result(name="logins",location="/login.jsp")
		})
		public String toShowLoanApp(){
			String pd=getPd();
		//	String mid=getRequest().getParameter("modId");
			if(pd=="2" || pd.equals("2")){					//修改
				this.getUrlRight(8);
			}
			Long ainfoID = getApplyID();
			APPLYCustInfo state=null;
			
			ApplyInfo applyInfo=null;
			
			CustomerFance fance=null;
			CustomerCompany company=null;
			
			Company cp=null;
			City city=null;
			ComLp comLp=null;
			Product product=null;
			applyInfo=applyInfoService.getApplyInfoByID(ainfoID+"");
			Integer intstate=applyInfo.getStatus();
			int state1=0;
			if(intstate!=null){
				state1=intstate;
			}
			if(ainfoID!=null){
				acust=aPPLYCustInfoService.getCustInfoByAplyID(Long.valueOf(ainfoID));
				if(acust!=null){
					fance=customerFanceService.getCustomerFanceByAplyID(Long.valueOf(acust.getId()));
					if(fance!=null){
						company=customerCompanyService.getCustomerCompanyByAplyID(Long.valueOf(acust.getId()));
						if(company!=null){
							//System.out.println(applyInfo.getCompanyID());
							if(applyInfo.getCompanyID()!=null){
								cp = applyInfoService.getCompanyByApplyID(Long.valueOf(applyInfo.getCompanyID()));
							}
							if(applyInfo.getCityID()!=null){
								city = applyInfoService.getCityByCityID(Long.valueOf(applyInfo.getCityID()));
							}
							if(applyInfo.getLpID()!=null){
								comLp = applyInfoService.getComLpByApplyID(Long.valueOf(applyInfo.getLpID()));
							}
							if(applyInfo.getProductID()!=null){
								product = applyInfoService.getProductByProductID(Long.valueOf(applyInfo.getProductID()));
							}
							
						}
						List<CustomerLoan> loanLiat=customerLoanService.getListLoan(acust.getId());
						if(loanLiat!=null){
							if(loanLiat.size()==1){
								CustomerLoan loan=loanLiat.get(0);
								this.loan=loan;
							}
							if(loanLiat.size()==2){
								CustomerLoan loan=loanLiat.get(0);
								CustomerLoan loan2=loanLiat.get(1);
								this.loan=loan;
								this.loan2=loan2;
							}
							if(loanLiat.size()==3){
								CustomerLoan loan=loanLiat.get(0);
								CustomerLoan loan2=loanLiat.get(1);
								CustomerLoan loan3=loanLiat.get(2);
								this.loan=loan;
								this.loan2=loan2;
								this.loan3=loan3;
							}
						}
					}
				}
				
			}
			List<ImgInfo> imglist=imgInfoService.getImgInfos(Long.valueOf(ainfoID), 0);
			
			this.getRequest().setAttribute("imglist", imglist);
			this.cp=cp;
			this.city=city;
			this.comLp=comLp;
			this.product=product;
			
			this.acust=acust;
			this.fance=fance;
			this.company=company;
			this.ainfo = applyInfo;
			List<Company> companyList = companyService.getAllCompany();//所有开发商信息
			List<City> cityList = cityService.getAllCity();//所有城市信息
			List<ComLp> cLpList = comLpService.getAllLp();//所有楼盘信息
			List<Product> productList = productService.getAllProduct();
			this.getRequest().setAttribute("companyList", companyList);
			this.getRequest().setAttribute("cityList", cityList);
			this.getRequest().setAttribute("cLpList", cLpList);
			this.getRequest().setAttribute("productList", productList);
			/*List<Company> companyList = companyService.getAllCompany();//所有开发商信息
			List<City> cityList = cityService.getAllCity();//所有城市信息
			List<Product> productList = productService.getAllProduct();
			this.getRequest().setAttribute("companyList", companyList);
			this.getRequest().setAttribute("cityList", cityList);
			this.getRequest().setAttribute("productList", productList);*/
			if(pd=="2" || pd.equals("2")){
				if(state1!=1){
					return "logins";
				}
				return "updates";
			}
			return SUCCESS;
		}
	
	
	//增加贷款
	@Action(value="addLoanApp", results={
			@Result(name="success",location="/apply/loanApp2.jsp"),
			@Result(name="updates",location="/apply/loanApp2.jsp"),
			@Result(name="logins",location="/login.jsp")
	})
	public String addLoanApp(){
		String modId=getRequest().getParameter("modId");
		String companyId = this.getRequest().getParameter("companyInfo");
		String cityInfoId = this.getRequest().getParameter("cityInfo");
		String comlpInfoId = this.getRequest().getParameter("comlpInfo");
		String productInfoId = this.getRequest().getParameter("productInfo");
		
		//getCompanyByID
		List<Company> comList=companyService.getCompanyByID(companyId);
		Company companys=comList.get(0);
		
		APPLYCustInfo acust=getAcust();
		ApplyInfo ainfo=getAinfo();
		ainfo.setCompanyID(Long.valueOf(companyId));
		ainfo.setCityID(Long.valueOf(cityInfoId));
		ainfo.setLpID(Long.valueOf(comlpInfoId));
		ainfo.setProductID(Long.valueOf(productInfoId));
		
		ainfo.setDelayCostRate(companys.getDelayCostRate());
		ainfo.setDelayInterestRate(companys.getDelayInterestRate());
		ainfo.setApplyCode("HL"+comlpInfoId+MethoeUtil.stringToDate(new Date(),"yyyyMMddHHmmss"));
		CustomerCompany company=getCompany();
		CustomerFance fance=getFance();
		CustomerLoan loan=getLoan();
		CustomerLoan loan2=getLoan2();
		CustomerLoan loan3=getLoan3();
		SysUser sysUsers=(SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		int userID=sysUsers.getUserID();
		String relName=sysUsers.getUserFullName();
		Date dt=new Date();
		dt=MethoeUtil.dateToDate(dt, "yyyy-MM-dd");						//日期
		//fance.setCreateUID(userID);
		fance.setCreateUName(relName);
		acust.setCreateUID(userID);
		acust.setCreateUName(relName);
		ainfo.setCreateUID(userID);
		ainfo.setCreateUName(relName);
		//ainfo.setCompanyID(Integer.valueOf(companyId));
	//	ainfo.setCityID(Integer.valueOf(cityInfoId));
	//	ainfo.setLpID(Integer.valueOf(comlpInfoId));
	//	ainfo.setProductID(Integer.valueOf(productInfoId));
		company.setCreateUID(userID);
		company.setCreateUName(relName);		
		ainfo.setStatus(1);
		Long applyID=applyInfoService.saveApplyInfo(ainfo);
		ainfo.setApplyID(applyID);		
		acust.setApplyID(applyID);
		Long appID=aPPLYCustInfoService.saveAppplyCust(acust);
		acust.setId(appID);
		
		company.setCustID(aPPLYCustInfoService.getCustInfoByAplyID(appID).getId());
		company.setCusName(acust.getCustName());
		Long cid=customerCompanyService.saveCompany(company);
		company.setId(cid);
		
		fance.setCustID(aPPLYCustInfoService.getCustInfoByAplyID(appID).getId());
		Long fid=customerFanceService.saveFance(fance);
		fance.setId(fid);
		
		if(loan!=null){
			loan.setCustID(appID);
			//loan.setCreateUName(relName);
			Long lid=customerLoanService.saveLoan(loan);
			loan.setId(lid);
		}
		if(loan2!=null){
			loan2.setCustID(appID);
			Long lid2=customerLoanService.saveLoan(loan2);
			loan2.setId(lid2);
		}
		if(loan3!=null){
			loan3.setCustID(appID);
			Long lid3=customerLoanService.saveLoan(loan3);
			loan3.setId(lid3);
		}
		String pd="2";
		this.applyID=applyID;
		this.pd=pd;
		this.modId=modId;
		return toShowLoanApp();
	}
	@Action(value="updateLoanApp", results={
			@Result(name="success",location="/apply/loanApp2.jsp")
	})
	public String updateLoanApp(){
		int pd=0;
		String companyId = this.getRequest().getParameter("companyInfo");
		String cityInfoId = this.getRequest().getParameter("cityInfo");
		String comlpInfoId = this.getRequest().getParameter("comlpInfo");
		String productInfoId = this.getRequest().getParameter("productInfo");
		
		
		String psth=this.getRequest().getParameter("path");
		
		ApplyInfo ainfo=getAinfo();
		//ApplyInfo aInfo = applyInfoService.load(getAinfo().getApplyID()+"");
		ainfo.setCompanyID(Long.valueOf(companyId));
		ainfo.setCityID(Long.valueOf(cityInfoId));
		ainfo.setLpID(Long.valueOf(comlpInfoId));
		ainfo.setProductID(Long.valueOf(productInfoId));
		ainfo.setStatus(1);
		CustomerCompany company=getCompany();
		CustomerFance fance=getFance();
		APPLYCustInfo acust=getAcust();
		CustomerLoan loan=getLoan();
		CustomerLoan loan2=getLoan2();
		CustomerLoan loan3=getLoan3();
		ImgInfo aImgInfo =getImgInfo();
		String imgChinaName = aImgInfo.getImgChinaName();
		List<File> files = getImage();
		List<String> imgfiles=getImageFileName();
		Long applyId = ainfo.getApplyID();
		int j=0;
		if (files != null && files.size() > 0){
			for (int i = 0; i < files.size(); i++) {
				String imgName=imgfiles.get(i);  //222.txt
				int index=imgName.lastIndexOf(".");
				String lastimg=imgName.substring(index,imgName.length());  //.txt
				Date dt=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				//String strempId=employee.getId()+"";
				StringBuffer sb=new StringBuffer();
				String strdt=sdf.format(dt);
				String strj=j+"";
				sb.append(strj);
				sb.append(strdt);
				sb.append(lastimg);
				String strImgName=sb.toString(); //015420141031151021.txt
				String realpath = ServletActionContext.getServletContext().getRealPath("/uploads/"+applyId); //服务器保存的文件地址
				File descFile = new File(realpath,strImgName);
				try {
					File fi=files.get(i);
					FileUtils.copyFile(fi, descFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				StringBuffer sbs=new StringBuffer();
				sbs.append(strj);
				sbs.append(strdt);
				String url="../uploads/"+applyId+"/"+strImgName;
				ImgInfo img=new ImgInfo();
				img.setImgName(strImgName);
				img.setImgUrl(url);
				img.setState(0); //图片默认状态为0：正常 
				img.setTime(dt);
				img.setApplyID(applyId);
				img.setImgChinaName(imgChinaName);
				img.setType(0);
				imgInfoService.addimg(img);
				j++;
			}
		}else{
			String loanid=this.getRequest().getParameter("loanid");
			String loan2id=this.getRequest().getParameter("loan2id");
			String loan3id=this.getRequest().getParameter("loan3id");
			//System.out.println(ainfo.getStatus()+"-------------");
			applyInfoService.updateApplyInfo(ainfo);
			acust.setApplyID(ainfo.getApplyID());
			aPPLYCustInfoService.updateAppplyCust(acust);
			company.setCustID(acust.getId());
			customerCompanyService.updateCompany(company);
			fance.setCustID(acust.getId());
			customerFanceService.updateFance(fance);
			//System.out.println(loanid.trim().length());
			if(loanid!=null && loanid.trim().length()>0){
				loan.setId(Long.parseLong(loanid));
				if(loan!=null){
					customerLoanService.updateLoan(loan);					//修改
				}else{
					customerLoanService.delLoan(loan);      //删除 
				}
			}else{
				if(loan!=null){
					Long appID=acust.getId();
					loan.setCustID(appID);
					//loan.setCreateUName(relName);
					Long lid=customerLoanService.saveLoan(loan);
					loan.setId(lid);
				}
			}
			if(loan2id!=null  && loan2id.trim().length()>0){
				loan2.setId(Long.parseLong(loan2id));
				if(loan!=null){
					customerLoanService.updateLoan(loan2);					//修改
				}else{
					customerLoanService.delLoan(loan2);      //删除 
				}
			}else{
				if(loan2!=null){
					Long appID=acust.getId();
					loan.setCustID(appID);
					//loan.setCreateUName(relName);
					Long lid=customerLoanService.saveLoan(loan2);
					loan.setId(lid);
				}
			}
			if(loan3id!=null  && loan3id.trim().length()>0){
				loan3.setId(Long.parseLong(loan3id));
				if(loan!=null){
					customerLoanService.updateLoan(loan3);					//修改
				}else{
					customerLoanService.delLoan(loan3);      //删除 
				}
			}else{
				if(loan3!=null){
					Long appID=acust.getId();
					loan.setCustID(appID);
					//loan.setCreateUName(relName);
					Long lid=customerLoanService.saveLoan(loan3);
					loan.setId(lid);
				}
			}
		}
		pd=1;
		List<ImgInfo> imglist=imgInfoService.getImgInfos(applyId, 0);
		this.getRequest().setAttribute("imglist", imglist);
		this.ainfo=ainfo;
		this.acust=acust;
		this.company=company;
		this.fance=fance;
		this.loan=loan;
		this.loan2=loan2;
		this.loan3=loan3;
		this.applyID = applyId;
		return toAddLoanApp();
	}
	//修改状态
	@Action(value="updateStatus", results={
			@Result(name="success",location="/apply/loanApp2.jsp")
	})
	public String updateStatus() throws IOException{
		SysUser sysUsers=(SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		int userId=sysUsers.getUserID();
		ApplyInfo ainfo=getAinfo();
		String strapplyId=this.getRequest().getParameter("applyID");
		Long applyId=(long) 0;
		if(strapplyId!=null && strapplyId.trim().length()>0){
			applyId=Long.parseLong(strapplyId);
		}
		Procedure proc=new Procedure(userId, applyId, 1, 1, 1, "", 201, 1);
		procedureService.processOa(proc);
		this.writeResult(true, "2", this.getResponse());
		return null;
	}
	/*
	 * 根据开发商id查询所有城市
	 */
	@Action(value="getAlllnapByCityID")
	public void getAllCityByComID(){
		String cityID = this.getRequest().getParameter("cityID");
		List comlnap;
		try {
			comlnap = comLpService.getAllLnapByCityID(Long.valueOf(cityID));
		    MethoeUtil.toJsonPrint(this.getResponse(), JSON.toJSONString(comlnap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}