package com.fg.daoImpl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fg.dao.Dao;
import com.fg.factory.ConnectionContext;
import com.fg.utils.ReflectionUtils;
import com.fg.utils.SQLLoader;
import com.fg.utils.ToolsUtils;

public abstract class DaoImpl<T> implements Dao<T> {

	private QueryRunner qr = new QueryRunner(true);

	protected Class<T> clazz;

	protected abstract String getSqlPropertiesPath();

	@SuppressWarnings("unchecked")
	public DaoImpl() {
		// TODO Auto-generated constructor stub
		clazz = ReflectionUtils.getReflectionClazz(this.getClass());
	}

	@Override
	public int updateByJDBC(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();

		PreparedStatement pstm = null;

		int row = 0;
		try {
			pstm = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);
				}
			}
			row = pstm.executeUpdate();

		} finally {
			if (pstm != null) {
				pstm.close();
			}
		}

		return row;
	}

	@Override
	public Map<Integer, Object> callProcedureForSingleLine(String sql, Map<Integer,Integer> ouputIndexAndType, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		CallableStatement cs = null;

		ResultSet rs = null;
		cs = conn.prepareCall(sql);
		// 设置输入参数
		for (int i = 0; i < params.length; i++) {
			
			cs.setObject(i + 1, params[i]);
		}
		
		for(Map.Entry<Integer, Integer> output : ouputIndexAndType.entrySet()){
			cs.registerOutParameter(output.getKey(), output.getValue());
		}
		
		
		cs.executeUpdate();
		
		for(Map.Entry<Integer, Integer> output : ouputIndexAndType.entrySet()){
			map.put(output.getKey(), cs.getObject(output.getKey())); 
		}
		
		return map;
	}

	
	/**
	 * 获取主键
	 */
	public String getPrimaryKey(String tableName,String corpId,int keyLen) throws SQLException{
		Map<Integer, Integer> output = new LinkedHashMap<>();
		output.put(4, Types.VARCHAR);
		Map<Integer,Object> resultMap = callProcedureForSingleLine("{call sp_GetKeyCode(?,?,?,?)}", output, tableName,corpId,keyLen);
		return resultMap.get(4).toString();
	}
	
	
	
	@Override
	public int update(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.update(conn, sql, params);
	}

	@Override
	public int[] updateBatch(String sql, Object[][] params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.batch(conn, sql, params);
	}
	
	@Override
	public int[] insertBatchByList(String sql, List<T> list) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		// TODO Auto-generated method stub
		Object[][] params = new Object[list.size()][];
		for(int i = 0;i<list.size();i++){
			params[i] = getInsertParams(sql, list.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	
	@Override
	public int[] updateBatchByList(String sql, List<T> list) throws SQLException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		// TODO Auto-generated method stub
		Object[][] params = new Object[list.size()][];
		for(int i = 0;i<list.size();i++){
			params[i] = getUpdateParams(sql, list.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	
	/**
	 * 判断是否所有sql都执行成功
	 * @param array
	 * @return
	 */
	protected int getflagByIntArray(int[] array){
		for (int i : array) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	

	@Override
	public T findForObject(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.query(conn, sql, new BeanHandler<>(clazz), params);
	}

	@Override
	public <E> E findElement(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.query(conn, sql, new ScalarHandler<E>(), params);
	}

	@Override
	public List<T> findForList(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.query(conn, sql, new BeanListHandler<>(clazz), params);
	}

	@Override
	public Map<String, Object> findForMap(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.query(conn, sql, new MapHandler(), params);
	}

	@Override
	public List<Map<String, Object>> findForListMap(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionContext.getInstance().getConnection();
		return qr.query(conn, sql, new MapListHandler(), params);
	}

	@Override
	public String getSqlByPropKey(String sqlKey) throws IOException {
		// TODO Auto-generated method stub
		String path = getSqlPropertiesPath();
		path = path == null || "".equals(path)
				? "/sqls/" + ToolsUtils.projectName + "/" + clazz.getSimpleName().toLowerCase() + ".properties" : path;
		return SQLLoader.loadSqlByKey(path, sqlKey);
	}

	/**
	 * 将sql转换未select count(1) from xxx
	 * 
	 * @param sql
	 * @return
	 */
	protected String getCountSql(String sql) {
		sql = sql.toUpperCase();
		sql = sql.substring(sql.lastIndexOf("FROM"), sql.length());
		sql = "SELECT COUNT(1) " + sql;
		return sql;
	}

	/**
	 * 获取insert 语句的字段
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException 
	 */
	protected Object[] getInsertParams(String sql, Object obj)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		List<Object> params = new ArrayList<Object>();
		// sql = sql.toUpperCase();
		String fieldsStr = sql.substring(sql.indexOf("(") + 1, sql.indexOf(")"));
		String[] fields = fieldsStr.split(",");

		Class clz = obj.getClass();

		for (String fieldText : fields) {
			fieldText = fieldText.trim();
			Field field = null;
			try {
				// 没有该属性
				field = clz.getDeclaredField(fieldText);
				field.setAccessible(true);
				params.add(getFieldVale(field, obj));
			} catch (NoSuchFieldException e) {
				// TODO: handle exception
				params.add(null);
				continue;
			}

		}

		return params.toArray();
	}

	/**
	 * 获取update语句的字段
	 * 
	 * @param sql
	 * @param cust
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws ParseException 
	 */
	protected Object[] getUpdateParams(String sql, Object obj)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();

		String fieldsStr = getFieldString(sql);

		String[] fields = fieldsStr.split(",");
		Class clz = obj.getClass();

		for (String fieldText : fields) {
			fieldText = fieldText.replace("=", "").replace("?", "").trim();
			Field field = null;
			try {
				// 没有该属性
				field = clz.getDeclaredField(fieldText);
				field.setAccessible(true);
				params.add(getFieldVale(field, obj));
			} catch (NoSuchFieldException e) {
				// TODO: handle exception
				params.add(null);
				continue;
			}
		}
		return params.toArray();
	}

	
	/**
	 * 根据字段获取值 由于有些特殊的类型 插入数据库有误，做特别处理
	 * @param field
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	private Object getFieldVale(Field field,Object obj) throws IllegalArgumentException, IllegalAccessException, ParseException{
		
		if(field.get(obj)==null){
			return null;
		}else if("java.util.Date".equals(field.get(obj).getClass().getName())){
			return ToolsUtils.getDateStringByFormat(field.get(obj), "yyyy-MM-dd HH:mm:ss", null);
		}else{
			return field.get(obj);
		}
	}
	
	/**
	 * 获取字段String类型
	 * 
	 * @param sql
	 * @return
	 */
	private String getFieldString(String sql) {
		if (sql.toUpperCase().indexOf("UPDATE") > -1) {
			// update语句
			String fields = sql.substring(sql.toUpperCase().indexOf("SET ") + 4, sql.toUpperCase().indexOf("WHERE"))
					.trim();

			fields += "," + sql.substring(sql.toUpperCase().indexOf("WHERE") + 5, sql.length());
			return fields;
		} else if (sql.toUpperCase().indexOf("INSERT") > -1) {
			// insert语句
			return sql.substring(sql.indexOf("(") + 1, sql.indexOf(")"));
		} else {
			return "";
		}
	}

}
