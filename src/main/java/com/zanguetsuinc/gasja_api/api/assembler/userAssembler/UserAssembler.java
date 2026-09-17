package com.zanguetsuinc.gasja_api.api.assembler.userAssembler;

import com.zanguetsuinc.gasja_api.api.dto.request.UserIdRequest;
import com.zanguetsuinc.gasja_api.api.dto.request.UserRequest;
import com.zanguetsuinc.gasja_api.api.dto.response.UserResponse;
import com.zanguetsuinc.gasja_api.domain.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    private final ModelMapper modelMapper;

    public UserAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserResponse toResponse(User user){
        return modelMapper.map(user, UserResponse.class);
    }

    public User toRequest(UserRequest userRequest){
        return modelMapper.map(userRequest, User.class);
    }

    public User toRequest(UserIdRequest userIdRequest){
        return modelMapper.map(userIdRequest, User.class);
    }
}
