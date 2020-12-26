package com.agency.agency.service;

import com.agency.agency.dto.StatusDto;
import com.agency.agency.entity.Status;
import com.agency.agency.entity.User;

import java.util.List;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
public interface StatusService {
    List<Status> findAll();

    Status findById(Long id);

    void save(Status status);

    void deleteById(Long id);

    User getUserDetails();

    List<Status> getMyStatuses();

    String handleError(StatusDto statusDto);

    List<Status> getMyFinedPost();


}
