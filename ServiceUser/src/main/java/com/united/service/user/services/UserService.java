package com.united.service.user.services;

import com.united.service.user.entities.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    //create
    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(String userId);

    User completeUser(User user);

//    User updatePartialUser(String userid, String ContactNumber);
}
