package ru.msk0.tt.service;

import java.util.List;

import ru.msk0.tt.domain.Employee;

public interface EmployeeService {
	public void saveEmployee (Employee emp);
	public List<Employee> employeeList();
	public List<Employee> findEmpByName(String name);
	public Employee retrieveEmp(Integer id); 
	public void removeEmployee(Integer id);
}
