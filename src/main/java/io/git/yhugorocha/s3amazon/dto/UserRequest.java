package io.git.yhugorocha.s3amazon.dto;

import org.springframework.web.multipart.MultipartFile;

public record UserRequest(String name, MultipartFile profileImageFile) {
}
