package ru.msk0.tt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import ru.msk0.tt.dao.EmployeeDAO;
import ru.msk0.tt.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO empDAO;
	
	@Transactional
	public void saveEmployee(Employee emp) {
		empDAO.saveEmployee(emp);// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		return empDAO.employeeList();
	}

	@Transactional
	public List<Employee> findEmpByName(String name) {
		// TODO Auto-generated method stub
		return empDAO.findEmpByName(name);
	}

	@Transactional
	public Employee retrieveEmp(Integer id) {
		// TODO Auto-generated method stub
		return empDAO.retrieveEmp(id);
	}

	@Transactional
	public void removeEmployee(Integer id) {
		empDAO.removeEmployee(id);// TODO Auto-generated method stub
		
	}

}
