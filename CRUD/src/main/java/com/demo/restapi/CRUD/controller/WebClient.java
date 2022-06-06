package com.demo.restapi.CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/app")
public class WebClient {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/savedTasks")
    public String displaySavedTasks(){

        String url = "http://localhost:8080/api/v1/todo/";
        String response = restTemplate.getForObject(url,String.class);

        return response;
    }
}
