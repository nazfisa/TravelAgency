package com.agency.agency.controller;

import com.agency.agency.dto.LocationDto;
//import com.agency.agency.dto.StatusDto;
import com.agency.agency.dto.StatusDto;
import com.agency.agency.entity.Location;
import com.agency.agency.service.LocationService;
import com.agency.agency.service.StatusService;
import com.agency.agency.utils.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//import com.agency.agency.utils.ModelMapperUtil;

/**
 * @author : Name
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Controller
@RequestMapping("")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {
    @Autowired
    private final ModelMapperUtil modelMapperUtil;
    private final StatusService statusService;
    private final LocationService locationService;
    @GetMapping("/")
    public String home(Model model){
//        List<Location> locations = locationService.findAll();
        List<StatusDto>statusDtos = modelMapperUtil.getRequestedDtoList(statusService.findAll(), StatusDto.class);
        model.addAttribute("statuses", statusDtos);
//        List<LocationDto>locationDtos = modelMapperUtil.getRequestedDtoList(locationService.findAll(), LocationDto.class);
//        model.addAttribute("locations", locationDtos);
        return "index";
    }
}
