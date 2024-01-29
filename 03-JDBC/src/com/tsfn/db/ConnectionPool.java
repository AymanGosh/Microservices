package com.tsfn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConnectionPool {

	private Set<Connection> connections = new LinkedHashSet<Connection>(10);// Maintain order of entry and exit
	private static ConnectionPool instance;

	// Old way : DB details
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3307/test";
	private String user = "root";
	private String password = "1234";

	private ConnectionPool() throws Exception {
		try {
			Connection conn = createConnection();
			connections.add(conn);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new Exception("Exception in connection pool" + ex.getMessage());
		}
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	public synchronized static ConnectionPool createConnectionPoolInstance() throws Exception {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public synchronized Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			if (connections.isEmpty()) { // or while
				wait();
			}
			Iterator<Connection> it = connections.iterator();
			conn = it.next();
			it.remove();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Restore interrupted status
			throw new Exception("Exception in DBConnection - " + e.getMessage());
		}
		return conn;
	}

	public synchronized void restoreConnection(Connection connection) throws Exception {
		if (connections.size() < 10) {
			if (connection != null) {
				connections.add(connection);
				notify();// if we want to use notifyAll so we have to delete the synchronized in
							// Connection method
			} else {
				try {
					// this may happen if for example here is error in connection
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, password);
					connections.add(connection);
					notify();
				} catch (ClassNotFoundException | SQLException e) {
					throw new Exception("Exception in DBConnection - " + e.getMessage());
				}
			}
		}
	}

}
