package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.ApplyInfoDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.pojo.Product;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.util.PageModel;

@Service("applyInfoService")
public class ApplyInfoServiceImpl implements ApplyInfoService {
	@Resource
	private ApplyInfoDao applyInfoDao;

	@Override
	public Long saveApplyInfo(ApplyInfo applyInfo) {
		return applyInfoDao.savaAppply(applyInfo);
	}

	@Override
	public void updateApplyInfo(ApplyInfo applyInfo) {
		applyInfoDao.updateAppply(applyInfo);
	}

	@Override
	public PageModel<ApplyInfo> showApplyInfo(PageModel<ApplyInfo> pm, ApplyInfo applyInfo) {
		return applyInfoDao.showApplyInfo(pm, applyInfo);
	}

	@Override
	public void addApplyInfo(ApplyInfo applyInfo) {
		applyInfoDao.addAppplyInfo(applyInfo);
	}

	@Override
	public ApplyInfo getApplyInfoByID(String applyID) {
		return applyInfoDao.load(applyID);
	}

	@Override
	public int delApplyInfo(String applyID) {
		int result = applyInfoDao.delApplyInfo(applyID);
		return result;
	}
	@Override
	public PageModel<ApplyInfo> showApplyOaInfo(PageModel<ApplyInfo> pm,List<NoteAndUser> ntlist,int userId,ApplyInfo applyInfo){
		return applyInfoDao.showApplyOaInfo(pm, ntlist, userId,applyInfo);
	}
	@Override
	public ApplyInfo load(String applyID) {
		return applyInfoDao.load(applyID);
	}
	@Override
	public List<ApplyInfo> getAllMyOa(List<NoteAndUser> ntlist,int userId,ApplyInfo applyInfo){
		return applyInfoDao.getAllMyOa(ntlist, userId, applyInfo);
	}

	@Override
	public Company getCompanyByApplyID(Long CompanyID) {
		return applyInfoDao.getCompanyByApplyID(CompanyID);
	}

	@Override
	public City getCityByCityID(Long CityID) {
		return applyInfoDao.getCityByCityID(CityID);
	}

	@Override
	public ComLp getComLpByApplyID(Long LpID) {
		return applyInfoDao.getComLpByApplyID(LpID);
	}

	@Override
	public Product getProductByProductID(Long ProductID) {
		return applyInfoDao.getProductByProductID(ProductID);
	}

}





