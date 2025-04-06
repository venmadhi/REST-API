package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Project.Entity.ComparisionEntity;
import com.example.Project.Service.ComparisionService;

@RestController
public class ComparisionController {
    
    @Autowired
    private ComparisionService comparisonService;

    @GetMapping("/Comparisonget")
    public List<ComparisionEntity> getAllComparisons() {
        return comparisonService.getAllComparisons();
    }

    @PostMapping("/Comparisonpost")
    public ComparisionEntity addComparison(@RequestBody ComparisionEntity obj) {
        return comparisonService.addComparison(obj);
    }

    @DeleteMapping("/Comparisondelete/{id}")
    public String deleteComparison(@PathVariable int id) {
        return comparisonService.deleteComparison(id);
    }

    @PutMapping("/Comparisonupdate/{id}")
    public ComparisionEntity updateComparison(@PathVariable int id, @RequestBody ComparisionEntity obj) {
        return comparisonService.updateComparison(obj, id);
    }
}

