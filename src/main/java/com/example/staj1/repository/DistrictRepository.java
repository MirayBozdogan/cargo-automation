package com.example.staj1.repository;

import com.example.staj1.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    boolean existsByNameIgnoreCaseAndCityId(String name, Integer cityId);

    boolean existsByNameIgnoreCaseAndCityIdAndIdNot(
            String name,
            Integer cityId,
            Integer id
    );

    List<District> findByCityId(Integer cityId);
}