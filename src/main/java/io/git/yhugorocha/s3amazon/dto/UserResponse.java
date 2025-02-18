package io.git.yhugorocha.s3amazon.dto;

import io.git.yhugorocha.s3amazon.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String profileImageUrl;

    public static UserResponse toEntity(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
