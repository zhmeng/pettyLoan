package com.hl.loan.util;

import org.cheyue.key.service.Key;


public class CommonConstant {
	/**
	 * 系统DES密钥相关常量
	 */
	public static final String DES_KEY_DEFAULT = Key.getKey();

	/**
	 * 系统参数字典前缀
	 */
	public static final String SYS_DICTIONARY_PREFIX = "SYS_";

	/**
	 * 业务参数字典前缀
	 */
	public static final String BUS_DICTIONARY_PREFIX = "BUS_";
	
	public static final String SYS_BASE_DICTIONARY_KEY = "SYS_BASE_DICTIONARY_KEY";

	/**
	 * 系统标志位
	 */
	// 表示不可编辑
	public static final Character FLAG_IMMUTABLE = '0';
	// 表示可编辑
	public static final Character FLAG_VARIABLE = '1';
	
	public static final String SESSION_USER_TIMEOUT = "1800";

	/**
	 * Session中保存的用户信息
	 */
	public static final String SESSION_USER = "loginUser";
	
	// 修改手机号码的缓存
	public static final String USERINFOMATION_UPDATEPHONE = "USERINFOMATION_UPDATEPHONE";
	
	// 修改邮箱的x缓存
	public static final String USERINFOMATION_UPDATEEMAIL = "USERINFOMATION_UPDATEEMAIL";
	
	// 忘记提现密码缓存 
	public static final String SESSION_USERFINDPAY = "SESSION_USERFINDPAY";
	
	// 忘记登录密码缓存
	public static final String SESSION_USERFINDPWD = "SESSION_USERFINDPWD";
	
	
	//发送手机验证码
	public static final String SEND_PHONECODE = "SESSION_PHONECODE";
	
	//发送原手机验证码
	public static final String SEND_OLD_PHONECODE="SEND_OLD_PHONECODE";
	
	//发送邮箱验证码
	public static final String SEND_EMAILCODE="SEND_EMAILCODE";
	
	/**
	 * 用户登录session验证码(前端存储缓存)
	 */
	public static final String SESSION_USER_VERIFYCODE ="loginVerifyCode";

	/**
	 * servletcontext中存储的在线用户列表
	 */
	public static final String SERVLETCONTEXT_ONLINE_USER = "onlineUserList";

	/**
	 * 字符编码
	 */
	public static final String UTF8 = "UTF-8";

	/*
	 * 日志常量
	 */
	// 系统日志文件中Dao层发生异常时描述信息
	public static final String SYSTEM_LOG_DAO_MESSAGE = "Dao错误";
	// 系统日志文件中Service层发生异常时描述信息
	public static final String SYSTEM_LOG_SERVICE_MESSAGE = "Service错误";
	// 系统日志文件中Controller层发生异常时描述信息
	public static final String SYSTEM_LOG_CONTROLLER_MESSAGE = "Controller错误";
	// 系统日志文件中其他地方发生异常时描述信息
	public static final String SYSTEM_LOG_OTHER_MESSAGE = "其他错误";
	// 系统日志文件定位类文件描述符
	public static final String SYSTEM_LOG_CLASS_POSITION = "className:";
	// 系统日志文件定位类方法描述符
	public static final String SYSTEM_LOG_METHOD_POSITION = "methodName:";
	// 系统日志文件定位类行号描述符
	public static final String SYSTEM_LOG_LINENUMBER_POSITION = "lineNumber:";
	// 系统日志文件定位具体异常信息描述符
	public static final String SYSTEM_LOG_ERRORTYPE_POSITION = "errorDescription:";
	// 显示给用户的解决应用错误的方式描述信息
	public static final String SYSTEM_LOG_CONTACT_DESCRIPTION = "应用程序内部错误,请与技术人员联系!";
	// 系统日志文件前缀名称
	public static final String SYSTEM_LOG_PREFIX = "cheyue<xntz>";
	// 系统日志文件只记录拦截包发生的异常信息
	public static final String SYSTEM_LOG_INTERCEPTOR_PACKAGE = "com.xntz";
	// 定位Dao层发生异常常量
	public static final String SYSTEM_LOG_USER_DAO = "Dao";
	// 定位Service层发生异常常量
	public static final String SYSTEM_LOG_USER_SERVICE = "Service";
	// 定位Controller层发生异常常量
	public static final String SYSTEM_LOG_USER_CONTROLLER = "Controller";
	// 定位其他地方发生异常常量
	public static final String SYSTEM_LOG_USER_OTHER = "Other";

	/**
	 * 日期常量
	 */
	// 简单年月日日期格式
	public static final String DATE_SHORT_SIMPLE_FORMAT = "yyyyMMdd";
	// 年月日日期格式
	public static final String DATE_SHORT_FORMAT = "yyyy-MM-dd";
	// 中文年月日日期格式
	public static final String DATE_SHORT_CHN_FORMAT = "yyyy年MM月dd日";
	// 年月日时日期格式
	public static final String DATE_WITHHOUR_FORMAT = "yyyy-MM-dd HH";
	// 中文年月日时日期格式
	public static final String DATE_WITHHOUR_CHN_FORMAT = "yyyy年MM月dd日 HH";
	// 年月日时分日期格式
	public static final String DATE_WITHMINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	// 中文年月日时分日期格式
	public static final String DATE_WITHMINUTE_CHN_FORMAT = "yyyy年MM月dd日 HH:mm";
	// 年月日时分秒日期格式
	public static final String DATE_WITHSECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// 中文年月日时分秒日期格式
	public static final String DATE_WITHSECOND_CHN_FORMAT = "yyyy年MM月dd日 HH:mm:ss";
	// 年月日时分秒毫秒日期格式
	public static final String DATE_WITHMILLISECOND_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	// 中文年月日时分秒毫秒日期格式
	public static final String DATE_WITHMILLISECOND_CHN_FORMAT = "yyyy年MM月dd日 HH:mm:ss.S";
	// 中文年月日时分日期格式
	public static final String DATE_TMDHMS_CHN_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";
	
	
	/** 标的状态：已发布 */
	public static final int BORROW_STATUS_PUBLISHED = 0;
	/** 标的状态：已初审 */
	public static final int BORROW_STATUS_WAITING = 1;
	/** 标的状态：投标中 */
	public static final int BORROW_STATUS_TENDERING = 2;
	/** 标的状态：已满标 */
	public static final int BORROW_STATUS_FULL = 3;
	/** 标的状态：还款中 */
	public static final int BORROW_STATUS_REPAYING = 4;
	/** 标的状态：已还款 */
	public static final int BORROW_STATUS_REPAYED = 5;
	/** 标的状态：已流标 */
	public static final int BORROW_STATUS_FLOWED = 6;
	
	/** 标的方式:担保借款 */
	public static final int BORROW_WAY_GUARANTEE = 1;
	/** 标的方式:信用借款 */
	public static final int BORROW_WAY_CREDIT = 2;
	/** 标的方式:押付借款 */
	public static final int BORROW_WAY_OSHITSUKE = 3;
	/** 标的方式:净宝借款 */
	public static final int BORROW_WAY_NET_TREASURE = 4;
	/** 标的方式:安居宝借款 */
	public static final int BORROW_WAY_AN_JU_BAO = 5;
	/** 标的方式:收益权转让 */
	public static final int BORROW_WAY_USUFRUCT_TRANSFER = 6;
	/** 标的方式:秒标活动 */
	public static final int BORROW_WAY_SECOND_BORROW = 7;
	/** 标的方式:活期宝 */
	public static final int BORROW_WAY_DUE_ON_DEMAND = 8;
	/**
	 * 渠道用户接入标识：QQ
	 */
	public static final String CHANNEL_USER_MARK_QQ = "";
	/**
	 * 渠道用户接入标识：财经道
	 */
	public static final String CHANNEL_USER_MARK_CJD = "";
	
	/**
	 * 短信内容签名
	 */
	public static final String SMSSIGN = "【汇理财】"; 
	public static final String RETURNSTATUS = "returnstatus";  
	public static final String RESULT = "Result";  
	public static final String SUCCESS = "Success";  
	public static final String FAILD = "Faild"; 
	public static final String WELCOME = "欢迎注册汇理财";
	
	/**
	 * 网站注册地址
	 */
	public static final String LOCALHOST="http://www.huilc.cn";
	
	
	public static final String BUILDINGADDRESS= "buildingAddress";
	
	public static final String APPSHAREINFO= "appShareInfo";
	/**
	 * 发送邮箱的标题
	 */
	public static final String UPDATE_PASSWORD_NOTICE= "密码修改成功的通知";
	public static final String EMAIL_CODE= "请查收你的验证码";
	public static final String UPDATE_LOGIN_PASSWORD= "您正在找回登录密码，请查收你的验证码";
	public static final String MAKE_SURE_EMAIL_CODE= "您正在绑定邮箱,请查收你的验证码";
	public static final String UPDATE_TIXIAN_PASSWORD= "您正在找回提现密码，请查收你的验证码";
	public static final String INVEST= "投标成功的通知";
	public static final String RECHARGE= "您已充值成功";
	public static final String CASE= "提现审核的通知";
}



