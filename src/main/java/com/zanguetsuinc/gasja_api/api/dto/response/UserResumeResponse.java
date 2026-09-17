package com.zanguetsuinc.gasja_api.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResumeResponse {

    private UUID id;
    private String name;

}
