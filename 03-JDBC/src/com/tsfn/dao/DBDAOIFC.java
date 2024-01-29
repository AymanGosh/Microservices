package com.tsfn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Optional;

public interface DBDAOIFC {

	ResultSet selectQuery(String sqlSelect) throws Exception;

	Optional<Connection> getConn() throws Exception;

	void restoreConn(Optional<Connection> connection) throws Exception;
}
