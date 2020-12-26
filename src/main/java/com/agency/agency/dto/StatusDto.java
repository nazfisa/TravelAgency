package com.agency.agency.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/

@Data
public class StatusDto {
    private Long id;
    @NotEmpty
    private String content;

    private UserRegistrationDto user;
    private LocationDto location;

    private boolean isPined;

    private int isPrivate;

    public StatusDto() {
    }

}
