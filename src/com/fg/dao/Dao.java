package com.fg.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface Dao<T> {
	
	/**
	 * JDBC增删改查
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int updateByJDBC(String sql,Object...params) throws SQLException;
	
	
	Map<Integer, Object> callProcedureForSingleLine(String sql,Map<Integer,Integer> ouputIndexAndType, Object...params) throws SQLException ;
	
	/**
	 * 启旭自定义主键获取方式
	 * @param tableName
	 * @param corpId
	 * @param keyLen
	 * @return
	 * @throws SQLException 
	 */
	public String getPrimaryKey(String tableName,String corpId,int keyLen) throws SQLException;
	
	
	/**
	 * 删改方法
	 * @param sql  Sql语句
	 * @param params  动态参数
	 * @return 返回成功标识
	 * @throws SQLException 
	 */
	int update(String sql, Object... params) throws SQLException;
	
	/**
	 * 更新一批对象
	 * @param sql SQL语句
	 * @param params 二维参数
	 * @return 返回成功标志
	 * @throws SQLException 
	 */
	int[] updateBatch(String sql,Object[][] params) throws SQLException;
	
	
	/**
	 * 批量新增 List
	 * @param sql
	 * @param list
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	int[] insertBatchByList(String sql,List<T> list) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException;
	/**
	 * 批量更新List
	 * @param sql
	 * @param list
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	int[] updateBatchByList(String sql,List<T> list) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException;
	
	
	/**
	 * 返回一个对象记录
	 * @param sql Sql语句
	 * @param params 参数
	 * @return 返回对象
	 * @throws SQLException 
	 */
	T findForObject(String sql,Object ...params) throws SQLException;
	
	
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	<E> E findElement(String sql,Object ... params) throws SQLException;
	
	
	/**
	 * 返回多个记录
	 * @param sql sql语句
	 * @param params 参数
	 * @return 返回对象集合
	 * @throws SQLException 
	 */
	List<T> findForList(String sql,Object ... params) throws SQLException;
	
	
	/**
	 * 返回键值对
	 * @param sql sql语句
	 * @param params 参数
	 * @return 返回一行记录 以键值对的形式获取数值
	 * @throws SQLException 
	 */
	Map<String,Object> findForMap(String sql,Object ... params) throws SQLException;
	
	
	/**
	 * 返回键值对集合
	 * @param sql Sql语句
	 * @param params  参数
	 * @return 返回多行记录，以键值对的形式获取数值
	 * @throws SQLException 
	 */
	List<Map<String,Object>> findForListMap(String sql,Object...params) throws SQLException;
	
	
	/**
	 * 返回对应Key的SQL语句
	 * @param sqlKey
	 * @return
	 * @throws IOException 
	 */
	String getSqlByPropKey(String sqlKey) throws IOException;
	
}
