package com.zanguetsuinc.gasja_api.api.dto.response;

import com.zanguetsuinc.gasja_api.domain.enums.RetailerStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RetailerDetailsResponse {

    private UUID id;
    private String name;
    private String description;
    private String phone;
    private String imageUrl;
    private RetailerStatus status;

}
