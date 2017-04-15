package com.hl.loan.util;

import java.util.List;

/**
 * 分页组件(包含当前页结果数据列表和总记录数) 它不是持久化实体类
 * 
 */
public final class PageModel<T> {
	private int recordCount; // 总条数
	private List<T> datas; // 当前页数集合（在页面循环遍历显示数据）
	private int pageSize = 20; // 每页要显示的记录数
	private int pageNo = 1; // 当前页号

	public int getRecordCount() {

		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
