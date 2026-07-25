package com.geovaneCL.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovaneCL.workshopmongo.domain.User;
import com.geovaneCL.workshopmongo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository useRepo;

    public List<User> findAll(){
        return useRepo.findAll();
    }
}
