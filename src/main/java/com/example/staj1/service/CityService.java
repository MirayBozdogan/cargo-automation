package com.example.staj1.service;

import com.example.staj1.Dto.CityRequest;
import com.example.staj1.exception.GlobalExceptionHandler;
import com.example.staj1.model.City;
import com.example.staj1.repository.AddressRepository;
import com.example.staj1.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    public CityService(
            CityRepository cityRepository,
            AddressRepository addressRepository) {
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }

    public List<City> get() {
        return cityRepository.findAll();
    }

    public City getById(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));
    }

    public City create(CityRequest request) {
        // Dana önce aynı isimde bir il var mı ?
        if (cityRepository.existsByName(request.getName()))
            throw new GlobalExceptionHandler.DuplicateResourceException("Bu şehir zaten kayıtlı.");

        City city = new City();
        city.setName(request.getName());
        return cityRepository.save(city);
    }

    public City update(CityRequest request) {
        // Bu city var mı ?
        City city = cityRepository.findById(request.getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));

        // Dana önce aynı isimde bir il var mı kendisi hariç ?
        if (cityRepository.existsByName(request.getName()))
            throw new GlobalExceptionHandler.DuplicateResourceException("Bu şehir zaten kayıtlı.");

        city.setName(request.getName());
        return cityRepository.save(city);
    }

    public void delete(Integer id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));

        if (addressRepository.existsByCityId(id)) {
            throw new IllegalArgumentException(
                    "Bu şehir adres kayıtlarında kullanıldığı için silinemez."
            );
        }
        cityRepository.delete(city);
    }
}