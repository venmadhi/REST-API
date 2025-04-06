package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Project.Entity.WishlistEntity;
import com.example.Project.Service.WishlistService;

@RestController
public class WishlistController {
    @Autowired 
    WishlistService wishlistService;

    @GetMapping("/Wishlistget")
    public List<WishlistEntity> get() {
        return wishlistService.Wishlistget();
    }

    @PostMapping("/Wishlistpost")
    public WishlistEntity post(@RequestBody WishlistEntity obj) {
        return wishlistService.Wishlistpost(obj);
    }

    @DeleteMapping("/Wishlistdelete/{id}")
    public String delete(@PathVariable int id) {
        return wishlistService.Wishlistdelete(id);
    }

    @PutMapping("/Wishlistupdate/{id}")
    public WishlistEntity update(@PathVariable int id, @RequestBody WishlistEntity obj) {
        return wishlistService.Wishlistput(obj, id);
    }
}
