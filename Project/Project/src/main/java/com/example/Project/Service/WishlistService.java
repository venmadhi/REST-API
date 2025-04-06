package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.WishlistEntity;
import com.example.Project.repo.Wishlistrepo;

@Service
public class WishlistService {
    @Autowired 
    Wishlistrepo wishlistRepo;

    // Get all wishlists
    public List<WishlistEntity> Wishlistget() {
        return wishlistRepo.findAll();
    }

    // Add a new wishlist
    public WishlistEntity Wishlistpost(WishlistEntity wishlist) {
        return wishlistRepo.save(wishlist);
    }

    // Delete a wishlist by ID
    public String Wishlistdelete(int id) {
        if (wishlistRepo.existsById(id)) {
            wishlistRepo.deleteById(id);
            return "Deleted successfully!";
        } else {
            return "Value not found: " + id;
        }
    }

    // Update wishlist
    public WishlistEntity Wishlistput(WishlistEntity wishlist, int id) {
        if (wishlistRepo.existsById(id)) {
            WishlistEntity obj = wishlistRepo.findById(id).get();
            obj.setWishlistName(wishlist.getWishlistName());
            obj.setUserId(wishlist.getUserId());
            obj.setProductId(wishlist.getProductId());
            return wishlistRepo.save(obj);
        }
        return wishlist;
    }
}
