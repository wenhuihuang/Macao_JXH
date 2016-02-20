package com.fg.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.dbutils.QueryLoader;

public class SQLLoader {
	
	private static QueryLoader loader = QueryLoader.instance();
	
	/**
	 * 根据Key读取SQL语句
	 * @param path
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String loadSqlByKey(String path,String key) throws IOException{
		return loadMapByPath(path).get(key);
	}
	
	
	/**
	 * 根据Key读取文档
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> loadMapByPath(String path) throws IOException{
		return loader.load(path);
	}
	
	
	 
	
}
