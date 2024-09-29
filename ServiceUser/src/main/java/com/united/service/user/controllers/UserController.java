package com.united.service.user.controllers;

import com.united.service.user.entities.User;
import com.united.service.user.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(tags = "User API",
            description = "User API description.......",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Error"
                    )
            }
    )

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userAll = userService.getAllUser();
        return ResponseEntity.ok(userAll);
    }

    @GetMapping("/{userId}/getbyid")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user.setUserID(UUID.randomUUID().toString());
        user.setCreatedDateTime(Instant.now());
        User userSave = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }
    @PatchMapping("{userId}/complete")
    public ResponseEntity<User> completeUser(@RequestBody User user)    {
        User user3 = userService.completeUser(user);
        return ResponseEntity.ok(user3);
    }

//    @RequestMapping(method = {PATCH}, path = "/update/{userid}/{ContactNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> updatePartialUser(@PathVariable String userid, @PathVariable String ContactNumber) {
//        try {
//            User User = userService.getUserById(userid);
//            User.setContactNumber(ContactNumber);
//            return new ResponseEntity<User>(userService.saveUser(User), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Operation(tags = "TokenAPI",
            description = "Token APIs",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Private Token...."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Error....."
                    )
            }
    )
    @GetMapping("/getToken")
    public String getToken() {
        String randomUUID = UUID.randomUUID().toString();
        return "MANVM-" + randomUUID + "-UNITED";
    }
}
