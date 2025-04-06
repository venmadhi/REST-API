package com.example.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Project.Entity.ComparisionEntity;
@Repository
public interface Comparisionrepo extends JpaRepository<ComparisionEntity,Integer>{
     List<ComparisionEntity> findAll();
}