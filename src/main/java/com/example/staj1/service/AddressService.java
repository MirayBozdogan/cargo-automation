package com.example.staj1.service;

import com.example.staj1.Dto.AddressRequest;
import com.example.staj1.model.Address;
import com.example.staj1.model.City;
import com.example.staj1.model.Customer;
import com.example.staj1.model.District;
import com.example.staj1.repository.AddressRepository;
import com.example.staj1.repository.CityRepository;
import com.example.staj1.repository.CustomerRepository;
import com.example.staj1.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;

    public AddressService(AddressRepository addressRepository,
                          CustomerRepository customerRepository,
                          CityRepository cityRepository,
                          DistrictRepository districtRepository) {

        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
    }

    public Address addAddress(AddressRequest request, Integer customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow();

        City city = cityRepository.findById(request.getCityId())
                .orElseThrow();

        District district = districtRepository.findById(request.getDistrictId())
                .orElseThrow();

        Address address = new Address();

        address.setCity(city);
        address.setDistrict(district);
        address.setNeighborhood(request.getNeighborhood());
        address.setBuildingNo(request.getBuildingNo());
        address.setApartmentNo(request.getApartmentNo());
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    public List<Address> listAddresses(Integer customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}