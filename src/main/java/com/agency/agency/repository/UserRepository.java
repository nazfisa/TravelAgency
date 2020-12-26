package com.agency.agency.repository;

import com.agency.agency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    long deleteById(long id);
}
