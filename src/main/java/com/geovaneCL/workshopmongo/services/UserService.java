package com.geovaneCL.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovaneCL.workshopmongo.domain.User;
import com.geovaneCL.workshopmongo.repository.UserRepository;
import com.geovaneCL.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository useRepo;

    public List<User> findAll() {
        return useRepo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = useRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
