package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.ResourceNotFoundException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import com.zanguetsuinc.gasja_api.domain.repositories.StationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class getRetailerService {

    private final StationRepository stationRepository;

    public getRetailerService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Retailer getStation(UUID stationId){
        return stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Posto não encontrado"));
    }
}
