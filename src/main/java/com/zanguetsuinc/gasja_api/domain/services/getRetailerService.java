package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.ResourceNotFoundException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import com.zanguetsuinc.gasja_api.domain.repositories.RetailerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class getRetailerService {

    private final RetailerRepository retailerRepository;

    public getRetailerService(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    public Retailer getStation(UUID stationId){
        return retailerRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Posto não encontrado"));
    }
}
