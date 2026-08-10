package com.example.staj1.controller;


import com.example.staj1.Dto.CustomerDetail;
import com.example.staj1.Dto.CustomerRequest;
import com.example.staj1.model.Customer;
import com.example.staj1.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public List<Customer> getir() {
        return  customerService.getir();
    }

    @GetMapping("/{id}")
    public Optional<Customer> customerGet(@PathVariable Integer id){
        return customerService.customerGet(id);
    }

    @GetMapping("")
    public Page<Customer> sayfaGetir(Pageable pageable) {
        return customerService.sayfaGetir(pageable);
    }

    @PostMapping("")
    public Customer ekle(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.ekle(customerRequest);
    }

    @PostMapping("/toplu")
    public List<Customer> topluEkle( @Valid  @RequestBody List<CustomerRequest> customers) {
        return customerService.topluEkle(customers);
    }

    @PutMapping("/{id}")
    public Customer guncelle(@Valid
            @PathVariable Integer id,
            @RequestBody CustomerRequest customerRequest) {

        return customerService.guncelle(id, customerRequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}

