package com.tsfn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;
import com.tsfn.beans.Task;
import com.tsfn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepo.findAll();
	}

	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	public List<Employee> getEmployeesByName(String name) {
		return employeeRepo.findEmployeesByName(name);
	}

	public List<Employee> getEmployeesBySalaryBetween(double from, double to) {
		return employeeRepo.findEmployeeBetweenSalary(from, to);
	}

	public List<Employee> getEmployeesBySalaryGreaterThan(double salary) {
		return employeeRepo.findEmployeesBySalaryGreaterThan(salary);
	}

	public List<Employee> getEmployeesByGenderNot(Gender gender) {
		return employeeRepo.findEmployeesByGenderNot(gender);
	}

	public List<Employee> getEmployeesByTaskId(Task task) {
		return employeeRepo.findEmployeesByTasks_Id(task.getId());
	}

	public Optional<Employee> getFirstEmployeeWithName(String name) {
		return employeeRepo.findFirstEmployeeByName(name);
	}
}