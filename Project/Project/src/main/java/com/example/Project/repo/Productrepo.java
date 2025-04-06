package com.example.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Entity.ProductEntity;
@Repository
public interface Productrepo extends JpaRepository<ProductEntity,Integer>{
     List<ProductEntity> findAll();
}