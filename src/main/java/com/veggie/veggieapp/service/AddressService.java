package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Address;
import com.veggie.veggieapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractCrudService<Address, Integer> {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;
    }
}
