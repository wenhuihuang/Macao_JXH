package com.fg.factory;

import java.sql.Connection;

public class ConnectionContext {
	private ConnectionContext(){}
	//单例模式
	private static ConnectionContext instance = new ConnectionContext();
	public static ConnectionContext getInstance() {
		return instance;
	}
	
	private ThreadLocal<Connection> connectionThread = new ThreadLocal<>();
	
	/**
	 * 利用ThreadLocal控制获取同一个Connection
	 * 这样可以多个dao同用一个Connection
	 * 解决事物问题，并且更好地使用资源
	 * @param conn 将Connection加入Connection
	 */
	public void addConnection(Connection conn){
		connectionThread.set(conn);
	}
	
	/**
	 * 利用ThreadLocal获取Connection
	 * @return 返回Connection
	 */
	public Connection getConnection(){
		return connectionThread.get();
	}
	
	/**
	 * 清理ThreadLoacal的值
	 */
	public void removeConnection(){
		connectionThread.remove();
	}
	
	
}
