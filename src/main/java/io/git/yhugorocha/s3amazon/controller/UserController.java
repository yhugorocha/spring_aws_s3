package io.git.yhugorocha.s3amazon.controller;

import io.git.yhugorocha.s3amazon.dto.UserRequest;
import io.git.yhugorocha.s3amazon.dto.UserResponse;
import io.git.yhugorocha.s3amazon.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<UserResponse> saveUser(@ModelAttribute UserRequest user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
