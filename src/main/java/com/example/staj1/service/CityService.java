package com.example.staj1.service;

import com.example.staj1.Dto.CityRequest;
import com.example.staj1.model.City;
import com.example.staj1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> get() {
        return cityRepository.findAll();
    }

    public City save(CityRequest request) {

        City city = new City();
        city.setName(request.getName());

        return cityRepository.save(city);
    }
}