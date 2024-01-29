package com.tsfn.facade;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.tsfn.dao.CompanyDAO;
import com.tsfn.model.Company;

public class CompanyFacade {
	private CompanyDAO companyDAO;

	public CompanyFacade() throws Exception {
		this.companyDAO = new CompanyDAO(); // Harder Dependency
	}

	public boolean isCompanyExists(String email, String password) throws Exception {
		return companyDAO.isCompanyExists(email, password);
	}

	public void addCompany(Company company) throws Exception {
		companyDAO.addCompany(company);
	}

	public void updateCompany(Company company) throws Exception {
		companyDAO.updateCompany(company);
	}

	public void deleteCompany(int companyId) throws Exception {
		companyDAO.deleteCompany(companyId);
	}

	public List<Company> getAllCompanies() throws Exception {
		return companyDAO.getAllCompanies();
	}

	public Optional<Company> getOneCompany(int companyId) throws Exception {
		return companyDAO.getOneCompany(companyId);
	}

	public synchronized void executeWithConnection(ConnectionTask task) throws Exception {
		try {
			Optional<Connection> connectionOptional = companyDAO.getConn();
			if (connectionOptional.isPresent()) {
				Connection connection = connectionOptional.get();
				try {
					task.execute(connection);
				} finally {
					companyDAO.restoreConn(Optional.of(connection));
				}
			}
		} catch (Exception e) {
			throw new Exception("Exception in excuteWithConnection - " + e.getMessage());
		}
	}

	@FunctionalInterface
	public interface ConnectionTask {
		void execute(Connection connection) throws Exception;
	}

}