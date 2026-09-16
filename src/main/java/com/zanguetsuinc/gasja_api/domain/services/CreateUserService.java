package com.zanguetsuinc.gasja_api.domain.services;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.exceptions.ResourceNotFoundException;
import com.zanguetsuinc.gasja_api.domain.models.User;
import com.zanguetsuinc.gasja_api.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateUserService {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(UUID userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado"));
    }

    @Transactional
    public User createUser(User user){

        boolean existingUser = userRepository.findByEmail(user.getEmail())
                .stream()
                .anyMatch(currentUser -> !currentUser.equals(user));

        if (existingUser){
            throw  new BusinessException("Já existe um utilizador com o email " + user.getEmail());
        }


        return userRepository.save(user);
    }
}
