package com.example.staj1.controller;

import com.example.staj1.Dto.AddressRequest;
import com.example.staj1.Dto.CustomerRequest;
import com.example.staj1.model.Address;
import com.example.staj1.service.AddressService;
import com.example.staj1.service.CustomerService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/customers")
public class AddressController {
    public final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> get() {
        return addressService.get();
    }

    @GetMapping("/{customer_id}/address")
    public List<Address> getById(@PathVariable Integer customer_id) {
        return addressService.getById(customer_id);
    }

    @PostMapping("/{customer_id}/address")
    public Address create(
            @PathVariable Integer customer_id,
            @Valid @RequestBody AddressRequest addressRequest) {
        return addressService.create(addressRequest, customer_id);
    }

    @PutMapping("/{customer_id}/address/{id}")
    public Address update(@PathVariable Integer customer_id,
                          @PathVariable Integer id,
                          @Valid @RequestBody AddressRequest addressRequest) {
        return addressService.update(customer_id, id, addressRequest);
    }

    @DeleteMapping("/{customer_id}/address/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer customer_id,
            @PathVariable Integer id) {

        addressService.delete(customer_id, id);

        return ResponseEntity.noContent().build();
    }


}
