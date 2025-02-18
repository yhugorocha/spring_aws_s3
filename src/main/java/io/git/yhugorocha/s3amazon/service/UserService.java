package io.git.yhugorocha.s3amazon.service;

import io.git.yhugorocha.s3amazon.dto.UserRequest;
import io.git.yhugorocha.s3amazon.dto.UserResponse;
import io.git.yhugorocha.s3amazon.entity.User;
import io.git.yhugorocha.s3amazon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final S3Service s3Service;

    public UserResponse saveUser(UserRequest user) {

        User newUser = User.builder().name(user.name()).build();
        String url = s3Service.uploadFile(user.profileImageFile(), newUser.getName(), UUID.randomUUID().toString());
        newUser.setProfileImageUrl(url);
        userRepository.save(newUser);
        return UserResponse.toEntity(newUser);
    }
}
