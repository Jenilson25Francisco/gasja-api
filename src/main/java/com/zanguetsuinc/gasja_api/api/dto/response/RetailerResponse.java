package com.zanguetsuinc.gasja_api.api.dto.response;

import com.zanguetsuinc.gasja_api.domain.enums.RetailerStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class RetailerResponse {

    private UUID id;
    private UserResumeResponse owner;
    private String name;
    private String description;
    private String phone;
    private RetailerStatus status;
    private String imageUrl;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
