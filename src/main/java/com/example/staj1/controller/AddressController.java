package com.example.staj1.controller;

import com.example.staj1.Dto.AddressRequest;
import com.example.staj1.Dto.CustomerRequest;
import com.example.staj1.model.Address;
import com.example.staj1.service.AddressService;
import com.example.staj1.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class AddressController {
    public final AddressService addressService;

    public AddressController(AddressService addressService ){
        this.addressService= addressService;
    }

    @PostMapping("/{customer_id}/address")
    public Address addAdress (@PathVariable  Integer customer_id ,
                              @RequestBody AddressRequest addressRequest){
    return addressService.addAddress(addressRequest , customer_id);
    }

    @GetMapping("/{customer_id}/address")
    public List<Address> listAddresses(@PathVariable Integer customer_id){
        return addressService.listAddresses(customer_id);
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

}
