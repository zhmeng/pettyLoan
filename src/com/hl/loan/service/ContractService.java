package com.hl.loan.service;

import com.hl.loan.pojo.Contract;
import com.hl.loan.util.PageModel;

public interface ContractService {

	// 增加合同信息
	public void addContract(Contract contract);

	public PageModel<Contract> showContract(PageModel<Contract> pm, Contract contract);
	
	public int delContract(String contractID);
	
	// 根据ID修改合同信息
	public int updateContractByID(String contractID, Contract contract);
	
	public Contract getContractByID(String contractID);
	
	public Contract getContractByApplyID(Long applyID);
}
