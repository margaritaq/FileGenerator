package com.example.fileGenerator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


@Service
public class FileBuilderServiceImpl implements FileBuilderService {
    private final static Logger log = LoggerFactory.getLogger(FileBuilderServiceImpl.class);

    @Value("${files.path}")
    public  String destination;

    public ResponseEntity<Object> generateFile(String name) {
        try {
            String fileName = destination + name + ".txt";

            FileWriter writer = new FileWriter(fileName);
            writer.write(name);
            writer.flush();
            writer.close();

            File file = new File(fileName);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            ResponseEntity<Object> responseEntity = ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/txt"))
                    .body(resource);
            return responseEntity;
        } catch (Exception e) {
            log.error("Error encountered when downloading file!", e);

            return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}