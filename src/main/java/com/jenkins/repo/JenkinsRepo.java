package com.jenkins.repo;

import com.jenkins.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JenkinsRepo extends JpaRepository<DemoEntity,Integer> {

}
