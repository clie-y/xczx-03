package com.clie.controller;

import com.clie.domain.Resident;
import com.clie.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author： CleanLoamy
 * @date 2022/5/18
 */
@Controller
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @GetMapping("/getAllResident")
    @ResponseBody
    public List<Resident> showAllResident(){
        return residentService.selectAllResident();
    }

}
