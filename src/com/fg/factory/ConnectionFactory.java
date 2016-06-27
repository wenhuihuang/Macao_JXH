package com.fg.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	// 数据源
	private static DataSource ds = null;

	// 数据库连接池应只被初始化一次.
	static {
		try {
			ds = getDataSource();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	
	

	/**
	 * 根据数据库开关获取数据源
	 * @return
	 * @throws Exception
	 */
	private static DataSource getDataSource() throws Exception {
		// 根据数据库开关获取数据源

		String dbSwitch = "c3p0";

		try {
			InputStream isSwitch = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("connswitch.properties");

			Properties prop = new Properties();
			prop.load(isSwitch);
			dbSwitch = prop.getProperty("dbswitch");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 返回数据源
		switch (dbSwitch) {
		case "c3p0":
			return new ComboPooledDataSource("c3p0conn");
		case "dbcp":
			InputStream dbcpIS = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbcp.properties");
			Properties connProp = new Properties();
			connProp.load(dbcpIS);
			return BasicDataSourceFactory.createDataSource(connProp);
		default:
			return null;
		}

	}

	/**
	 * 获取连接
	 * 
	 * @return 返回连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * 关闭连接
	 * @param conn 连接
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
