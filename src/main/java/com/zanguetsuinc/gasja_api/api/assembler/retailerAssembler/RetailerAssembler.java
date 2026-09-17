package com.zanguetsuinc.gasja_api.api.assembler.retailerAssembler;

import com.zanguetsuinc.gasja_api.api.dto.request.RetailerRequest;
import com.zanguetsuinc.gasja_api.api.dto.response.RetailerResponse;
import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RetailerAssembler {

    private final ModelMapper modelMapper;

    public RetailerAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RetailerResponse toResponse(Retailer retailer){
        return modelMapper.map(retailer, RetailerResponse.class);
    }

    public Retailer toRequest(RetailerRequest retailerRequest){
        return modelMapper.map(retailerRequest, Retailer.class);
    }
}
