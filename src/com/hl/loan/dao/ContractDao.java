package com.hl.loan.dao;

import com.hl.loan.pojo.Contract;
import com.hl.loan.util.PageModel;

public interface ContractDao {

	// 增加合同
	public void addContract(Contract contract);

	public PageModel<Contract> showContract(PageModel<Contract> pm, Contract contract);
	
	// 根据ID删除合同
	public int delContract(String contractID);
	
	// 根据ID修改合同信息
	public int updateContractByID(String contractID, Contract contract);
	
	public Contract load(String contractID);
	
	public Contract getContractByApplyID(Long applyID);
}
