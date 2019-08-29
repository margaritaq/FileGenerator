package com.example.FileGenerator.rest;
import com.example.FileGenerator.service.FileBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FileController {
    private final static Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${files.path}")
    public String destination;
    @RequestMapping("/files/{fileId}")
    public ResponseEntity<Object> getFile(@PathVariable("fileId")int fileId){
        FileBuilderImpl file = new FileBuilderImpl();
        ResponseEntity<Object> response = file.downloadFile(fileId, destination);
        log.debug("log debug file name is : "+ fileId);
        return response;

    }

}
