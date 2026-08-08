package com.example.staj1.service;

import com.example.staj1.Dto.DistrictRequest;
import com.example.staj1.model.City;
import com.example.staj1.model.District;
import com.example.staj1.repository.CityRepository;
import com.example.staj1.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;

    public DistrictService(DistrictRepository districtRepository,
                           CityRepository cityRepository) {
        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
    }

    public List<District> get() {
        return districtRepository.findAll();
    }

    public District saveDistrict(DistrictRequest request) {

        City city = cityRepository.findById(request.getCityId())
                .orElseThrow();

        District district = new District();
        district.setName(request.getName());
        district.setCity(city);

        return districtRepository.save(district);
    }
}