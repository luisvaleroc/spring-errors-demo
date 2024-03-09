package com.errors.demoerrors;

import com.errors.demoerrors.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserDatasApplication {

    @Bean
    public List<User> dataUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1l, "Pedro", "Gonzalez"));
        users.add(new User(2l, "Ana", "Mena"));
        users.add(new User(3l, "Luis", "Perez"));
        users.add(new User(4l, "Carloz", "Santiago"));
        users.add(new User(5l, "Alfonso", "Palma"));
        return users;
    }

}
