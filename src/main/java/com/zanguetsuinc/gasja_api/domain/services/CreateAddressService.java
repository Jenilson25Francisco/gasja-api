package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Address;
import com.zanguetsuinc.gasja_api.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CreateAddressService {

    private final AddressRepository addressRepository;

    public CreateAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address execute(Address address) {
        if (address.getLocalization() == null) {
            throw new BusinessException("Localization is required");
        }

        if (address.getLocalization().getX() < -180 || address.getLocalization().getX() > 180) {
            throw new BusinessException("Longitude must be between -180 and 180");
        }

        if (address.getLocalization().getY() < -90 || address.getLocalization().getY() > 90) {
            throw new BusinessException("Latitude must be between -90 and 90");
        }

        return addressRepository.save(address);
    }
}
