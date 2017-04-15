package com.hl.loan.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hl.loan.dao.SendLoanDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.service.SendLoanService;
import com.hl.loan.util.PageModel;

@Transactional
@Service("sendLoanService")
public class SendLoanServiceImpl implements SendLoanService {
	@Autowired
	private SendLoanDao sendLoanDao;

	@Override
	public PageModel<ApplyInfo> getApplyInfoList(PageModel<ApplyInfo> pm,
			ApplyInfo applyInfo) {
		// TODO Auto-generated method stub
		return sendLoanDao.getApplyInfoList(pm, applyInfo);
	}

	public SendLoanDao getSendLoanDao() {
		return sendLoanDao;
	}

	public void setSendLoanDao(SendLoanDao sendLoanDao) {
		this.sendLoanDao = sendLoanDao;
	}

	@Override
	public void confSendApplyLoan(String applyID, Date sendDate) {
		
		sendLoanDao.confSendApplyLoan(applyID, sendDate);
	}

	

}
