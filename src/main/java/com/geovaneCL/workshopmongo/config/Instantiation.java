package com.geovaneCL.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.geovaneCL.workshopmongo.domain.Post;
import com.geovaneCL.workshopmongo.domain.User;
import com.geovaneCL.workshopmongo.dto.AuthorDTO;
import com.geovaneCL.workshopmongo.dto.CommentDTO;
import com.geovaneCL.workshopmongo.repository.PostRepository;
import com.geovaneCL.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
         userRepository.deleteAll();
         postRepository.deleteAll();

         User maria = new User(null, "Maria Brown", "maria@gmail.com");
         User alex = new User(null, "Alex Green", "alex@gmail.com");
         User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018 19:30"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2018 19:30"),"Bom dia.","Acordei feliz hoje!",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018 20:34"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018 09:23"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("26/03/2018 7:15"), new AuthorDTO(alex));

        post1.getComents().addAll(Arrays.asList(c1,c2));
        post2.getComents().addAll(Arrays.asList(c3));
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
        }

}
