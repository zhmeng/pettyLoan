package com.hl.loan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comproduct")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 产品实体
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private Long productID; // 产品ID

	@Column(name = "ProductKey")
	private String productKey; // 产品索引编码，不可重复

	@Column(name = "ProductName")
	private String productName; // 产品名称

	@Column(name = "ProductFlag")
	private Integer productFlag; // 产品状态 0：无效，1：生效，2：过期，4：删除

	@Column(name = "ProductDesc")
	private String productDesc; // 产品描述

	@Column(name = "ProductValSTime")
	private Date productValSTime; // 有效期开始时间

	@Column(name = "ProductValETime")
	private Date productValETime; // 有效期结束时间

	@Column(name = "ProductPayment")
	private String productPayment; // 还款方式 1：按期还息到期还本，2：等额本息，3：等额本金，4：一次性还本付息，5：预收利息一次性还本，6：按月还息按期还本，7：按月还息任意还本，8：按月还息到期还本(提前收息)，9：平息

	@Column(name = "ProductLoanRate")
	private BigDecimal productLoanRate; // 利息

	@Column(name = "ProductLoanRateshow")
	private BigDecimal productLoanRateshow; // 贷款利率基数 1：%，2：‰

	@Column(name = "ProductManageRate")
	private BigDecimal productManageRate; // 管理费率

	@Column(name = "ProductManageRateShow")
	private BigDecimal productManageRateShow; // 管理费率基数 1：%，2：‰

	@Column(name = "ProductFeesRate")
	private BigDecimal productFeesRate; // 手续费率

	@Column(name = "ProductFeesRateShow")
	private BigDecimal productFeesRateShow; // 手续费率基数 1：%，2：‰

	@Column(name = "ProductParm1")
	private BigDecimal productParm1; // 利息计算参数1 1：按每月30天，2：按实际天数

	@Column(name = "ProductParm2")
	private BigDecimal productParm2; // 利息计算参数2 1：按贷款金额计息，2：按结欠金额计息

	@Column(name = "ProductParm3")
	private BigDecimal productParm3; // 利息计算参数3 1：算头又算尾，2：算头不算尾

	@Column(name = "ProductKC")
	private BigDecimal productKC; // 考察费用

	@Column(name = "ProductFileList")
	private String productFileList; // 合同模板文件列表，不可维护

	@Column(name = "ProductEditRate")
	private Integer productEditRate; // 利率是否可调 0：不可调

	@Column(name = "ProductSecurity")
	private Integer productSecurity; // 产品流程性质 0：正常或特批，1：唯正常，2：唯特批

	@Column(name = "ProductCycle")
	private Integer productCycle; // 利息周期 0月一次（贷款申请时可调），1月一次，3月一次，6月一次

	@Column(name = "ProductLRateParm")
	private Integer productLRateParm; // 利息收取方式 1：月头预收，2：月尾结算

	@Column(name = "ProductRightUser")
	private String productRightUser; // 哪些人有权限，不可维护

	@Column(name = "ProductRightDept")
	private String productRightDept; // 哪些部门有权限，不可维护

	@Column(name = "ProductRightSite")
	private String productRightSite; // 哪些网点有权限，不可维护

	@Column(name = "ProductCAPITALCycle")
	private Integer productCAPITALCycle; // 本金周期 0月一次（贷款申请时可调），1月一次，3月一次，6月一次

	@Column(name = "ProductLRateList")
	private String productLRateList; // 利率档次，多个利率选择

	@Column(name = "ProductMRateList")
	private String productMRateList; // 管理费率档次，多个管理费率选择

	@Column(name = "ProductFRateList")
	private String productFRateList; // 手续费率档次，多个手续费率选择

	@Column(name = "ProSHDeptNoList")
	private String proSHDeptNoList; // 哪些部门审核此产品，审核分配时找这些部门的员工

	@Column(name = "ProDCDeptNoList")
	private String proDCDeptNoList; // 哪些部门调查此产品，现场调查分配时找这些部门的员工

	@Column(name = "ProductFee")
	private BigDecimal productFee; // 综合费率，默认综合费率

	@Column(name = "ProductFeeList")
	private String productFeeList; // 综合费率档次，多个综合费率选择
	
	@Column(name = "CreateById")
	private Long createById; // 创建人
	
	@Column(name = "UpdateById")
	private Long updateById; // 修改人
	
	@Column(name = "CreateTime")
	private Date createTime; // 创建时间
	
	@Column(name = "UpdateTime")
	private Date updateTime; // 修改时间
	
	@Column(name = "ImgIds")
	private String imgIds; // 模板id字符串

	public String getImgIds() {
		return imgIds;
	}

	public void setImgIds(String imgIds) {
		this.imgIds = imgIds;
	}

	public Long getCreateById() {
		return createById;
	}

	public void setCreateById(Long createById) {
		this.createById = createById;
	}

	public Long getUpdateById() {
		return updateById;
	}

	public void setUpdateById(Long updateById) {
		this.updateById = updateById;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductFlag() {
		return productFlag;
	}

	public void setProductFlag(Integer productFlag) {
		this.productFlag = productFlag;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Date getProductValSTime() {
		return productValSTime;
	}

	public void setProductValSTime(Date productValSTime) {
		this.productValSTime = productValSTime;
	}

	public Date getProductValETime() {
		return productValETime;
	}

	public void setProductValETime(Date productValETime) {
		this.productValETime = productValETime;
	}

	public String getProductPayment() {
		return productPayment;
	}

	public void setProductPayment(String productPayment) {
		this.productPayment = productPayment;
	}

	public BigDecimal getProductLoanRate() {
		return productLoanRate;
	}

	public void setProductLoanRate(BigDecimal productLoanRate) {
		this.productLoanRate = productLoanRate;
	}

	public BigDecimal getProductLoanRateshow() {
		return productLoanRateshow;
	}

	public void setProductLoanRateshow(BigDecimal productLoanRateshow) {
		this.productLoanRateshow = productLoanRateshow;
	}

	public BigDecimal getProductManageRate() {
		return productManageRate;
	}

	public void setProductManageRate(BigDecimal productManageRate) {
		this.productManageRate = productManageRate;
	}

	public BigDecimal getProductManageRateShow() {
		return productManageRateShow;
	}

	public void setProductManageRateShow(BigDecimal productManageRateShow) {
		this.productManageRateShow = productManageRateShow;
	}

	public BigDecimal getProductFeesRate() {
		return productFeesRate;
	}

	public void setProductFeesRate(BigDecimal productFeesRate) {
		this.productFeesRate = productFeesRate;
	}

	public BigDecimal getProductFeesRateShow() {
		return productFeesRateShow;
	}

	public void setProductFeesRateShow(BigDecimal productFeesRateShow) {
		this.productFeesRateShow = productFeesRateShow;
	}

	public BigDecimal getProductParm1() {
		return productParm1;
	}

	public void setProductParm1(BigDecimal productParm1) {
		this.productParm1 = productParm1;
	}

	public BigDecimal getProductParm2() {
		return productParm2;
	}

	public void setProductParm2(BigDecimal productParm2) {
		this.productParm2 = productParm2;
	}

	public BigDecimal getProductParm3() {
		return productParm3;
	}

	public void setProductParm3(BigDecimal productParm3) {
		this.productParm3 = productParm3;
	}

	public BigDecimal getProductKC() {
		return productKC;
	}

	public void setProductKC(BigDecimal productKC) {
		this.productKC = productKC;
	}

	public String getProductFileList() {
		return productFileList;
	}

	public void setProductFileList(String productFileList) {
		this.productFileList = productFileList;
	}

	public Integer getProductEditRate() {
		return productEditRate;
	}

	public void setProductEditRate(Integer productEditRate) {
		this.productEditRate = productEditRate;
	}

	public Integer getProductSecurity() {
		return productSecurity;
	}

	public void setProductSecurity(Integer productSecurity) {
		this.productSecurity = productSecurity;
	}

	public Integer getProductCycle() {
		return productCycle;
	}

	public void setProductCycle(Integer productCycle) {
		this.productCycle = productCycle;
	}

	public Integer getProductLRateParm() {
		return productLRateParm;
	}

	public void setProductLRateParm(Integer productLRateParm) {
		this.productLRateParm = productLRateParm;
	}

	public String getProductRightUser() {
		return productRightUser;
	}

	public void setProductRightUser(String productRightUser) {
		this.productRightUser = productRightUser;
	}

	public String getProductRightDept() {
		return productRightDept;
	}

	public void setProductRightDept(String productRightDept) {
		this.productRightDept = productRightDept;
	}

	public String getProductRightSite() {
		return productRightSite;
	}

	public void setProductRightSite(String productRightSite) {
		this.productRightSite = productRightSite;
	}

	public Integer getProductCAPITALCycle() {
		return productCAPITALCycle;
	}

	public void setProductCAPITALCycle(Integer productCAPITALCycle) {
		this.productCAPITALCycle = productCAPITALCycle;
	}

	public String getProductLRateList() {
		return productLRateList;
	}

	public void setProductLRateList(String productLRateList) {
		this.productLRateList = productLRateList;
	}

	public String getProductMRateList() {
		return productMRateList;
	}

	public void setProductMRateList(String productMRateList) {
		this.productMRateList = productMRateList;
	}

	public String getProductFRateList() {
		return productFRateList;
	}

	public void setProductFRateList(String productFRateList) {
		this.productFRateList = productFRateList;
	}

	public String getProSHDeptNoList() {
		return proSHDeptNoList;
	}

	public void setProSHDeptNoList(String proSHDeptNoList) {
		this.proSHDeptNoList = proSHDeptNoList;
	}

	public String getProDCDeptNoList() {
		return proDCDeptNoList;
	}

	public void setProDCDeptNoList(String proDCDeptNoList) {
		this.proDCDeptNoList = proDCDeptNoList;
	}

	public BigDecimal getProductFee() {
		return productFee;
	}

	public void setProductFee(BigDecimal productFee) {
		this.productFee = productFee;
	}

	public String getProductFeeList() {
		return productFeeList;
	}

	public void setProductFeeList(String productFeeList) {
		this.productFeeList = productFeeList;
	}
}
