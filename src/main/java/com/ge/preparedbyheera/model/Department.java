/**
 * 
 */
package com.ge.preparedbyheera.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Heera Babu
 *
 */
@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	String name;
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="department_id", referencedColumnName = "id")
	List<Employee> employees;
	
	public Department() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}