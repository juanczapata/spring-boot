package com.jccz.management.hotel.service;

import com.jccz.management.hotel.dto.UserDto;
import com.jccz.management.hotel.entities.User;
import com.jccz.management.hotel.repository.UserRepository;
import com.jccz.management.hotel.response.CreateUserResponse;
import com.jccz.management.hotel.response.GetUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public CreateUserResponse createUser(UserDto user) {
        User storedUser = storeUserInDatabase(user);
        return CreateUserResponse.builder()
                .username(storedUser.getUsername())
                .status(HttpStatus.OK.toString())
                .Message("Success").build();
    }

    public GetUserResponse getUser(String username) {
        List<User> users = repository.findByUsername(username);
        Optional<User> userInDb = users.stream().findFirst();
        return GetUserResponse.builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .user(userInDb.orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "username not found"
                ))).build();
    }

    private User storeUserInDatabase(UserDto user) {
        byte[] salt = getRandomSalt();
        log.info("Salt generated for " + user.getUsername() + " - " + new String(salt));
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setHash(getHashedPassword(user, salt));
        newUser.setSalt(new String(salt));
        return repository.save(newUser);
    }

    private byte[] getRandomSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private String getHashedPassword(UserDto user, byte[] salt) {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(new String(salt), 1000, 36);
        return encoder.encode(user.getPassword());
    }


}
