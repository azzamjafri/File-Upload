package com.example.filedemo.controller;

import java.io.File;
import java.io.FileWriter;
//import java.net.http.HttpResponse;

import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

        @GetMapping("/callApi")
        public void serveToApi(){
            // Get api key from https://app.platerecognizer.com/start/ and replace MY_API_KEY
            String token = "7169389cb7dd21bf694f36eac9e6aa2a6e619d14";
            String file = "/home/azzam/Desktop/SIH/API/photos/775.jpg";

            try{
                HttpResponse<String> response = Unirest.post("https://api.platerecognizer.com/v1/plate-reader/")
                        .header("Authorization", "Token "+token)
                        .field("upload", new File(file))
                        .asString();
                System.out.println("Recognize:");
                System.out.println(response.getBody().toString());
            }
            catch(Exception e){
                System.out.println(e);
            }

            try{
                HttpResponse<String> response = Unirest.get("https://api.platerecognizer.com/v1/statistics/")
                        .header("Authorization", "Token "+token)
                        .asString();
                System.out.println("Usage:");
                System.out.println(response.getBody().toString());
            }
            catch(Exception e){
                System.out.println(e);
            }

        }

}
