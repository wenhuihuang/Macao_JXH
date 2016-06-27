package com.fg.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	/**
	 * 获取第一个泛型中的类型的类
	 * @param clazz
	 * @return
	 */
	public static Class getReflectionClazz(Class clazz){
		//返回第一个泛型类型
		return getReflectionClazzes(clazz, 0);
	}
	
	/**
	 * 获取泛型中的类型的所有类
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class getReflectionClazzes(Class clazz,int index){
		//获取泛型中的类
		Type type = clazz.getGenericSuperclass();
		
		//如果类型不为泛型参数
		if(!(type instanceof ParameterizedType)){
			return Object.class;
		}
		
		//获取所有泛型参数
		Type [] params = ((ParameterizedType)type).getActualTypeArguments();
		
		//如果获取不到泛型参数
		if(params==null){
			return Object.class;
		}
		
		//如果当前传入的索引超出参数个数
		if(index >= params.length || index < 0){
			return Object.class;
		}
		
		//如果索引指定的泛型能强转Class
		if(!(params[index] instanceof Class)){
			return Object.class;
		}
		
		return (Class) params[index];
	}
}
