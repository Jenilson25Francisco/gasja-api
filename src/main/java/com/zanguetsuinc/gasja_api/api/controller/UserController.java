package com.zanguetsuinc.gasja_api.api.controller;

import com.zanguetsuinc.gasja_api.api.assembler.userAssembler.UserAssembler;
import com.zanguetsuinc.gasja_api.api.dto.request.UserRequest;
import com.zanguetsuinc.gasja_api.api.dto.response.UserResponse;
import com.zanguetsuinc.gasja_api.domain.services.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserAssembler userAssembler;
    private final CreateUserService userService;

    public UserController(UserAssembler userAssembler, CreateUserService userService) {
        this.userAssembler = userAssembler;
        this.userService = userService;
    }

    @PostMapping("signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody UserRequest userRequest){
        var user = userAssembler.toRequest(userRequest);
        var createdUser = userService.createUser(user);
        return userAssembler.toResponse(createdUser);
    }
}
