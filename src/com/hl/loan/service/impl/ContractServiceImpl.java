package com.hl.loan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.ContractDao;
import com.hl.loan.pojo.Contract;
import com.hl.loan.service.ContractService;
import com.hl.loan.util.PageModel;

@Service("contractDao")
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao contractDao;

	@Override
	public void addContract(Contract contract) {
		contractDao.addContract(contract);
	}

	@Override
	public PageModel<Contract> showContract(PageModel<Contract> pm, Contract contract) {
		return contractDao.showContract(pm, contract);
	}

	@Override
	public int delContract(String contractID) {
		int result = contractDao.delContract(contractID);
		return result;
	}

	@Override
	public int updateContractByID(String contractID, Contract contract) {
		int result = contractDao.updateContractByID(contractID, contract);
		return result;
	}

	@Override
	public Contract getContractByID(String contractID) {
		return contractDao.load(contractID);
	}

	@Override
	public Contract getContractByApplyID(Long applyID) {
		return contractDao.getContractByApplyID(applyID);
	}
}
