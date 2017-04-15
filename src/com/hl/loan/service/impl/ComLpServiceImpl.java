package com.hl.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.ComLpDao;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.service.ComLpService;
import com.hl.loan.util.PageModel;

@Service("comLpDao")
public class ComLpServiceImpl implements ComLpService {
	@Autowired
	private ComLpDao comLpDao;

	@Override
	public void addComLp(ComLp comLp) {
		comLpDao.addComLp(comLp);
	}

	@Override
	public PageModel<ComLp> showComLp(PageModel<ComLp> pm, ComLp comLp) {
		return comLpDao.showComLp(pm, comLp);
	}

	@Override
	public int delComLp(String lpID) {
		int result = comLpDao.delComLp(lpID);
		return result;
	}

	@Override
	public List<ComLp> getComLpByID(String lpID) {
		return comLpDao.getComLpByID(lpID);
	}

	@Override
	public int updateComLpByID(String lpID, ComLp comLp) {
		int result = comLpDao.updateComLpByID(lpID, comLp);
		return result;
	}

	@Override
	public ComLp getComLp(String lpID) {
		return comLpDao.load(lpID);
	}

	@Override
	public List<ComLp> getAllLp() {
		return comLpDao.getAllLp();
	}

	@Override
	public List<ComLp> getAllLnapByCityID(Long cityID) {
		return comLpDao.getAllLnapByCityID(cityID);
	}
}
