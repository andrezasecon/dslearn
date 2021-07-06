package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            // método spring para setar o usuário corrente
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByEmail(username);
        }
        catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    // método para verificar se o usuário é ele próprio ou admin
    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }
}

