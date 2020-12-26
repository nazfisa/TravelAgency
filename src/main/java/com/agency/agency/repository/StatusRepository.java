package com.agency.agency.repository;

import com.agency.agency.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAllByIsPrivateFalse();
    List<Status> findAllByUserIdAndIsPined(long id, boolean status);

}
