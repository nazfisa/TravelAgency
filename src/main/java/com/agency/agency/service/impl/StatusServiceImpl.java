package com.agency.agency.service.impl;

import com.agency.agency.entity.Status;
import com.agency.agency.entity.User;
import com.agency.agency.exception.exceptions.ResourceNotFoundException;
import com.agency.agency.repository.StatusRepository;
import com.agency.agency.repository.UserRepository;
import com.agency.agency.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        Optional<Status> result = statusRepository.findById(id);
        Status status = null;
        if (result.isPresent()) {
            status = result.get();
        } else {
            throw new ResourceNotFoundException("Status not found with id: " + id);
        }
        return status;
    }

    @Override
    public void save(Status status) {
        User user =this.getUserDetails();
        status.setUser(user);
        statusRepository.save(status);
    }

    @Override
    public void deleteById(Long id) {
        Status status = this.findById(id);
        status.setDeleted(true);
        this.save(status);
    }

    @Override
    public User getUserDetails() {

        return userRepository.findByEmail(getUserName());

    }

    @Override
    public List<Status> getMyStatuses() {
        User user = this.getUserDetails();
        return statusRepository.findAllByUserId(user.getId());
    }


    public String getUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = "";
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}
