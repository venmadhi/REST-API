package com.example.Project.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.UserEntity;
import com.example.Project.repo.Userrepo;
import org.springframework.data.domain.Sort;
@Service
public class UserService {
@Autowired Userrepo Ur;	
	//get
	public List<UserEntity> Userget() {
		return Ur.findAll();
	}
	//post
	public UserEntity Userpost(UserEntity user) {
		return Ur.save(user);
	}

	//delete
	public String Userdelete(int id) {
		if(Ur.existsById(id)) {
			Ur.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	//update
	public UserEntity Userput (UserEntity user,int id) {
		if(Ur.existsById(id)) {
			UserEntity obj=Ur.findById(id).get();
			obj.setName(user.getName());
			obj.setEmail(user.getEmail());
			obj.setPassword(user.getPassword());
			return Ur.save(obj);
		}
       return user;
	}
	public List<UserEntity> Contain(String name){
		return Ur.findByNameContains(name);
	}
	
	public List<UserEntity> isContain(String name){
		return Ur.findByNameIsContaining(name);
	}
	
	public List<UserEntity> Containing(String name) {
		return Ur.findByNameContaining(name);
	}
	
	public List<UserEntity> Startwith(String name){
		return Ur.findByNameStartingWith(name);
	}
	public List<UserEntity> Endwith(String name){
		return Ur.findByNameEndingWith(name);
	}
	
	public List<UserEntity> NotHaving(String name){
		return Ur.findByNameNotContains(name);
	}

	public List<UserEntity> NotContain(String name) {
		return Ur.findByNameNotContaining(name);
	}
	public List<UserEntity> NotLike(String name) {
		return Ur.findByNameNotLike(name);
	}
	public Page<UserEntity> getAllTasks(int page, int size,String sortBy, String direction) {
    	Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
    	Pageable pageable = PageRequest.of(page, size, sort);
        return  Ur.findAll(pageable);
    }

}
