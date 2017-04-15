package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.ImgInfo;
import com.hl.loan.util.PageModel;

public interface ImgInfoService {
	
	public void addimg(ImgInfo img);

	// 根据applyId 查出imgList
	public List<ImgInfo> getImgInfos(Long applyId, int type);
	
	public ImgInfo getImgInfoByID(String imgID);
	
	public PageModel<ImgInfo> showImgInfo(PageModel<ImgInfo> pm, ImgInfo img);
	
	public void deleteById(Long id);
	
	public List<ImgInfo> getImgInfoListByType(int type);
	
	public List<ImgInfo> getImgInfoListByProductId(Long productId);
}
