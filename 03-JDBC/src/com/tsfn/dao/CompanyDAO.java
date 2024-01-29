package com.tsfn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.tsfn.db.ConnectionPool;
import com.tsfn.model.Company;

public class CompanyDAO implements DBDAOIFC, CompanyDAOIFC {

	private Connection connection;
	private ConnectionPool connectionPool;

	public CompanyDAO() throws Exception {
		connectionPool = ConnectionPool.createConnectionPoolInstance();
	}

	@Override
	public void addCompany(Company company) throws Exception {
		// TODO Auto-generated method stub
		Optional<Connection> opConnection = getConn();
		try {
			connection = opConnection.get();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into companies(name,email,password) values (?,?,?)");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("* Company Added *");
		} catch (SQLException e) {
			throw new Exception("Exception in addCompany - " + e.getMessage());
		} finally {
			restoreConn(opConnection);
			if (connection != null) {
				// connection.close();
			}
		}

	}

	@Override
	public void updateCompany(Company company) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompany(int companyID) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Company> getAllCompanies() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Company> getOneCompany(int companyID) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isCompanyExists(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectQuery(String sqlSelect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Connection> getConn() throws Exception {
		if (connection == null) {
			connection = connectionPool.getConnection();
		}
		return Optional.ofNullable(connection);
	}

	@Override
	public void restoreConn(Optional<Connection> connection) throws Exception {
		if (connection.isPresent()) {
			this.connection = connection.get();
			connectionPool.restoreConnection(connection.get());
		} else {
			throw new Exception("Connection is null");
		}

	}

}
