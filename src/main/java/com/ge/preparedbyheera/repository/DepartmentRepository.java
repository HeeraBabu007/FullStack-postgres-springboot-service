package com.ge.preparedbyheera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ge.preparedbyheera.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
