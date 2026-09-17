package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import com.zanguetsuinc.gasja_api.domain.models.User;
import com.zanguetsuinc.gasja_api.domain.repositories.RetailerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRetailerService {

    private final CreateUserService userService;
    private final RetailerRepository retailerRepository;

    public CreateRetailerService(CreateUserService userService, RetailerRepository retailerRepository) {
        this.userService = userService;
        this.retailerRepository = retailerRepository;
    }

    @Transactional
    public Retailer createStation(Retailer retailer){

        User user = userService.getUser(retailer.getId());

        boolean existsStation = retailerRepository.findByPhone(retailer.getPhone())
                        .stream().anyMatch(myRetailer -> !myRetailer.equals(retailer));

        if (existsStation){
            throw new BusinessException("Já existe um posto com o telefone " + retailer.getPhone());
        }

        retailer.setId(user.getId());
        return retailerRepository.save(retailer);

    }
}
