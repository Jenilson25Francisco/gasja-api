package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import com.zanguetsuinc.gasja_api.domain.models.User;
import com.zanguetsuinc.gasja_api.domain.repositories.StationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRetailerService {

    private final CreateUserService userService;
    private final StationRepository stationRepository;

    public CreateRetailerService(CreateUserService userService, StationRepository stationRepository) {
        this.userService = userService;
        this.stationRepository = stationRepository;
    }

    @Transactional
    public Retailer createStation(Retailer retailer){

        User user = userService.getUser(retailer.getId());

        boolean existsStation = stationRepository.findByPhone(retailer.getPhone())
                        .stream().anyMatch(myRetailer -> !myRetailer.equals(retailer));

        if (existsStation){
            throw new BusinessException("Já existe um posto com o telefone " + retailer.getPhone());
        }

        retailer.setId(user.getId());
        return stationRepository.save(retailer);

    }
}
