package com.example.Project.Entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import java.time.LocalDateTime;

@Entity
@Table(name = "Comparison")
public class ComparisionEntity {
    
    @Id
    @Column(name = "comparison_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comparisonId;


    @Column(name = "user")
    private String user;

    @Column(name = "product")
    private String product;

    @Column(name = "created_at")
    private String createdAt;

    public long getComparisonId() {
        return comparisonId;
    }

    public void setComparisonId(long comparisonId) {
        this.comparisonId = comparisonId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
