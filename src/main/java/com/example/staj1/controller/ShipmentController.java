package com.example.staj1.controller;

import com.example.staj1.Dto.CalculatePriceResponse;
import com.example.staj1.Dto.ShipmentRequest;
import com.example.staj1.model.Shipment;
import com.example.staj1.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("")
    public List<Shipment> getAll() {
        return shipmentService.getAll();
    }

    @GetMapping("{id}")
    public Shipment get(@PathVariable Integer id) {
        return shipmentService.get(id);
    }

    @PostMapping("")
    public CalculatePriceResponse create(@Valid
                           @RequestBody ShipmentRequest shipmentRequest) {
        return shipmentService.create(shipmentRequest);
    }

    @PostMapping("/calculate-price")
    public CalculatePriceResponse calculatePrice(@RequestBody ShipmentRequest shipmentRequest){
        return shipmentService.calculatePrice(
                shipmentRequest.getWidth(),
                shipmentRequest.getLength(),
                shipmentRequest.getHeight(),
                shipmentRequest.getWeight()
        );
    }

    @PutMapping("{id}")
    public CalculatePriceResponse update(@Valid
                           @PathVariable Integer id,
                           @RequestBody ShipmentRequest shipmentRequest) {
        return shipmentService.update(id,shipmentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        shipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
