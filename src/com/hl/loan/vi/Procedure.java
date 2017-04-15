package com.hl.loan.vi;
//存储过程输入参数
public class Procedure {
	public Procedure(Integer userId,Long applyId,Integer examines,Integer beginoa,Integer endoa,String view,Integer next,Integer mold){
		setUserId(userId);
		setApplyId(applyId);
		setExamines(examines);
		setBeginoa(beginoa);
		setEndoa(endoa);
		setView(view);
		setNext(next);
		setMold(mold);
	}
	private Integer userId;				//用户id
	private Long applyId;			//贷款申请
	private Integer examines;         //1.同意    2.退回    3.拒绝  
	private Integer beginoa;			//流程开始数字
	private Integer endoa;					//流程结束数字
	private String view;				//说明
	private Integer next;				//下一类型开始
	private Integer mold;				//类型
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getApplyId() {
		return applyId;
	}
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	public Integer getExamines() {
		return examines;
	}
	public void setExamines(Integer examines) {
		this.examines = examines;
	}
	public Integer getBeginoa() {
		return beginoa;
	}
	public void setBeginoa(Integer beginoa) {
		this.beginoa = beginoa;
	}
	public Integer getEndoa() {
		return endoa;
	}
	public void setEndoa(Integer endoa) {
		this.endoa = endoa;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getMold() {
		return mold;
	}
	public void setMold(Integer mold) {
		this.mold = mold;
	}
	
}
