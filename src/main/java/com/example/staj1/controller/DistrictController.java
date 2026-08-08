package com.example.staj1.controller;

import com.example.staj1.Dto.DistrictRequest;
import com.example.staj1.model.District;
import com.example.staj1.service.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    public final DistrictService districtService;

    public DistrictController (DistrictService districtService){
        this.districtService=districtService;
    }

    @PostMapping
    public District saveDistrict(@RequestBody DistrictRequest request) {
        return districtService.saveDistrict(request);
    }

    @GetMapping("")
    public List<District> get(){
        return districtService.get();
    }


}
