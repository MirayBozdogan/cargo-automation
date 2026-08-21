package com.example.staj1.service;

import com.example.staj1.model.Price;
import com.example.staj1.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price create(Price price) {
        return priceRepository.save(price);
    }

    public List<Price> getAll() {
        return priceRepository.findAll();
    }
}
