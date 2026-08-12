package com.example.staj1.controller;

import com.example.staj1.model.Price;
import com.example.staj1.repository.PriceRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceRepository priceRepository;

    public PriceController(PriceRepository priceRepository){
        this.priceRepository=priceRepository;
    }

    @PostMapping("")
    public Price create(@RequestBody Price price){
        return priceRepository.save(price);
    }
}
