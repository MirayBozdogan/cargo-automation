package com.example.staj1.controller;

import com.example.staj1.model.Price;
import com.example.staj1.repository.PriceRepository;
import com.example.staj1.service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceRepository priceRepository;
    private final PriceService priceService;

    public PriceController(PriceRepository priceRepository,PriceService priceService){
        this.priceRepository=priceRepository;
        this.priceService=priceService;
    }

    @GetMapping
    public List<Price> getAll() {
        return priceService.getAll();
    }

    @PostMapping("")
    public Price create(@RequestBody Price price){
        return priceRepository.save(price);
    }
}
