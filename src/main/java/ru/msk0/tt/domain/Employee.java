package ru.msk0.tt.domain;

import javax.persistence.*;
@NamedQueries({
	@NamedQuery(name = Employee.NamedQuery.EMPLOYEE_FIND_ALL, query = "from Employee"),
	@NamedQuery(name = Employee.NamedQuery.EMPLOYEE_FIND_BY_ID, query = "from Employee where id = :id") })
@NamedNativeQueries({ 
@NamedNativeQuery(name = Employee.NamedQuery.EMPLOYEE_FIND_BY_NAME, query = "select * from employee where last_name like :name", resultClass = Employee.class) })

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "second_name")
    private String secondName;
    
    @Column(name = "age")
    private Integer age;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "experience")
    private Float experience;

    @Column(name = "description")
    private String description;
   

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getExperience() {
        return experience;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public static class NamedQuery {
		public static final String EMPLOYEE_FIND_ALL = "Employee.findAll";
		public static final String EMPLOYEE_FIND_BY_ID = "Employee.findById";
		public static final String EMPLOYEE_FIND_BY_NAME = "Employee.findByName";
	}
}
