package com.example.FileGenerator.service;

import org.springframework.http.ResponseEntity;

public interface FileBuilderInterface {
    ResponseEntity<Object> downloadFile(int fileId, String destination);
}
