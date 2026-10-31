package com.zanguetsuinc.gasja_api.domain.services;


import com.zanguetsuinc.gasja_api.domain.enums.RetailerStatus;
import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import com.zanguetsuinc.gasja_api.domain.repositories.RetailerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CreateRetailerService {

    private final CloudinaryService cloudinary;
    private final CreateUserService createUserService;
    private final RetailerRepository retailerRepository;

    public CreateRetailerService(RetailerRepository retailerRepository,
                                 CloudinaryService cloudinary,
                                 CreateUserService createUserService
    ) {
        this.retailerRepository = retailerRepository;
        this.cloudinary = cloudinary;
        this.createUserService = createUserService;
    }

    @Transactional
    public Retailer createRetailer(Retailer retailer, MultipartFile file) throws Exception {

        var user = createUserService.getUserById(retailer.getOwner().getId());

        boolean exists = retailerRepository.findByPhone(retailer.getPhone()).isPresent();
        if (exists) {
            throw new BusinessException("Revendedador com o numero " + retailer.getPhone() + " já cadastrado");
        }

        if(file != null && !file.isEmpty()){
            Map result = cloudinary.uploadImage(file, "gasja/retailers");

            retailer.setImageUrl(result.get("secure_url").toString());
            retailer.setPublicId(result.get("public_id").toString());

        }

        retailer.setOwner(user);
        retailer.setStatus(RetailerStatus.AGUARDANDO_APROVACAO);

        return retailerRepository.save(retailer);

    }
}
