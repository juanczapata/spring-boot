package com.jccz.management.hotel.controller;

import com.jccz.management.hotel.dto.UserDto;
import com.jccz.management.hotel.response.CreateUserResponse;
import com.jccz.management.hotel.response.GetUserResponse;
import com.jccz.management.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping(value = "/create",
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public CreateUserResponse createUser(@RequestBody UserDto user) {
        log.info("In createUser controller ...");
        return service.createUser(user);
    }

    @GetMapping(value = "/{username}",
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetUserResponse getUser(@PathVariable @Pattern(regexp = "^[\\w]{1,65}") String username) {
        log.info("In getUser controller...looking for: " + username);
        return service.getUser(username);
    }
}
