package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.ReviewEntity;
import com.example.Project.repo.Reviewrepo;

@Service
public class ReviewService {
    @Autowired 
    Reviewrepo reviewRepo;

    // Get all reviews
    public List<ReviewEntity> getAllReviews() {
        return reviewRepo.findAll();
    }

    // Post a new review
    public ReviewEntity addReview(ReviewEntity review) {
        return reviewRepo.save(review);
    }

    // Delete a review
    public String deleteReview(int id) {
        if (reviewRepo.existsById(id)) {
            reviewRepo.deleteById(id);
            return "Deleted successfully!";
        } else {
            return "Review not found: " + id;
        }
    }

    // Update a review
    public ReviewEntity updateReview(ReviewEntity review, int id) {
        if (reviewRepo.existsById(id)) {
            ReviewEntity obj = reviewRepo.findById(id).get();
            obj.setContent(review.getContent());
            obj.setTimestamp(review.getTimestamp());
            obj.setProduct(review.getProduct());
            return reviewRepo.save(obj);
        }
        return review;
    }
}