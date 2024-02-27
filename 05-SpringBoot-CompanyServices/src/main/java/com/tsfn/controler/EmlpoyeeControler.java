package com.tsfn.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.beans.Employee;
import com.tsfn.services.EmployeeService;

@RestController
public class EmlpoyeeControler {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/employees/add", consumes = "application/json")
	public void createEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@GetMapping(value = "/employees/getall")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(value = "/employee")
	public Optional<Employee> getEmployee(@RequestParam("id") int id) {
		return employeeService.getEmployeeById(id);
	}

//
//	// http://www.localhost:8080/departmetns/department/1 pathVariable
//	// http://www.localhost:8080/departmetns/department?id=1&name="R&D" queryParam
//	@GetMapping(value = "/departments/department")
//	public Optional<Department> getDepartmentByIdByQueryPatram(@RequestParam("id") int id) {
//		return departmentService.getDepartment(id);
//	}
//
//	@GetMapping(value = "/departments/department/{id}")
//	public Optional<Department> getDepartmentByIdByPathVar(@PathVariable int id) {
//		return departmentService.getDepartment(id);
//	}
//
//	@PostMapping(value = "/departments/add", consumes = "application/json")
//	public void createDepartment(@RequestBody Department department) {
//		departmentService.createDepartment(department);
//	}
//
//	// http://www.localhost:8080/departmetns/?id=1
//	@DeleteMapping(value = "/departments/delete")
//	public void deleteDepartmentByIdByQueryParam(@RequestParam("id") int id) {
//		departmentService.deleteDepartment(id);
//	}
//
//	@PutMapping(value = "/departments", consumes = "application/json")
//	public void updateDepartment(@RequestBody Department department) {
//		departmentService.updateDepartment(department);
//	}
}