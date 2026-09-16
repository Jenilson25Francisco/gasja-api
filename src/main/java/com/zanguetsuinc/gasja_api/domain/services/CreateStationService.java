package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Station;
import com.zanguetsuinc.gasja_api.domain.models.User;
import com.zanguetsuinc.gasja_api.domain.repositories.StationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateStationService {

    private final CreateUserService userService;
    private final StationRepository stationRepository;

    public CreateStationService(CreateUserService userService, StationRepository stationRepository) {
        this.userService = userService;
        this.stationRepository = stationRepository;
    }

    @Transactional
    public Station createStation(Station station){

        User user = userService.getUser(station.getId());

        boolean existsStation = stationRepository.findByPhone(station.getPhone())
                        .stream().anyMatch(myStation -> !myStation.equals(station));

        if (existsStation){
            throw new BusinessException("Já existe um posto com o telefone " + station.getPhone());
        }

        station.setId(user.getId());
        return stationRepository.save(station);

    }
}
