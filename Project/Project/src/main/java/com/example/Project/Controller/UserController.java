package com.example.Project.Controller;

import java.util.List;
import org.springframework.data.domain.Page;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.Project.Entity.ReviewEntity;
import com.example.Project.Entity.UserEntity;
import com.example.Project.Service.UserService;

@RestController
public class UserController {
	@Autowired UserService User;
	@GetMapping("/Userget")
	public List<UserEntity> get() {
		return User.Userget();
	}
	@PostMapping("/Userpost")
	public UserEntity post(@RequestBody UserEntity obj) {
		return User.Userpost(obj);
	}
	@DeleteMapping("/Userdelete/{id}")
	public String delete(@PathVariable int id) {
		return User.Userdelete(id);
	}
	@PutMapping("/Userupdate/{id}")
	public UserEntity update(@PathVariable int id, @RequestBody UserEntity obj) {
		return User.Userput(obj, id);
	}
	@GetMapping("/Contain")
    public List<UserEntity> Having(@RequestParam String username)
    {
    	return User.Contain(username);
    }
    @GetMapping("/Containing")
    public List<UserEntity> Containing(@RequestParam String user)
    {
    	return User.Containing(user);
    }
    @GetMapping("/isContains")
    public List<UserEntity> isContains(@RequestParam String user)
    {
    	return User.isContain(user);
    }
    @GetMapping("/startwith")
    public List<UserEntity> Startswith(@RequestParam String user)
    {
    	return User.Startwith(user);
    }
    @GetMapping("/endwith")
    public List<UserEntity> Endswith(@RequestParam String user)
    {
    	return User.Endwith(user);
    } 
    @GetMapping("/notContaining")
    public List<UserEntity> NotContaining(@RequestParam String username)
    {
    	return User.NotHaving(username);
    }
    @GetMapping("/notContains")
    public List<UserEntity> NotContain(@RequestParam String username)
    {
    	return User.NotContain(username);
    }
 // Get tasks with pagination
 	 @GetMapping("/tasks")
 	 public Page<UserEntity> getTasks(
 			 @RequestParam(defaultValue = "0") int page,
 			 @RequestParam(defaultValue = "10") int size,
 			 @RequestParam(defaultValue = "name") String sortBy, 
 			 @RequestParam(defaultValue = "asc") String direction
 			 )       
 	 {
 		 return User.getAllTasks(page, size, sortBy, direction);
 	 }
 	 

}