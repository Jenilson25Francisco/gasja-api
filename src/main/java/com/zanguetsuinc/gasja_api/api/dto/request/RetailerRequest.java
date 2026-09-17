package com.zanguetsuinc.gasja_api.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetailerRequest {

    @Valid
    @NotNull(message = "por favor digite o id do utilizador")
    private UserIdRequest user;
    @NotBlank(message = "O nome do posto de venda é obrigatório")
    @Size(max = 255, message = "o nome do posto só pode ter 255 caracteres")
    private String name;
    @NotBlank(message = "Por favor digite a descrição do posto")
    private String description;
    @NotBlank(message = "Por favor digite o numero de telefone")
    private String phone;

}
