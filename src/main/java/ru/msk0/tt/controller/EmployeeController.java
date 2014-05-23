package ru.msk0.tt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import ru.msk0.tt.domain.Employee;
import ru.msk0.tt.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empServ;
	
	@RequestMapping("/employee/index")
    public String listUsers(Map<String, Object> map) {

        map.put("employee", new Employee());
        map.put("findEmployee", new Employee());
        map.put("employeeList", empServ.employeeList());

        return "employee_list";
    }
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("employee") Employee emp, BindingResult result) {

        empServ.saveEmployee(emp);

        return "redirect:/employee/index";
    }
	@RequestMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {

        empServ.removeEmployee(employeeId);

        return "redirect:/employee/index";
    }
	
	@RequestMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp, BindingResult result) {

        empServ.saveEmployee(emp);

        return "redirect:/employee/edit/" + emp.getId();
    }
	
	@RequestMapping("/employee/edit/{employeeId}")
    public String editEmployee(@PathVariable("employeeId") Integer employeeId, Map<String, Object> map) {

        Employee emp = empServ.retrieveEmp(employeeId);
        map.put("employee", emp); 

        return "employee_edit";
    }
	
	@RequestMapping("/employee/find")
    public String findUsers(@ModelAttribute("findEmployee") Employee emp, BindingResult result, Map<String, Object> map) {

    	map.put("employeeList", empServ.findEmpByName( emp.getLastName() ) );
        map.put("employee", new Employee());

        return "employee_list";
    }
}
