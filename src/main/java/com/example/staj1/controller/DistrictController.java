package com.example.staj1.controller;

import com.example.staj1.Dto.DistrictRequest;
import com.example.staj1.model.District;
import com.example.staj1.service.DistrictService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    public final DistrictService districtService;

    public DistrictController (DistrictService districtService){
        this.districtService=districtService;
    }

    @GetMapping("")
    public List<District> get(){
        return districtService.get();
    }

    @GetMapping("{id}")
    public District getById(@PathVariable Integer id){
        return districtService.getById(id);
    }

    @PostMapping
    public District create(@RequestBody @Valid DistrictRequest request) {
        return districtService.create(request);
    }
    @PutMapping("")
    public District update(@RequestBody @Valid DistrictRequest request){
        return districtService.update(request);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        districtService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
