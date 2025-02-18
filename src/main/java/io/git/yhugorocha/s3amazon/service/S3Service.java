package io.git.yhugorocha.s3amazon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.bucket-name}")
    private String bucketName;

    @Value("${aws.endpoint}")
    private String endpoint;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile multipartFile, String entityFile, String fileUri){
        String fileName = entityFile + fileUri;
        File fileObj = convertMultiPartFileToFile(multipartFile);

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(objectRequest, fileObj.toPath());

        return endpoint.concat("/" + bucketName).concat("/" + fileName);
    }

    private File convertMultiPartFileToFile(MultipartFile multipartFile){
        File convertedFile = new File(multipartFile.getOriginalFilename());
        try(FileOutputStream outputStream = new FileOutputStream(convertedFile)){
            outputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertedFile;
    }
}
