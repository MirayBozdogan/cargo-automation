package com.example.staj1.controller;

import com.example.staj1.Dto.CityRequest;
import com.example.staj1.model.City;
import com.example.staj1.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    public CityService cityService;

    public CityController(CityService cityService){
        this.cityService=cityService;
    }

    @PostMapping
    public City save(@RequestBody CityRequest request) {
        return cityService.save(request);
    }

    @GetMapping("")
    public List<City> get(){
        return cityService.get();
    }
}
