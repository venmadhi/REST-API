package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Project.Entity.ReviewEntity;
import com.example.Project.Service.ReviewService;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/Reviewget")
    public List<ReviewEntity> get() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/Reviewpost")
    public ReviewEntity post(@RequestBody ReviewEntity obj) {
        return reviewService.addReview(obj);
    }

    @DeleteMapping("/Reviewdelete/{id}")
    public String delete(@PathVariable int id) {
        return reviewService.deleteReview(id);
    }

    @PutMapping("/Reviewupdate/{id}")
    public ReviewEntity update(@PathVariable int id, @RequestBody ReviewEntity obj) {
        return reviewService.updateReview(obj, id);
    }
}






















