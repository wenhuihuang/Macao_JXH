package com.fg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.jxh.vo.Retarded;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

public class ToolsUtils {
	
	public static String projectName = null;
	
	/**
	 * 获取项目名
	 * @return
	 */
	public static String getProjectName(){
		String projectname = System.getProperty("user.dir");
		String pn = projectname.substring(projectname.lastIndexOf('\\')+1,projectname.length());
		return pn;
	}
	
	
	/**
	 * 判断对象是否为空
	 * @param obj 判断的对象
	 * @return 如果为空返回true，如果不为空返回false
	 */
	public static boolean checkIsNull(Object obj){
		return obj==null||"".equals(obj.toString())||"null".equals(obj.toString())?true:false;
	}
	
	
	/**
	 * 获取当前函数的函数名
	 * @return
	 */
	public static String getCurrentMethodName() {  
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];  
        String methodName = e.getMethodName();  
        System.out.println(methodName);
        return methodName;  
    } 
	
	
	
	/**
	 * 将日期转为指定格式字符串
	 * @param format
	 * @param oriDate
	 * @return
	 * @throws ParseException 
	 */
	public static String getDateStringByFormat(Object oriDate,String oriFormat,String newFormat) throws ParseException{
		oriFormat = oriFormat==null||"".equals(oriFormat)?"yyyy-MM-dd HH:mm:ss":oriFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(oriFormat);
		String result = sdf.format(oriDate);
		if(newFormat!=null&&!"".equals(newFormat)){
			sdf = new SimpleDateFormat(newFormat);
			result = sdf.format(sdf.parse(result));
		}
		
		sdf = null;
		return result;
	}
	
	/**
	 * 通过JSON获取List
	 * @param clz
	 * @param json
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> List<T> getListByJSON(Class<T> clz,String json) throws InstantiationException, IllegalAccessException{
		if(json==null||"".equals(json)){
			return null;
		}
		json = json.trim();
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
		JSONArray array = JSONArray.fromObject(json);
		List<T> rs = JSONArray.toList(array, clz.newInstance(), new JsonConfig());
		return rs;
	}
	
	
	@Test
	public void test() throws ParseException, InstantiationException, IllegalAccessException{
		String json = "[{\"assessDate\":\"2016-01-28 00:00:00\",\"custId\":\"1\",\"hasRetardedReport\":0,\"note\":\"qwerqwer\",\"retardedDegree\":1,\"retardedID\":\"3\",\"retardedReportSource\":1,\"retardedType\":7}]";
		System.out.println(getListByJSON(Retarded.class, json));
		
	}
	
}
