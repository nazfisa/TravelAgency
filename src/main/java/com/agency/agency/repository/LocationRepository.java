package com.agency.agency.repository;

import com.agency.agency.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
