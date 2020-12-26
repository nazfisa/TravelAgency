package com.agency.agency.service;

import com.agency.agency.entity.Location;

import java.util.List;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
public interface LocationService {
    List<Location> findAll();

    Location findById(Long id);

    void save(Location location);

}
