package com.example.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Project.Entity.ReviewEntity;
@Repository
public interface Reviewrepo extends JpaRepository<ReviewEntity,Integer>{
     List<ReviewEntity> findAll();
}