package com.zanguetsuinc.gasja_api.api.controller;

import com.zanguetsuinc.gasja_api.api.assembler.retailerAssembler.RetailerAssembler;
import com.zanguetsuinc.gasja_api.api.dto.request.RetailerRequest;
import com.zanguetsuinc.gasja_api.api.dto.response.RetailerResponse;
import com.zanguetsuinc.gasja_api.domain.services.CreateRetailerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/retailers")
public class RetailerController {

    private final RetailerAssembler retailerAssembler;
    private final CreateRetailerService retailerService;

    public RetailerController(RetailerAssembler retailerAssembler, CreateRetailerService retailerService) {
        this.retailerAssembler = retailerAssembler;
        this.retailerService = retailerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetailerResponse saveRetailer(@Valid @RequestBody RetailerRequest retailerRequest){
        var retailer = retailerAssembler.toRequest(retailerRequest);
        var createdRetailer = retailerService.createRetailer(retailer);
        return retailerAssembler.toResponse(createdRetailer);
    }
}
