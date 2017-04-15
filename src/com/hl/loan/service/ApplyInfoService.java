package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.pojo.Product;
import com.hl.loan.util.PageModel;

public interface ApplyInfoService {
	
	public void addApplyInfo(ApplyInfo applyInfo);

	public Long saveApplyInfo(ApplyInfo applyInfo);

	public void updateApplyInfo(ApplyInfo applyInfo);

	public PageModel<ApplyInfo> showApplyInfo(PageModel<ApplyInfo> pm, ApplyInfo applyInfo);
	
	public ApplyInfo getApplyInfoByID(String applyID);
	
	public int delApplyInfo(String applyID);

	public PageModel<ApplyInfo> showApplyOaInfo(PageModel<ApplyInfo> pm,List<NoteAndUser> ntlist, int userId,ApplyInfo applyInfo);

	public ApplyInfo load(String applyID);

	public List<ApplyInfo> getAllMyOa(List<NoteAndUser> ntlist, int userId,ApplyInfo applyInfo);
	
	// 根据CompanyID获得开发商信息
	public Company getCompanyByApplyID(Long CompanyID);

	// 根据CityID获得城市信息
	public City getCityByCityID(Long CityID);

	// 根据LpID获得楼盘信息
	public ComLp getComLpByApplyID(Long LpID);

	// 根据ProductID获得产品信息
	public Product getProductByProductID(Long ProductID);
}
