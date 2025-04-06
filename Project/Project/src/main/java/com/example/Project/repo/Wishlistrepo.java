package com.example.Project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Entity.WishlistEntity;

@Repository
public interface Wishlistrepo extends JpaRepository<WishlistEntity,Integer>{
     List<WishlistEntity> findAll();
}