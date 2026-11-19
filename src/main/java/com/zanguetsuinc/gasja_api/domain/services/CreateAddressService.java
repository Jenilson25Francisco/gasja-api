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

    private void validateCoordinates(BigDecimal longitude, BigDecimal latitude){

        if (latitude == null || longitude == null) {
            throw new BusinessException("Latitude e longitude são obrigatórias");
        }

        if (latitude.compareTo(BigDecimal.valueOf(-90)) < 0 || latitude.compareTo(BigDecimal.valueOf(90)) > 0){
            throw  new BusinessException("Latitude inválida");
        }

        if (longitude.compareTo(BigDecimal.valueOf(-180)) < 0 || longitude.compareTo(BigDecimal.valueOf(180)) > 0){
            throw new BusinessException("longitude inválida");
        }

    }

    @Transactional
    public Address addAddress(Address address) {
        validateCoordinates(
                BigDecimal.valueOf(address.getLocalization().getX()),
                BigDecimal.valueOf(address.getLocalization().getY())
        );


        return addressRepository.save(address);
    }

}
