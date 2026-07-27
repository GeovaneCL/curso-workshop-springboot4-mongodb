package com.geovaneCL.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovaneCL.workshopmongo.domain.Post;
import com.geovaneCL.workshopmongo.repository.PostRepository;
import com.geovaneCL.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post findById(String id) {
        Optional<Post> obj = postRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


   
}
