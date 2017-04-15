package com.hl.loan.action;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import com.hl.loan.pojo.APPLYCustInfo;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.Contract;
import com.hl.loan.pojo.ImgInfo;
import com.hl.loan.pojo.Notes;
import com.hl.loan.pojo.PrintRecord;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.APPLYCustInfoService;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.service.ComLpService;
import com.hl.loan.service.CompanyService;
import com.hl.loan.service.ContractService;
import com.hl.loan.service.ImgInfoService;
import com.hl.loan.service.NotesService;
import com.hl.loan.service.PrintRecordService;
import com.hl.loan.service.ProcedureService;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.util.NumberToCN;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;

@Namespace("/action/contract")
@ResultPath("/")
public class ContractAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
	String path = this.getRequest().getSession().getServletContext().getRealPath(File.separator);
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private ProcedureService procedureService;
	private NotesService notesService;
	private ImgInfoService imgInfoService;
	private Contract contract;
	private ApplyInfo applyInfo;
	private ApplyInfoService applyInfoService;
	private APPLYCustInfoService applyCustInfoService;
	private PrintRecordService printRecordService;
	private CompanyService companyService;
	private ComLpService comLpService;

	public ComLpService getComLpService() {
		return comLpService;
	}
	public void setComLpService(ComLpService comLpService) {
		this.comLpService = comLpService;
	}
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	public PrintRecordService getPrintRecordService() {
		return printRecordService;
	}
	public void setPrintRecordService(PrintRecordService printRecordService) {
		this.printRecordService = printRecordService;
	}
	private File uploadFile;
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	private String uploadFileFileName;
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	
	public APPLYCustInfoService getApplyCustInfoService() {
		return applyCustInfoService;
	}

	public void setApplyCustInfoService(APPLYCustInfoService applyCustInfoService) {
		this.applyCustInfoService = applyCustInfoService;
	}

	public ApplyInfoService getApplyInfoService() {
		return applyInfoService;
	}

	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

	public ApplyInfo getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfo applyInfo) {
		this.applyInfo = applyInfo;
	}

	private PageModel<ApplyInfo> pm;

	public ImgInfoService getImgInfoService() {
		return imgInfoService;
	}

	public void setImgInfoService(ImgInfoService imgInfoService) {
		this.imgInfoService = imgInfoService;
	}

	public NotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public PageModel<ApplyInfo> getPm() {
		return pm;
	}

	public void setPm(PageModel<ApplyInfo> pm) {
		this.pm = pm;
	}
	
	@Action(value = "goContractList", results = { @Result(name = "success", location = "/contract/contract_list.jsp") })
	public String goContractList() throws IOException {
		List<Buttons> blist = this.getUrlRight(1);
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setStatus(3);
		PageModel<ApplyInfo> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = applyInfoService.showApplyInfo(pm, applyInfo);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	@Action(value = "toAddContract", results = { @Result(name = "success", location = "/contract/contract_add.jsp") })
	public String toAddContract() {
		this.getUrlRight(16);//权限判断
		String applyID = this.getRequest().getParameter("applyID");
		ApplyInfo applyInfo = applyInfoService.getApplyInfoByID(applyID);
		this.getSession().setAttribute("applyInfo", applyInfo);
		return "success";
	}

	/*
	 * 添加合同信息
	 */
	@Action(value = "addContract")
	public void addContract() {
		String applyID = this.getRequest().getParameter("applyID");
		// String contractName = this.getRequest().getParameter("contractName");
		String bankName = this.getRequest().getParameter("bankName");
		String bankAccount = this.getRequest().getParameter("bankAccount");
		String bankMan = this.getRequest().getParameter("bankMan");
		// String delayCostRate = this.getRequest().getParameter("delayCostRate");
		// String delayInterestRate = this.getRequest().getParameter("delayInterestRate");
		String remark = this.getRequest().getParameter("remark");
		String startInterestDate = this.getRequest().getParameter("startInterestDate");
		try {
			ApplyInfo applyInfo = applyInfoService.getApplyInfoByID(applyID);
			APPLYCustInfo applyCustInfo = applyCustInfoService.getCustInfoByAplyID(Long.parseLong(applyID));
			
			Contract contract = new Contract();
			contract.setApplyID(Long.parseLong(applyID));
			contract.setContractNo(applyInfo.getApplyCode());
			// contract.setContractName(contractName);
			contract.setCustName(applyCustInfo.getCustName());
			contract.setCustNo(applyCustInfo.getDocNo());
			contract.setAddr(applyCustInfo.getAddress());
			contract.setAmt(applyInfo.getAmount());
			contract.setPayment(0);
			contract.setRate(applyInfo.getRate());
			contract.setInterest(new BigDecimal(applyInfo.getAmount().multiply(applyInfo.getRate()).doubleValue())); 
			contract.setFeeRate(applyInfo.getFeeRate());
			contract.setFees(applyInfo.getFeeRate());
			contract.setDelayCostRate(applyInfo.getDelayCostRate());
			contract.setDelayInterestRate(applyInfo.getDelayInterestRate());
			contract.setLoanStatus(0);
			contract.setReturnStatus(0);
			contract.setCreateBy(sysUser.getUserName());
			contract.setCreateByID(sysUser.getUserID());
			contract.setCreateTime(new Date());
			contract.setLoanTime(applyInfo.getLoanTime());
			contract.setContractDate(new Date());
			contract.setRemark(remark);
			contract.setSignMan(sysUser.getUserName());
			contract.setSignManID(sysUser.getUserID());
			contract.setStatus(2);
			contract.setBankName(bankName);
			contract.setBankAccount(bankAccount);
			contract.setBankMan(bankMan);
			// contract.setDelayCostRate(new BigDecimal(delayCostRate));
			// contract.setDelayInterestRate(new BigDecimal(delayInterestRate));
			if(startInterestDate!=null&&!"".equals(startInterestDate)){
			contract.setStartInterestDate(MethoeUtil.dateToString(startInterestDate, "yyyy-mm-dd"));
			}
			Contract c = contractService.getContractByApplyID(Long.parseLong(applyID));
			if(null == c){
				contractService.addContract(contract);
			}
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//  print contract
	@Action(value = "toPrintContract", results = { @Result(name = "success", location = "/contract/contract_print.jsp") })
	public String toPrintContract() {
		this.getUrlRight(32);//权限判断
		String applyID = this.getRequest().getParameter("applyID");
		List<ImgInfo> imgList = imgInfoService.getImgInfos(Long.parseLong(applyID), 1);
		this.getRequest().setAttribute("imgList", imgList);
		this.getRequest().setAttribute("applyID", applyID);
		return "success";
	}
	
// 	signed contract
	@Action(value = "toSignedContract", results = { @Result(name = "success", location = "/contract/contract_signed.jsp") })
	public String toSignedContract() {
		this.getUrlRight(32);//权限判断
		String applyID = this.getRequest().getParameter("applyID");
		Contract contract = contractService.getContractByApplyID(Long.parseLong(applyID));
		this.getRequest().setAttribute("contract", contract);
		return "success";
	}
	
	@Action(value = "signedContract")
	public void signedContract() {
		this.getUrlRight(32);//权限判断
		try {
			String contractID = this.getRequest().getParameter("contractID");
			String chksignDate = this.getRequest().getParameter("chksignDate");
			Contract contract = contractService.getContractByID(contractID);
			contract.setChksignDate(MethoeUtil.dateToString(chksignDate, "yyyy-mm-dd HH:mm:ss"));
			contract.setStatus(3);
			int result = contractService.updateContractByID(contractID, contract);
			if (result == 1) {
				//生成还款计划表
				if(contractID!=null && !contractID.equals("")){
					int procResult=procedureService.processPayments(Long.parseLong(contractID));
					if(procResult==1 || procResult==3){
						contract.setStatus(2);
						contractService.updateContractByID(contractID, contract);
						writeResult(true, "操作失败！", this.getResponse());
					}else if(procResult==4){
						writeResult(true, "已经签订！", this.getResponse());
					}else{
						writeResult(true, "修改成功！", this.getResponse());
					}
					
				}else{
					writeResult(true, "修改失败！", this.getResponse());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
////////// 	
	@Action(value = "toUploadFile", results = { @Result(name = "success", location = "/contract/contract_retrial_upFile.jsp") })
	public String toUploadFile() {
		this.getUrlRight(128);//权限判断
		String applyID = this.getRequest().getParameter("applyID");
		Contract contract = contractService.getContractByApplyID(Long.parseLong(applyID));
		this.getRequest().setAttribute("contract", contract);
		
		List<ImgInfo> imgList = imgInfoService.getImgInfos(contract.getApplyID(), 1);
		this.getRequest().setAttribute("imgList", imgList);
		return "success";
	}
	
	@Action(value = "uploadRetrialFile")
	public void uploadRetrialFile() throws Exception {
		String applyID = this.getRequest().getParameter("applyID");
		Contract contract = contractService.getContractByApplyID(Long.parseLong(applyID));
		String filePath = FILE_PATH + "/contract/" + contract.getContractNo() + "/" + uploadFileFileName;
		if (uploadFile != null) {
			File destFile = new File(filePath);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(uploadFile, destFile);
			ImgInfo img = new ImgInfo();
			img.setImgName(System.currentTimeMillis() + uploadFileFileName);
			img.setImgUrl(filePath);
			img.setTime(new Date());
			img.setState(0);
			img.setApplyID(contract.getApplyID());
			img.setImgChinaName(uploadFileFileName);
			img.setType(1);
			imgInfoService.addimg(img);
			writeResult(true, "上传成功！", this.getResponse());
		} else {
			writeResult(true, "上传失败！", this.getResponse());
		}
	}
// 	retrial contract
	@Action(value = "toRetrialContract", results = { @Result(name = "success", location = "/contract/contract_retrial.jsp") })
	public String toRetrialContract() {
		this.getUrlRight(128);//权限判断
		String applyID = this.getRequest().getParameter("applyID");
		Contract contract = contractService.getContractByApplyID(Long.parseLong(applyID));
		this.getRequest().setAttribute("contract", contract);
		
		Notes notes = notesService.getNotesByApplyID(contract.getApplyID(), 201);
		this.getRequest().setAttribute("notes", notes);
		
		List<ImgInfo> imgList = imgInfoService.getImgInfos(contract.getApplyID(), 1);
		this.getRequest().setAttribute("imgList", imgList);
		return "success";
	}
	
	@Action(value = "retrialContract")
	public void retrialContract() throws Exception {
		String contractID = this.getRequest().getParameter("contractID");
		try {
			Contract contract = contractService.getContractByID(contractID);
			contract.setStatus(4);
			contract.setCheckDate(new Date());
			contractService.updateContractByID(contractID, contract);
			ApplyInfo applyInfo = applyInfoService.getApplyInfoByID(contract.getApplyID().toString());
			applyInfo.setStatus(401);
			applyInfoService.updateApplyInfo(applyInfo);
			writeResult(true, "复核成功！", this.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "download")
	public void download() throws Exception{
		this.getUrlRight(64);
		String imgID = this.getRequest().getParameter("imgID");
		ImgInfo img = imgInfoService.getImgInfoByID(imgID);
		download(this.getResponse(), img.getImgUrl());
	}
	
//  contract template	
	@Action(value = "goContractTemplateList", results = { @Result(name = "success", location = "/contract/contract_template_list.jsp") })
	public String goContractTemplateList() {
		List<Buttons> blist=this.getUrlRight(1);//权限控制
		ImgInfo img = new ImgInfo();
		PageModel<ImgInfo> pm = new PageModel<>();
		pm = imgInfoService.showImgInfo(pm, img);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}
	
	@Action(value = "toUploadContractTemplate", results = { @Result(name = "success", location = "/contract/contract_template_upFile.jsp") })
	public String toUploadContractTemplate() {
		this.getUrlRight(2);
		return "success";
	}
	
	@Action(value = "uploadContractTemplate")
	public void uploadContractTemplate() throws Exception {
		String fileName = this.getRequest().getParameter("fileName");
		fileName += uploadFileFileName.substring(uploadFileFileName.lastIndexOf("."), uploadFileFileName.length());
		String savePath = path + "template" + File.separator + System.currentTimeMillis() + File.separator + fileName;
		if (uploadFile != null) {
			File destFile = new File(savePath);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(uploadFile, destFile);
			ImgInfo img = new ImgInfo();
			img.setImgName(System.currentTimeMillis() + fileName);
			img.setImgUrl(savePath);
			img.setTime(new Date());
			img.setState(0);
			img.setImgChinaName(fileName);
			img.setType(1);
			imgInfoService.addimg(img);
			writeResult(true, "上传成功！", this.getResponse());
		} else {
			writeResult(true, "上传失败！", this.getResponse());
		}
	}
	
	@Action(value = "delContractTemplate")
	public String delContractTemplate() throws Exception {
		this.getUrlRight(4);
		String imgID = this.getRequest().getParameter("imgID");
		try {
			ImgInfo img = imgInfoService.getImgInfoByID(imgID);
			File file = new File(img.getImgUrl());
			if (file.exists())
				file.delete();
				file.getParentFile().delete();
			imgInfoService.deleteById(img.getID());
			writeResult(true, "删除成功！", this.getResponse());
		} catch (IOException e) {
			writeResult(true, "删除失败！", this.getResponse());
			e.printStackTrace();
		}
		return "success";
	}
	
	@Action(value = "toPrint", results = { @Result(name = "success", location = "/contract/contract_print_show.jsp") })
	public String toPrint() {
		String applyID = this.getRequest().getParameter("applyID");
		String id = this.getRequest().getParameter("id");
		ApplyInfo applyInfo =  applyInfoService.getApplyInfoByID(applyID);
		APPLYCustInfo applyCustInfo = applyCustInfoService.getCustInfoByAplyID(Long.parseLong(applyID));
		ImgInfo imgInfo = imgInfoService.getImgInfoByID(id);
		String imgUrl = imgInfo.getImgUrl().replace("\\", "//");
		imgInfo.setImgUrl(imgUrl);
		
		PrintRecord printRecord = new PrintRecord();
		printRecord.setPrintNo(String.valueOf(System.currentTimeMillis()));
		printRecord.setPrintDate(new Date());
		printRecord.setContractNo(applyInfo.getApplyCode());
		printRecord.setUserID(sysUser.getUserID());
		printRecordService.addPrintRecord(printRecord);
		
		this.getSession().setAttribute("imgInfo", imgInfo);
		this.getSession().setAttribute("applyInfo", applyInfo);
		this.getSession().setAttribute("applyCustInfo", applyCustInfo);
		this.getSession().setAttribute("printRecord", printRecord);
		String amountCN = NumberToCN.number2CNMontrayUnit(applyInfo.getAmount());
		this.getSession().setAttribute("amountCN", amountCN);
		
		Company company = companyService.getCompany(applyInfo.getCompanyID().toString());
		this.getSession().setAttribute("company", company);
		ComLp comLp = comLpService.getComLp(applyInfo.getLpID().toString());
		this.getSession().setAttribute("comLp", comLp);
		return "success";
	}
	
	@Action(value = "toPrintRecord", results = { @Result(name = "success", location = "/contract/contract_print_record.jsp") })
	public String toPrintRecord() {
		String applyCode = this.getRequest().getParameter("applyCode");
		List<PrintRecord> printRecordList = printRecordService.getPrintRecordByApplyCode(applyCode);
		this.getSession().setAttribute("printRecordList", printRecordList);
		return "success";
	}
}