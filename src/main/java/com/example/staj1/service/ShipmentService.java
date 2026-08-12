package com.example.staj1.service;

import com.example.staj1.Dto.CalculatePriceResponse;
import com.example.staj1.Dto.ShipmentRequest;
import com.example.staj1.exception.GlobalExceptionHandler;
import com.example.staj1.model.Customer;
import com.example.staj1.model.Price;
import com.example.staj1.model.Shipment;
import com.example.staj1.repository.CustomerRepository;
import com.example.staj1.repository.PriceRepository;
import com.example.staj1.repository.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final PriceRepository priceRepository;
    private final CustomerRepository customerRepository;

    public ShipmentService(
            ShipmentRepository shipmentRepository,
            PriceRepository priceRepository,
            CustomerRepository customerRepository) {

        this.shipmentRepository = shipmentRepository;
        this.priceRepository = priceRepository;
        this.customerRepository = customerRepository;
    }

    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    public Shipment get(Integer id) {

        Optional<Shipment> shipment =
                shipmentRepository.findById(id);

        if (shipment.isPresent()) {
            return shipment.get();
        }

        throw new EntityNotFoundException("Gönderi bulunamadı.");
    }

    public CalculatePriceResponse create(
            ShipmentRequest shipmentRequest) {

        Shipment shipment = new Shipment();

        shipment.setWidth(shipmentRequest.getWidth());
        shipment.setLength(shipmentRequest.getLength());
        shipment.setHeight(shipmentRequest.getHeight());
        shipment.setWeight(shipmentRequest.getWeight());

        if (shipmentRequest.getCustomerId() != null) {

            Optional<Customer> customer =
                    customerRepository.findById(
                            shipmentRequest.getCustomerId()
                    );

            if (customer.isPresent()) {
                shipment.setCustomer(customer.get());
            } else {
                throw new EntityNotFoundException(
                        "Müşteri bulunamadı."
                );
            }
        }

        CalculatePriceResponse priceResponse =
                calculatePrice(
                        shipmentRequest.getWidth(),
                        shipmentRequest.getLength(),
                        shipmentRequest.getHeight(),
                        shipmentRequest.getWeight()
                );

        shipment.setPrice(priceResponse.getPrice());

        Shipment savedShipment = shipmentRepository.save(shipment);

        priceResponse.setId(savedShipment.getId());
        priceResponse.setCustomer(savedShipment.getCustomer());

        return priceResponse;
    }

    public CalculatePriceResponse update(
            Integer id,
            ShipmentRequest shipmentRequest) {

        Shipment shipment = get(id);

        shipment.setWeight(shipmentRequest.getWeight());
        shipment.setHeight(shipmentRequest.getHeight());
        shipment.setLength(shipmentRequest.getLength());
        shipment.setWidth(shipmentRequest.getWidth());

        CalculatePriceResponse priceResponse =
                calculatePrice(
                        shipmentRequest.getWidth(),
                        shipmentRequest.getLength(),
                        shipmentRequest.getHeight(),
                        shipmentRequest.getWeight()
                );

        shipment.setPrice(priceResponse.getPrice());

        Shipment savedShipment = shipmentRepository.save(shipment);

        priceResponse.setId(savedShipment.getId());
        priceResponse.setCustomer(savedShipment.getCustomer());

        return priceResponse;
    }

    public void delete(Integer id) {

        Shipment shipment = get(id);

        shipmentRepository.delete(shipment);
    }

    public CalculatePriceResponse calculatePrice(
            BigDecimal width,
            BigDecimal length,
            BigDecimal height,
            BigDecimal weight) {

        // En × Boy × Yükseklik
        BigDecimal volume = width
                .multiply(length)
                .multiply(height);

        // Hacim / 3000 = Desi
        BigDecimal desi = volume.divide(
                BigDecimal.valueOf(3000),
                2,
                RoundingMode.HALF_UP
        );

        BigDecimal billableValue;
        String calculatedBy;

        // Desi mi ağırlık mı daha büyük?
        if (desi.compareTo(weight) > 0) {

            billableValue = desi;
            calculatedBy = "DESI";

        } else {

            billableValue = weight;
            calculatedBy = "WEIGHT";
        }

        // Fiyat tablosundan uygun fiyatı bul
        Price price =
                priceRepository
                        .findByMinDesiLessThanEqualAndMaxDesiGreaterThan(
                                billableValue,
                                billableValue
                        );

        if (price == null) {
            throw new GlobalExceptionHandler.PriceNotFoundException(
                    "Hesaplanan değer için uygun fiyat bulunamadı."
            );
        }

        // Response oluştur
        CalculatePriceResponse response =
                new CalculatePriceResponse();

        response.setWidth(width);
        response.setLength(length);
        response.setHeight(height);
        response.setWeight(weight);
        response.setDesi(desi);
        response.setCalculatedValue(billableValue);
        response.setCalculatedBy(calculatedBy);
        response.setPrice(price.getPrice());

        return response;
    }
}