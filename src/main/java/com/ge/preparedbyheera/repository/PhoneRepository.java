package com.ge.preparedbyheera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ge.preparedbyheera.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
