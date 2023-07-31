package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Address;
import com.veggie.veggieapp.repository.AddressRepository;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractCrudService<Address, Integer> {

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
    }
}
