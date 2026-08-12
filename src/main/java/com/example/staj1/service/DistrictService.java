package com.example.staj1.service;

import com.example.staj1.Dto.DistrictRequest;
import com.example.staj1.exception.GlobalExceptionHandler;
import com.example.staj1.model.City;
import com.example.staj1.model.District;
import com.example.staj1.repository.AddressRepository;
import com.example.staj1.repository.CityRepository;
import com.example.staj1.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    public DistrictService(
            DistrictRepository districtRepository,
            CityRepository cityRepository,
            AddressRepository addressRepository) {

        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }

    public List<District> get() {
        return districtRepository.findAll();
    }

    public District getById(Integer id) {
        return districtRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("İlçe bulunamadı."));
    }

    public List<District> getByCityId(Integer cityId) {

        cityRepository.findById(cityId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));

        return districtRepository.findByCityId(cityId);
    }

    public District create(DistrictRequest request) {

        if (districtRepository.existsByNameIgnoreCaseAndCityId(
                request.getName(), request.getCityId())) {

            throw new GlobalExceptionHandler.DuplicateResourceException(
                    "Bu ilçe zaten kayıtlı."
            );
        }

        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));

        District district = new District();
        district.setName(request.getName());
        district.setCity(city);

        return districtRepository.save(district);
    }

    public District update(DistrictRequest request) {

        District district = districtRepository.findById(request.getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("İlçe bulunamadı."));

        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));


        if (districtRepository.existsByNameIgnoreCaseAndCityIdAndIdNot(
                request.getName(),
                request.getCityId(),
                request.getId())) {

            throw new GlobalExceptionHandler.DuplicateResourceException(
                    "Bu ilçe zaten kayıtlı."
            );
        }
        district.setName(request.getName());
        district.setCity(city);


        return districtRepository.save(district);
    }

    public void delete(Integer id) {

        District district = districtRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("İlçe bulunamadı."));

        if (addressRepository.existsByDistrictId(id)) {
            throw new IllegalArgumentException(
                    "Bu ilçe adres kayıtlarında kullanıldığı için silinemez."
            );
        }

        districtRepository.delete(district);
    }
}