//package com.example.Project.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Project.Service.emailService;
//@RestController
//
//public class emailController {
//	@Autowired emailService service;
//	@PostMapping("/smtp")
//	public String generateEmail(@RequestParam String receiver,@RequestParam String subject,@RequestParam String content) {
//		return service.sendEmail(receiver,subject,content);
//		
//	}
//}
package com.example.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Project.Service.emailService;

@RestController
public class emailController {

	@Autowired 
	private emailService service;

	@PostMapping("/smtp")
	public String generateEmail(@RequestParam String receiver, 
	                            @RequestParam String subject, 
	                            @RequestParam String content) {
		return service.sendEmail(receiver, subject, content);
	}
}

