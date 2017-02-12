package com.fg.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONResultUtils {

	/**
	 * 写出JSONObjectMessage
	 * @param response
	 * @param code
	 * @param msg
	 * @param obj
	 * @throws IOException
	 */
	public static void writeJsonObjectMessage(HttpServletResponse response,int code,String msg,Object obj) throws IOException{
		String jsonData = obj==null?"null":JSONObject.fromObject(obj).toString();
		PrintWriter out = response.getWriter();
		out.write("{\"code\":"+code+",\"msg\":\""+msg+"\",\"jsonData\":"+jsonData+"}");
		out.flush();
		out.close();
	}
	
	/**
	 * 写出JSONArrayMessage
	 * @param response
	 * @param code
	 * @param msg
	 * @param objs
	 * @param page
	 * @throws IOException
	 */
	public static void writeJsonArrayMessage(HttpServletResponse response,int code,String msg,List<?> objs,PageUtils page) throws IOException{
		String jsonDatas = objs==null?"\"\"":JSONArray.fromObject(objs).toString();
		
		//判断是否需要分页，如果需要分页，返回相关信息
		String pageStr = "";
		if(page!=null){
			pageStr = ",\"totalPage\":"+page.getTotalPage()+",\"currentPage\":"+page.getCurrentPage()+",\"rowCount\":"+page.getRowCount();
		}
		
		
		PrintWriter out = response.getWriter();
		out.write("{\"code\":"+code+",\"msg\":\""+msg+"\",\"jsonDatas\":"+jsonDatas+pageStr+"}");
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * 写出Object类型错误信息
	 * @param response
	 * @param e
	 * @throws IOException
	 */
	public static void writeJsonObjectErrorMessage(HttpServletResponse response,Exception e) throws IOException{
		JSONResultUtils.writeJsonObjectMessage(response, -1, "获取数据失败，请重试，错误提示:\n"+e.getMessage(), null);
	}
	
	/**
	 * 写出数组类型错误信息
	 * @param e
	 * @throws IOException 
	 */
	public static void writeJsonArrayErrorMessage(HttpServletResponse response,Exception e) throws IOException{
		JSONResultUtils.writeJsonArrayMessage(response, -1, "获取数据失败，请重试，错误提示:\n"+e.getMessage(), null,null);
	}
}
