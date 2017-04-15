package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.PrintRecord;

public interface PrintRecordService {

	// 增加打印记录信息
	public void addPrintRecord(PrintRecord printRecord);
	
	public List<PrintRecord> getPrintRecordByApplyCode(String applyCode);
}
