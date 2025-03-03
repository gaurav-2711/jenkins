package com.jenkins.service.impl;

import com.jenkins.entity.DemoEntity;
import com.jenkins.repo.JenkinsRepo;
import com.jenkins.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JenkinsServiceImpl implements JenkinsService {

    @Autowired
    private JenkinsRepo jenkinsRepo;

    @Override
    public DemoEntity create(DemoEntity demoEntity) {
        return jenkinsRepo.save(demoEntity);
    }
}
