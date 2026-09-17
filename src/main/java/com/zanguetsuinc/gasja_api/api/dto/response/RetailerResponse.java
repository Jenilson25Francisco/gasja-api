package com.zanguetsuinc.gasja_api.api.dto.response;

import com.zanguetsuinc.gasja_api.domain.enums.StationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class RetailerResponse {

    private UUID id;
    private String name;
    private String description;
    private String phone;
    private StationStatus status;
    private String imageUrl;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
