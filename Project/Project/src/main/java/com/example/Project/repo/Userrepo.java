package com.example.Project.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Project.Entity.UserEntity;
@Repository
public interface Userrepo extends JpaRepository<UserEntity,Integer>{
     List<UserEntity> findAll();
     List<UserEntity> findByName(String name);
 	List<UserEntity> findByNameContains(String name);
 	List<UserEntity> findByNameIsContaining(String name);
 	List<UserEntity> findByNameContaining(String name);
 	List<UserEntity> findByNameStartingWith(String name);
 	List<UserEntity> findByNameEndingWith(String name);
 	List<UserEntity> findByNameNotContains(String name);
 	List<UserEntity> findByNameNotContaining(String name);
    List<UserEntity> findByNameNotLike(String name);
	//pagination
	Page<UserEntity> findAll(Pageable pageable);

}