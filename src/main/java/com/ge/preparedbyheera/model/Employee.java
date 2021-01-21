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
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	
	String name;
	int age;
	String address;

	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="employee_id", referencedColumnName = "id")
	List<Phone> phone;
	public Employee() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
}
