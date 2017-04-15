package com.hl.loan.dao;

import java.util.List;
import com.hl.loan.pojo.PrintRecord;

public interface PrintRecordDao {

	// 增加打印记录信息
	public void addPrintRecord(PrintRecord printRecord);
	
	public List<PrintRecord> getPrintRecordByApplyCode(String applyCode);
}
