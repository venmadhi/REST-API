package com.example.Project.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Project.Entity.smtpEntiy;
@Repository
public interface emailrepo extends JpaRepository<smtpEntiy,Integer>{
}
