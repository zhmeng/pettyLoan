package com.hl.loan.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ReflectUtil {
	@SuppressWarnings("unchecked")
	public static void setFieldValue(Object target, String fname, Class ftype,
			Object fvalue) {
		if (target == null
				|| fname == null
				|| "".equals(fname)
				|| (fvalue != null && !ftype
						.isAssignableFrom(fvalue.getClass()))) {
			return;
		}
		Class clazz = target.getClass();
		try {
			Method method = clazz.getDeclaredMethod(
					"get" + Character.toUpperCase(fname.charAt(0))
							+ fname.substring(1), ftype);
			if (!Modifier.isPublic(method.getModifiers())) {
				method.setAccessible(true);
			}
			method.invoke(target, fvalue);
		} catch (Exception me) {
			try {
				Field field = clazz.getDeclaredField(fname);
				if (!Modifier.isPublic(field.getModifiers())) {
					field.setAccessible(true);
				}
				field.set(target, fvalue);
			} catch (Exception fe) {
				System.out.println(fe.getMessage());
			}
		}
	}

	public static Field[] getAllFields(Class klass) {
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(klass.getDeclaredFields()));
		if (klass.getSuperclass() != null) {
			fields.addAll(Arrays.asList(getAllFields(klass.getSuperclass())));
		}
		return fields.toArray(new Field[] {});
	}

	public static Map<String, Field> getAllFieldsToMap(Class clazz) {
		Field[] fields = getAllFields(clazz);
		Map<String, Field> result = new HashMap<String, Field>();
		if (fields != null) {
			for (Field field : fields) {
				result.put(field.getName(), field);
			}
		}
		return result;
	}

	public static List<Map> buildMapFromObject(Object obj,String fun_cde,String userId) {
		List<Map> result = new ArrayList<Map>();
		if(obj != null) {
			Class clazz = obj.getClass();
			Field[] fields = getAllFields(clazz);
			try {
				for(Field field : fields){
					DtoField dtoFieldAnnt = field.getAnnotation(DtoField.class);
					if (dtoFieldAnnt != null) {
						Map<String, String> row = new HashMap<String, String>();
						String key = dtoFieldAnnt.mergeToField();
						field.setAccessible(true);
						Object value = field.get(obj);
						if(value==null){
							value="";
						}
						if(value instanceof Date){
							SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							value = dateFormatter.format(value);
						};
						row.put("mod_cde","VMS");
						row.put("fun_cde",fun_cde);
						row.put("userId",userId);
						row.put("key", key);
						row.put("val", value.toString());
						result.add(row);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Object buildObjectFromMap(List<Map> list, Class clazz) {
		Object result = null; 
		Field[] fields = getAllFields(clazz);
		try {
			result = clazz.newInstance();
			for(Field field : fields) {
				DtoField dtoFieldAnnt = field.getAnnotation(DtoField.class);
				Object obj = field.getType();
				String key = dtoFieldAnnt.mergeToField();
				Map map  = getRelativeField(list, key);
				if(map !=null){
					Object value = map.get("PARAM_VAL");
					if(obj.equals(Boolean.class)){
						value = Boolean.parseBoolean(value.toString());
					}
					if(obj.equals(Date.class)){
						//value = DateFormat.getDateInstance().parse(value.toString());
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						value = format.parse(value.toString());
					}
					if(obj.equals(BigDecimal.class)){
						BigDecimal bigDecimal = new BigDecimal(value.toString());
						value = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
					}
					if(obj.equals(Integer.class)){
						value = Integer.parseInt(value.toString());
					}
					
					field.setAccessible(true);
					field.set(result, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main1(String[] args) throws Exception {
//		DeviceGroup deviceGroup = new DeviceGroup();
//		deviceGroup.setVersionId(1L);
//		Field[] fields = getAllFields(DeviceGroup.class);
//		int size = fields.length;
//		for (int i = 0; i < size; i++) {
//			System.out.println(fields[i].getName());
//		}
//		Class clazz = BaseModel.class;
//		Field versionField = clazz.getDeclaredField("versionId");
//		// Field versionField = clazz.getField("versionId");
//		versionField.setAccessible(true);
//		Object versionId = versionField.get(deviceGroup);
//		System.out.println(versionId);
	}

	public static Map getRelativeField(List<Map> list, String fieldName) {
		for(Map map : list) {
			if(map.get("PARAM_KEY").toString().equalsIgnoreCase(fieldName)) {
				return map;
			}
		}
		return null;
	}
	
	public static Method[] getAllSetMethod(Class klass) {
		return getMethodStartWith(klass, "set");
	}
	
	public static Method[] getAllGetMethod(Class klass) {
		return getMethodStartWith(klass, "get");
	} 
	
	public static Method[] getMethodStartWith(Class klass, String pattern) {
		List<Method> methods = new ArrayList<Method>();
		Method[] mds = klass.getDeclaredMethods();
		for(Method method : mds) {
			if (method.getName().startsWith(pattern)) {
				methods.add(method);
			}
		}
		
		if (klass.getSuperclass() != null) {
			methods.addAll(Arrays.asList(getMethodStartWith(klass.getSuperclass(), pattern)));
		}
		return methods.toArray(new Method[] {});
	} 
	
	public static Map<String, Method> getAllGetMethodsToMap(Class clazz) {
		return getMethodsStartWithToMap(clazz, "get");
	}
	
	public static Map<String, Method> getAllSetMethodsToMap(Class clazz) {
		return getMethodsStartWithToMap(clazz, "set");
	}
	
	private static Map<String, Method> getMethodsStartWithToMap(Class clazz, String pattern) {
		Method[] methods = getMethodStartWith(clazz, pattern);
		Map<String, Method> result = new HashMap<String, Method>();
		if (methods != null) {
			for (Method method : methods) {
				result.put(method.getName(), method);
			}
		}
		return result;
	}
	
	public static Object invokeMethodByName(String className, String methodName, Object bean, Object[] argList) throws Exception {
		Method mtd = null;
		Object obj = null;
		try{
			Class svcClz = Class.forName(className);
			Class[] argClzs = null;
			int size = argList.length;
			argClzs = new Class[size];
			for(int i = 0; i < size; i++) {
				argClzs[i] = argList[i].getClass();
			}
			mtd = svcClz.getMethod(methodName, argClzs);
		}catch(Exception ce){
			ce.printStackTrace();
			throw ce;
		}
		return mtd.invoke(bean, argList);
	}
}
