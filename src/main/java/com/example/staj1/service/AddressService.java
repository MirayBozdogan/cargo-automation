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
import jakarta.persistence.EntityNotFoundException;
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

    public List<Address> get() {
        return addressRepository.findAll();
    }

    public List<Address> getById(Integer customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    public Address create(AddressRequest addressRequest, Integer customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Müşteri bulunamadı."
                ));

        City city = cityRepository.findById(addressRequest.getCityId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Şehir bulunamadı."
                ));

        District district = districtRepository.findById(addressRequest.getDistrictId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "İlçe bulunamadı."
                ));

        Address address = new Address();

        address.setCity(city);
        address.setDistrict(district);
        address.setNeighborhood(addressRequest.getNeighborhood());
        address.setBuildingNo(addressRequest.getBuildingNo());
        address.setApartmentNo(addressRequest.getApartmentNo());
        address.setCustomer(customer);
        return addressRepository.save(address);
    }

    public Address update(Integer customer_id, Integer id, AddressRequest addressRequest){
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Müşteri bulunamadı."));

        Address address = addressRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Adres bulunamadı."));

        City city = cityRepository.findById(addressRequest.getCityId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Şehir bulunamadı."));

        District district = districtRepository.findById(addressRequest.getDistrictId())
                .orElseThrow(() ->
                        new EntityNotFoundException("İlçe bulunamadı."));

        address.setCity(city);
        address.setDistrict(district);
        address.setNeighborhood(addressRequest.getNeighborhood());
        address.setBuildingNo(addressRequest.getBuildingNo());
        address.setApartmentNo(addressRequest.getApartmentNo());
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    public void delete(Integer customer_id, Integer id) {

        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Müşteri bulunamadı."));

        Address address = addressRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Adres bulunamadı."));

        if (!address.getCustomer().getId().equals(customer_id)) {
            throw new IllegalArgumentException(
                    "Bu adres bu müşteriye ait değil."
            );
        }

        addressRepository.delete(address);
    }
}