package ru.itpark.service.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    List<String> saveFiles(MultipartFile[] files);

    void writeFileToResponce(String fileName, HttpServletResponse response);
}
