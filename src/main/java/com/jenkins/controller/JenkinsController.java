package com.jenkins.controller;

import com.jenkins.entity.DemoEntity;
import com.jenkins.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JenkinsController {

    @Autowired
    private JenkinsService jenkinsService;

    @PostMapping("/create")
    public DemoEntity create(@RequestBody DemoEntity demoEntity){
        System.out.println("This is create methos");
        DemoEntity demo = jenkinsService.create(demoEntity);
        return demo;
    }
}
