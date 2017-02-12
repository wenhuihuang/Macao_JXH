package com.fg.ligerui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fg.utils.PageUtils;

import net.sf.json.JSONArray;

public class LigerUITools  {
	
	
	public static <T> void writeGridJson(PageUtils<T> page,HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		String result = getGridJson(page);
		out.write(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 获取LigerUI
	 * @param page
	 * @return
	 */
	public static <T> String getGridJson(PageUtils<T> page){
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"Rows\":");
		
		if(page!=null){
			List<T> list = page.getList();
			sb.append(JSONArray.fromObject(list).toString());
			sb.append(",\"Total\":"+page.getRowCount());
		}else{
			sb.append(",\"Total\":"+0);
		}
		
		sb.append("}");
		
		return sb.toString();
	}
	
}
