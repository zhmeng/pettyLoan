package com.hl.loan.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.hl.loan.pojo.ImgInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import com.hl.loan.pojo.Product;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.ImgInfoService;
import com.hl.loan.service.ProductService;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;

@Namespace("/action/product")
@ResultPath("/")
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
	
	@Autowired
	private ProductService productService;
	private Product product;
	private PageModel<Product> pm;
	private ImgInfoService imgInfoService;

	public ImgInfoService getImgInfoService() {
		return imgInfoService;
	}

	public void setImgInfoService(ImgInfoService imgInfoService) {
		this.imgInfoService = imgInfoService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PageModel<Product> getPm() {
		return pm;
	}

	public void setPm(PageModel<Product> pm) {
		this.pm = pm;
	}

	/*
	 * 按条件查找相应业务信息
	 */
	@Action(value = "goProductList", results = { @Result(name = "success", location = "/product/product_list.jsp") })
	public String goProductList() {
		List<Buttons> blist=this.getUrlRight(1);
		Product product = getProduct();
		PageModel<Product> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = productService.showProduct(pm, product);
		List<ImgInfo> imgList = imgInfoService.getImgInfoListByType(1);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("product", product);
		this.getRequest().setAttribute("imgList", imgList);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	/*
	 * 跳转到添加业务页面
	 */
	@Action(value = "toAddProduct", results = { @Result(name = "success", location = "/product/product_add.jsp") })
	public String toAddProduct() {
		this.getUrlRight(2);
		return "success";
	}

	/*
	 * 添加业务信息
	 */
	@Action(value = "addProduct")
	public void addProduct() {
		String productKey = this.getRequest().getParameter("productKey");
		String productName = this.getRequest().getParameter("productName");
		String productFlag = this.getRequest().getParameter("productFlag");
		String productDesc = this.getRequest().getParameter("productDesc");
		String productValSTime = this.getRequest().getParameter("productValSTime");
		String productValETime = this.getRequest().getParameter("productValETime");
		String productPayment = this.getRequest().getParameter("productPayment");
		String productLoanRate = this.getRequest().getParameter("productLoanRate");
		String productFeesRate = this.getRequest().getParameter("productFeesRate");
		String imgIds = this.getRequest().getParameter("imgIds");
		try {
			Product product = new Product();
			product.setProductKey(productKey);
			product.setProductName(productName);
			product.setProductFlag(Integer.valueOf(productFlag));
			product.setProductDesc(productDesc);
			product.setProductValSTime(MethoeUtil.dateToString(productValSTime, "yyyy-MM-dd HH:mm"));
			product.setProductValETime(MethoeUtil.dateToString(productValETime, "yyyy-MM-dd HH:mm"));
			product.setProductPayment(productPayment);
			product.setProductLoanRate(new BigDecimal(productLoanRate));
			product.setProductFeesRate(new BigDecimal(productFeesRate));
			product.setCreateById(sysUser.getUserID().longValue());
			product.setImgIds(imgIds);
			product.setCreateTime(new Date());
			productService.addProduct(product);
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据ID删除业务
	 */
	@Action(value = "delProduct")
	public void delProduct() {
		this.getUrlRight(4);
		String productID = this.getRequest().getParameter("productID");
		try {
			int result = productService.delProduct(productID);
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 跳转到修改业务页面
	@Action(value = "toUpdateProduct", results = { @Result(name = "success", location = "/product/product_update.jsp") })
	public String toUpdateProduct() {
		this.getUrlRight(8);
		String productID = this.getRequest().getParameter("productID");
		Product product = productService.getProductByID(productID);
		this.getRequest().setAttribute("product", product);
		
		List<ImgInfo> imgList = imgInfoService.getImgInfoListByType(1);
		this.getRequest().setAttribute("imgList", imgList);
		
		String value = "0";
		if (!product.getImgIds().equals("") && null != product.getImgIds()) {
			value = product.getImgIds();
		}
		String[] str = value.split(",");
		List<Buttons> imgIdList = new ArrayList<>();
		for (ImgInfo imgInfo : imgList) {
			Buttons bt = new Buttons();
			int flag = 0;
			for (String ids : str) {
				Long imgId = Long.parseLong(ids);
				if (imgInfo.getID().equals(imgId)) {
					flag = 1;
				}
			}
			bt.setCid(imgInfo.getID().toString());
			bt.setcName(imgInfo.getImgChinaName());
			if (flag == 1) {
				bt.setIsShow(1);
			} else {
				bt.setIsShow(2);
			}
			imgIdList.add(bt);
		}
		this.getRequest().setAttribute("imgIdList", imgIdList);
		return "success";
	}

	// 修改业务信息
	@Action(value = "updateProduct")
	public void updateProduct() {
		String productID = this.getRequest().getParameter("productID");
		String productKey = this.getRequest().getParameter("productKey");
		String productName = this.getRequest().getParameter("productName");
		String productFlag = this.getRequest().getParameter("productFlag");
		String productDesc = this.getRequest().getParameter("productDesc");
		String productValSTime = this.getRequest().getParameter("productValSTime");
		String productValETime = this.getRequest().getParameter("productValETime");
		String productPayment = this.getRequest().getParameter("productPayment");
		String productLoanRate = this.getRequest().getParameter("productLoanRate");
		String productFeesRate = this.getRequest().getParameter("productFeesRate");
		String imgIds = this.getRequest().getParameter("imgIds");
		try {
			Product product = productService.getProductByID(productID);
			product.setProductKey(productKey);
			product.setProductName(productName);
			product.setProductFlag(Integer.valueOf(productFlag));
			product.setProductDesc(productDesc);
			product.setProductValSTime(MethoeUtil.dateToString(productValSTime, "yyyy-mm-dd HH:mm:ss"));
			product.setProductValETime(MethoeUtil.dateToString(productValETime, "yyyy-mm-dd HH:mm:ss"));
			product.setProductPayment(productPayment);
			product.setProductLoanRate(new BigDecimal(productLoanRate));
			product.setProductFeesRate(new BigDecimal(productFeesRate));
			product.setUpdateById(sysUser.getUserID().longValue());
			product.setImgIds(imgIds);
			product.setUpdateTime(new Date());
			int result = productService.updateProductByID(productID, product);
			if (result == 1) {
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}