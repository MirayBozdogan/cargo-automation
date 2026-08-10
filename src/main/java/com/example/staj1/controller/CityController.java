package com.example.staj1.controller;

import com.example.staj1.Dto.CityRequest;
import com.example.staj1.model.City;
import com.example.staj1.service.CityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    public CityService cityService;

    public CityController(CityService cityService){
        this.cityService=cityService;
    }

    @GetMapping("")
    public List<City> get(){
        return cityService.get();
    }

    // Detay
    @GetMapping("{id}")
    public City getById(@PathVariable Integer id){
        return cityService.getById(id);}

    @PostMapping
    public City create(@RequestBody @Valid CityRequest request) {
        return cityService.create(request);
    }

    // Güncelle servisi
    @PutMapping("")
    public City update(@RequestBody @Valid CityRequest request){
        return cityService.update(request);
    }

    // Sil Servisi
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
    cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
