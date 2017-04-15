package com.hl.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.ImgInfoDao;
import com.hl.loan.pojo.ImgInfo;
import com.hl.loan.service.ImgInfoService;
import com.hl.loan.util.PageModel;

@Service("imgInfoDao")
public class ImgInfoServiceImpl implements ImgInfoService {
	
	@Autowired
	private ImgInfoDao imgInfoDao;

	@Override
	public void addimg(ImgInfo img) {
		imgInfoDao.addimg(img);
	}

	@Override
	public List<ImgInfo> getImgInfos(Long applyId, int type) {
		return imgInfoDao.getImgInfos(applyId, type);
	}

	@Override
	public ImgInfo getImgInfoByID(String imgID) {
		return imgInfoDao.load(imgID);
	}

	@Override
	public PageModel<ImgInfo> showImgInfo(PageModel<ImgInfo> pm, ImgInfo img) {
		return imgInfoDao.showImgInfo(pm, img);
	}

	@Override
	public void deleteById(Long id) {
		imgInfoDao.deleteById(id);
	}

	@Override
	public List<ImgInfo> getImgInfoListByType(int type) {
		return imgInfoDao.getImgInfoListByType(type);
	}

	@Override
	public List<ImgInfo> getImgInfoListByProductId(Long productId) {
		return imgInfoDao.getImgInfoListByProductId(productId);
	}
}