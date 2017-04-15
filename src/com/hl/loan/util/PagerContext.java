package com.hl.loan.util;

public class PagerContext {
	private static ThreadLocal<Integer> pageNo = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

	public static Integer getPageNo() {
		if (pageNo.get() == null) {
			return 1;
		}
		return pageNo.get();
	}

	public static Integer getPageSize() {
		if (pageSize.get() == null) {
			return 10;
		}
		return pageSize.get();
	}

	public static void setPageNo(Integer pageNoValue) {
		pageNo.set(pageNoValue);
	}

	public static void setPageSize(Integer pageSizeValue) {
		pageSize.set(pageSizeValue);
	}
	
	public static void removePageNo(){
		pageNo.remove();
	}
	
	public static void removePageSize(){
		pageSize.remove();
	}
}
