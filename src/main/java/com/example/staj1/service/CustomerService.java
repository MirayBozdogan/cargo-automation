package com.example.staj1.service;
import com.example.staj1.Dto.CustomerDetail;
import com.example.staj1.Dto.CustomerRequest;
import com.example.staj1.exception.GlobalExceptionHandler;
import com.example.staj1.model.Customer;
import com.example.staj1.repository.AddressRepository;
import com.example.staj1.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public List<Customer> getir(){
        return customerRepository.findAll();
    }

    public Page<Customer> sayfaGetir(Pageable pageable){
    return  customerRepository.findAll(pageable);
    }

    public Customer ekle(CustomerRequest customerRequest){


        if(customerRepository.existsByEmail(customerRequest.getEmail()))
        {
            throw new IllegalArgumentException("Bu e-posta adresi zaten kayıtlı!");
        }

        if(customerRepository.existsByTc(customerRequest.getTc()))
        {
            throw new IllegalArgumentException("Bu TC zaten kayıtlı!");
        }

        if(customerRepository.existsByTc(customerRequest.getTelNo()))
        {
            throw new IllegalArgumentException("Bu numara zaten kayıtlı!");
        }

        Customer customer = new Customer();
       customer.setName(customerRequest.getName());
       customer.setSurname(customerRequest.getSurname());
       customer.setAge(customerRequest.getAge());
       customer.setEmail(customerRequest.getEmail());
       customer.setTc(customerRequest.getTc());
       customer.setTelNo(customerRequest.getTelNo());

      return customerRepository.save(customer);
    }
    public List<Customer> topluEkle(List<CustomerRequest> customerRequests) {

        List<Customer> customers = new ArrayList<>();

        for (CustomerRequest customerRequest : customerRequests) {

            Customer customer = new Customer();
            customer.setName(customerRequest.getName());
            customer.setSurname(customerRequest.getSurname());
            customer.setEmail(customerRequest.getEmail());
            customer.setAge(customerRequest.getAge());
            customer.setTc(customerRequest.getTc());
            customer.setTelNo(customerRequest.getTelNo());
            customers.add(customer);
        }
        return customerRepository.saveAll(customers);
    }

    public Customer guncelle(Integer id, CustomerRequest customerRequest){
        Customer customer = customerRepository.findById(id)
                .orElseThrow();

        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setEmail(customerRequest.getEmail());
        customer.setAge(customerRequest.getAge());
        customer.setTc(customerRequest.getTc());
        customer.setTelNo(customerRequest.getTelNo());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {

        if (addressRepository.existsByCustomerId(id)) {
            throw new GlobalExceptionHandler.CustomerHasAddressException(
                    "Bu müşteriye ait adres kayıtları olduğu için silinemez."
            );
        }
        customerRepository.deleteById(id);
    }

    public Optional<Customer> customerGet(Integer id){
        return customerRepository.findById( id);
    }

}