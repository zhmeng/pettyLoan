package com.hl.loan.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;




import javax.crypto.Cipher;
import javax.servlet.http.HttpServletResponse;


public class MethoeUtil {

	/**
	 * MD5加密方法
	 * 
	 * @param str
	 * @param encoding
	 *            default UTF-8
	 * @param no_Lower_Upper
	 *            0,1,2 0：不区分大小写，1：小写，2：大写
	 * @return MD5Str
	 */
	public static String getMD5(String str, String encoding, int no_Lower_Upper) {
		if (null == encoding)
			encoding = "utf-8";
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes(encoding));
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.toUpperCase().substring(1, 3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (no_Lower_Upper == 0) {
			return sb.toString();
		}
		if (no_Lower_Upper == 1) {
			return sb.toString().toLowerCase();
		}
		if (no_Lower_Upper == 2) {
			return sb.toString().toUpperCase();
		}
		return null;
	}

	/**
	 * DES
	 * 
	 * @param arrBTmp
	 * @return
	 * @throws Exception
	 */
	private static Key getKey(byte[] arrBTmp) throws Exception {
		byte[] arrB = new byte[8];// 创建一个空的8位字节数组（默认值为0）
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) { // 将原始字节数组转换为8位
			arrB[i] = arrBTmp[i];
		}
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");// 生成密钥
		return key;
	}

	/**
	 * DES
	 * 
	 * @param arrB
	 * @return
	 * @throws Exception
	 */
	private static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * DES
	 * 
	 * @param strIn
	 * @return
	 * @throws Exception
	 */
	private static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes("UTF-8");
		int iLen = arrB.length;
		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * DES方法 0为加密,1为解密
	 * 
	 * @param deskey
	 *            密钥
	 * @param str
	 *            待加密字符串
	 * @param type
	 *            0为加密,1为解密
	 * @return DES Str
	 */
	public static String getDES(String str, int type) {
		Cipher encryptCipher = null;
		Cipher decryptCipher = null;
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			if (isEmpty(CommonConstant.DES_KEY_DEFAULT)) {
				return null;
			}
			Key key = getKey(CommonConstant.DES_KEY_DEFAULT.getBytes("UTF-8"));
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
			// if (type == 0) { // 0为加密
			// return
			// byteArr2HexStr(encryptCipher.doFinal(str.getBytes("UTF-8")));
			// } else {
			// return new String(decryptCipher.doFinal(hexStr2ByteArr(str)));
			// }
			if (type == 0) { // 0为加密
				return byteArr2HexStr(encryptCipher.doFinal(str
						.getBytes("UTF-8")));
			} else {
				return new String(decryptCipher.doFinal(hexStr2ByteArr(str)),
						"UTF-8");
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().equalsIgnoreCase("null")
				|| obj.toString().length() == 0;
	}

	/*
	 * dt为日期 gs为转化格式，如yyyy-MM-dd 时间转换为字符串
	 */
	public static String stringToDate(Date dt, String gs) {
		SimpleDateFormat sdf = new SimpleDateFormat(gs);
		String str = sdf.format(dt);
		return str;
	}

	// 字符串转换为时间
	public static Date dateToString(String strdate, String str) {
		// SimpleDateFormat sdf=new SimpleDateFormat();
		// Date dt =new Date(1990-01-01);
		// try {
		// dt = sdf.parse(strdate);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// return dt;

		SimpleDateFormat format = new SimpleDateFormat(str);
		Date date = null;
		try {
			date = format.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 转化日期格式
	public static Date dateToDate(Date dt, String gs) {
		SimpleDateFormat sdf = new SimpleDateFormat(gs);
		String str = sdf.format(dt);
		Date dts = new Date(1990 - 01 - 01);
		try {
			dts = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dts;
	}




	//类之间赋予
	public static <T> T buildModel(Object dto, Class<T> modelClass) throws Exception {
		Class dtoClass = dto.getClass();
		T model = null;
		
		Method[] dtoGetMethods = ReflectUtil.getAllGetMethod(dtoClass);
		Map<String, Method> modelSetMethods = ReflectUtil.getAllSetMethodsToMap(modelClass);
		
		int size = dtoGetMethods.length;
		try {
			model = modelClass.newInstance();
			for(int i = 0; i < size; i++) {
				DtoField dtoFieldAnnt = dtoGetMethods[i].getAnnotation(DtoField.class);
				if (dtoFieldAnnt == null) {
					String mergeToMethodName = dtoGetMethods[i].getName().replaceFirst("g", "s");
					Method modelSetMethod = modelSetMethods.get(mergeToMethodName);
					if (modelSetMethod != null) {
						Object value = dtoGetMethods[i].invoke(dto);
						if(value != null) {
							modelSetMethod.invoke(model, value);
						}
					}
				} else {
					if (dtoFieldAnnt.ignoreAtMergeModel() == false) {
						String mergeToFieldName = dtoFieldAnnt.mergeToField();
						if("".equalsIgnoreCase(mergeToFieldName)) {
							mergeToFieldName = dtoGetMethods[i].getName().replaceFirst("g", "s");
						}
						Method modelSetMethod = modelSetMethods.get(mergeToFieldName);
						if (modelSetMethod != null) {
							Object value = dtoGetMethods[i].invoke(dto);
							if(value != null || dtoFieldAnnt.mergeNullValue() == true){
								modelSetMethod.invoke(model, value);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return model;
	}
	
	/**
	 * 打印JSON
	 * 
	 * @param response
	 * @param str
	 */
	public static void toJsonPrint(HttpServletResponse response, String str) {
		// 不需要设置 避免IE9 出现下载
		// response.setContentType("application/json");text/html;charset=UTF-8
		// response.setContentType("application/json");
		writer(response, str);
	}
	/**
	 * 打印
	 * 
	 * @param response
	 * @param str
	 */
	private static void writer(HttpServletResponse response, String str) {
		try {
			// 设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}










