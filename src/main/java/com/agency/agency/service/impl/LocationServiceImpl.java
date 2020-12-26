package com.agency.agency.service.impl;

import com.agency.agency.entity.Location;
import com.agency.agency.exception.exceptions.ResourceNotFoundException;
import com.agency.agency.repository.LocationRepository;
import com.agency.agency.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        Optional<Location> result = locationRepository.findById(id);
        Location location = null;
        if (result.isPresent()) {
            location = result.get();
        } else {
            throw new ResourceNotFoundException("Location not found with id: "+ id);
        }
        return location;
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);

    }

    @Override
    public void deleteById(Long id) {
        Location location = this.findById(id);
        location.setDeleted(true);
        this.save(location);
    }
}
