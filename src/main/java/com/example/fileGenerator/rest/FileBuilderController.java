package com.example.fileGenerator.rest;
import com.example.fileGenerator.service.FileBuilderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@RestController
public class FileBuilderController {
    private final static Logger log = LoggerFactory.getLogger(FileBuilderController.class);
    @Autowired
    FileBuilderServiceImpl file;


    @RequestMapping("files/file/{name}")
    public ResponseEntity<Object> getFile(@PathVariable("name")@NotNull @NotBlank @Size(max = 10) String fileName){

        ResponseEntity<Object> response = file.generateFile(fileName);
        log.debug("file name is : {} ", fileName);
        return response;

    }

}
