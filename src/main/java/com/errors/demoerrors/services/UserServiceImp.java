package com.errors.demoerrors.services;

import com.errors.demoerrors.models.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp  implements UserService{


    @Autowired
    //@Qualifier("dataUsers")
    private List<User> dataUsers;

    public UserServiceImp() {

    }

    @Override
    public List<User> findAll() {
        return dataUsers;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = dataUsers.stream().filter(userOb -> userOb.getId().equals(id)).findFirst();
        //User user = null;
      //  for (User u : dataUsers) {
        //    Long a = u.getId();
          //  if (a.equals(id)) {
            //    user = u;
              //  break;
           // }

        return user;
    }
}
