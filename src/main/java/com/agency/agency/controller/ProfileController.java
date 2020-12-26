package com.agency.agency.controller;

//import com.agency.agency.dto.StatusDto;
//import com.agency.agency.entity.Status;
import com.agency.agency.dto.LocationDto;
import com.agency.agency.dto.StatusDto;
import com.agency.agency.dto.UserRegistrationDto;
import com.agency.agency.entity.Status;
import com.agency.agency.service.LocationService;
import com.agency.agency.service.StatusService;
import com.agency.agency.utils.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/26/2020, Sat
 **/
@Controller
@RequestMapping("/profiles")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileController {
    @Autowired
    private final ModelMapperUtil modelMapperUtil;
    private final StatusService statusService;
    private final LocationService locationService;

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("myStatuses",  modelMapperUtil.getRequestedDtoList(statusService.getMyStatuses(), StatusDto.class));
        UserRegistrationDto userRegistrationDto = modelMapperUtil.getRequestedDto(statusService.getUserDetails(), UserRegistrationDto.class);
        model.addAttribute("user", userRegistrationDto);
        StatusDto statusDto = modelMapperUtil.getRequestedDto(new StatusDto(), StatusDto.class);
        model.addAttribute("status", statusDto);
        model.addAttribute("locations",  modelMapperUtil.getRequestedDtoList(locationService.findAll(), LocationDto.class));
    }
    @GetMapping("/status")
    public String addStatus(Model model){
        boolean pinnedPost = false;
        if(statusService.getMyFinedPost().size()>0)
            pinnedPost = true;
        model.addAttribute("pinnedPost", pinnedPost);
        model.addAttribute("myPinnedPost", modelMapperUtil.getRequestedDtoList(statusService.getMyFinedPost(), StatusDto.class));
        model.addAttribute("errorMessage", false);
        return "profile";
    }
    @GetMapping("/update")
    public String update(@RequestParam("statusId") long id, Model model) {
//        Status status = statusService.findById(id);
        model.addAttribute("status", modelMapperUtil.getRequestedDto(statusService.findById(id), StatusDto.class));
        return "status_update_form";
    }

    @PostMapping("/save")
    public String save(@Valid StatusDto statusDto,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "profile";
        }
//        if(!statusService.handleError(statusDto).isEmpty()){
//            String a = statusService.handleError(statusDto);
//            System.out.println(a);
//            model.addAttribute("errorMessage", statusService.handleError(statusDto));
//           return "redirect:/profiles/status";
//        }

        statusService.save(modelMapperUtil.getRequestedDto(statusDto, Status.class));
        return "redirect:/profiles/status";

    }
    @GetMapping("/pinned")
    public String getMyPinnedPost(@RequestParam("statusId") long id, Model model){
        Status status = statusService.findById(id);
        status.setPined(true);
        statusService.save(status);
        return "redirect:/profiles/status";
    }

    @GetMapping("/unPinned")
    public String getMyUnPinnedPost(@RequestParam("statusId") long id, Model model){
        Status status = statusService.findById(id);
        status.setPined(false);
        statusService.save(status);
        return "redirect:/profiles/status";
    }


}
