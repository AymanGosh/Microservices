package com.tsfn.runner;

import com.tsfn.facade.CompanyFacade;
import com.tsfn.model.Company;

public class Runner {

	public static void main(String[] args) {
		try {
			CompanyFacade companyFacade = new CompanyFacade();

			Thread addCompanyThread1 = new Thread(() -> {
				try {
					companyFacade.addCompany(new Company("Company1", "email1@example.com", "password1"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			Thread addCompanyThread2 = new Thread(() -> {
				try {
					companyFacade.addCompany(new Company("Company2", "email2@example.com", "password2"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			addCompanyThread1.start();
			addCompanyThread2.start();

			// Wait for the threads to finish
			try {
				addCompanyThread1.join();
				addCompanyThread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Example Executing tasks with connection concurently
			Thread executeThread1 = new Thread(() -> {
				try {
					companyFacade.executeWithConnection(Connection -> {
						// Perform database using the provided connection
						// ...
					});
				} catch (Exception e) {
					// TODO: handle exception
				}
			});

			Thread executeThread2 = new Thread(() -> {
				try {
					companyFacade.executeWithConnection(Connection -> {
						// Perform database using the provided connection
						// ...
					});
				} catch (Exception e) {
					// TODO: handle exception
				}
			});
			executeThread1.start();
			executeThread2.start();

			// Wait for the threads to finish
			try {
				executeThread1.join();
				executeThread2.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
