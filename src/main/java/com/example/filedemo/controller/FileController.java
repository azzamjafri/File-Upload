package com.example.filedemo.controller;

import io.quicktype.Converter;
import com.example.filedemo.payload.UploadFileResponse;
import com.example.filedemo.service.FileStorageService;
//import jdk.nashorn.internal.parser.JSONParser;
import io.quicktype.PlateRecognise;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();


        //System.out.println("***** " + fileName + "  ****  " + file.getOriginalFilename());

        // ################### Code for plate recognition ###########

        //.com/example/filedemo/controller/FileController.java:44


        // Get api key from https://app.platerecognizer.com/start/ and replace MY_API_KEY
        String token = "7169389cb7dd21bf694f36eac9e6aa2a6e619d14";
        String fileToServe = "/home/azzam/Desktop/SIH/bikes_ocr_new/" + fileName;

        try{
            HttpResponse<String> response = Unirest.post("https://api.platerecognizer.com/v1/plate-reader/")
                    .header("Authorization", "Token "+token)
                    .field("upload", new File(fileToServe))
                    .asString();
            System.out.println("Recognize:");
            System.out.println(response.getBody().toString());
        }
        catch(Exception e){
            System.out.println(e);
        }
        HttpResponse<String> response = null;
        try{
            response = Unirest.get("https://api.platerecognizer.com/v1/statistics/")
                    .header("Authorization", "Token "+token)
                    .asString();
            System.out.println("Usage:");
            //System.out.println(response.getBody().toString());
            //String JSON = response.getBody().toString();


            PlateRecognise data = Converter.fromJsonString(response.getBody());
            System.out.println(data.getTimestamp());

        }
        catch(Exception e){
            System.out.println(e);
        }


    // ######## Code ends for API Call ##########



        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize(), response.getBody().toString());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
