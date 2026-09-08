package com.zanguetsuinc.gasja_api.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "O nome completo é obrigatório")
    @Size(min = 3, message = "O campo nome deve ter no mínimo {min} caracteres")
    private String name;
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Digite um e-mail válido")
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 5, message = "A senha deve ter no mínimo {min} caracteres")
    private String password;

}
