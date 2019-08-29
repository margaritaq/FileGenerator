package com.example.fileGenerator.service;

import org.springframework.http.ResponseEntity;

public interface FileBuilderService {
    ResponseEntity<Object> generateFile(String name);
}
