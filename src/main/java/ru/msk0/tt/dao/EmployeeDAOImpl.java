package ru.msk0.tt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.msk0.tt.domain.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	
	public void saveEmployee(Employee emp) {
		sessionFactory.getCurrentSession().saveOrUpdate(emp);// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery( Employee.NamedQuery.EMPLOYEE_FIND_ALL ).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findEmpByName(String name) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery( Employee.NamedQuery.EMPLOYEE_FIND_BY_NAME );
        q.setString("name", "%" + name + "%");
        return (List<Employee>) q.list();
	}

	@Override
	public Employee retrieveEmp(Integer id) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery( Employee.NamedQuery.EMPLOYEE_FIND_BY_ID );
        q.setInteger("id", id);
        return (Employee) q.uniqueResult();
	}

	@Override
	public void removeEmployee(Integer id) {
		Employee emp = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, id);
        if (null != emp) {
            sessionFactory.getCurrentSession().delete(emp);
        }
		
	}

}
