package com.tsfn.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.tsfn.model.Company;

public interface CompanyDAOIFC {

	void addCompany(Company company) throws Exception;

	void updateCompany(Company company) throws Exception;

	void deleteCompany(int companyID) throws Exception;

	ArrayList<Company> getAllCompanies() throws Exception;

	Optional<Company> getOneCompany(int companyID) throws Exception;

	boolean isCompanyExists(String email, String password) throws Exception;
}