package com.united.service.user.impl;

import com.united.service.user.entities.User;
import com.united.service.user.exceptions.ResourceNotFoundException;
import com.united.service.user.repositories.UserRepository;
import com.united.service.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) {
       String randomUserId= UUID.randomUUID().toString();
       user.setUserID(randomUserId);
        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

//    @Override
//    public User updatePartialUser(String userid, String ContactNumber) {
//        //String userId = user.getUserID();
//        User userData = userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + userid));
//        //userData.setCity("NDLS............");
//
//        User updatedUser = userRepository.save(userData);
//        return mapToUserData(updatedUser);
//
//    }

    @Override
    public User completeUser(User user) {
        String userId = user.getUserID();
        User userData = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + userId));
        userData.setContactNumber(user.getContactNumber());




        User updatedUser = userRepository.save(userData);
        return mapToUserData(updatedUser);
    }
    private User mapToUserData(User user){
        User userData = new User();
        userData.setUserID(user.getUserID());
        userData.setUserName(user.getUserName());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setAddress(user.getAddress());
        userData.setCity(user.getCity());
        userData.setContactNumber(user.getContactNumber());
        userData.setEMailId(user.getEMailId());
        userData.setCreatedBy(user.getCreatedBy());
        userData.setCreatedDateTime(user.getCreatedDateTime());
        userData.setUpdatedBy(user.getUpdatedBy());
        userData.setUpdatedDateTime(user.getUpdatedDateTime());
        //userData.setisActive(user.getisActive());
        //userData.setisDeleted(user.getisDeleted());
        return userData;
    }
}
