package com.hl.loan.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoField {
	String mergeToField() default ""; //在执行mergeToModel方法时，要合并到哪个model里面的属性，不写根据当前属性名去找。
	boolean ignoreAtMergeModel() default false; //在执行mergeToModel方法时是否忽略该属性
	boolean mergeNullValue() default false; //在执行mergeToModel方法如果dto里的该字段为null值时，是否把null值复制到model.
	String buildFromField() default ""; //在执行buildDto方法时，model里哪个属性要复制到dto的当前字段
	boolean ignoreAtBuildDto() default false; //在执行buildDto方法时是否忽略该属性
}
