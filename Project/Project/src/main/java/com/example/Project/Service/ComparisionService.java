package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.ComparisionEntity;
import com.example.Project.repo.Comparisionrepo;

@Service
public class ComparisionService {
    
    @Autowired 
    private Comparisionrepo comparisonRepo;

    // Get all comparisons
    public List<ComparisionEntity> getAllComparisons() {
        return comparisonRepo.findAll();
    }

    // Post a new comparison
    public ComparisionEntity addComparison(ComparisionEntity comparison) {
        return comparisonRepo.save(comparison);
    }

    // Delete a comparison
    public String deleteComparison(int id) {
        if (comparisonRepo.existsById(id)) {
            comparisonRepo.deleteById(id);
            return "Deleted successfully!";
        } else {
            return "Comparison not found: " + id;
        }
    }

    // Update a comparison
    public ComparisionEntity updateComparison(ComparisionEntity comparison, int id) {
        if (comparisonRepo.existsById(id)) {
            ComparisionEntity obj = comparisonRepo.findById(id).get();
            obj.setUser(comparison.getUser());
            obj.setProduct(comparison.getProduct());
            obj.setCreatedAt(comparison.getCreatedAt());
            return comparisonRepo.save(obj);
        }
        return comparison;
    }
}
