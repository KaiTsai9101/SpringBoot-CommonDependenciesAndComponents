package chapter1.kai.service;

import chapter1.kai.model.ResponseModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UploadService {
    ResponseModel upload(MultipartFile file) throws IOException;
}
