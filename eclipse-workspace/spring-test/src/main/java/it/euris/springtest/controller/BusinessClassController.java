package it.euris.springtest.controller;


import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.euris.springtest.dao.UserDao;
import it.euris.testspringejb.JsonPlaceholderServiceRemote;

@RestController
@RequestMapping("/api")
public class BusinessClassController {
	
	@Autowired
	private JsonPlaceholderServiceRemote jsonPlaceholderService;
	@Autowired
	private UserDao userDao;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/post")
	public String getPost(Principal principal) {
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Integer id = userDao.getId(username);
		String json = null;
		
		try {
			json = jsonPlaceholderService.getPost(id.intValue());
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		if(json == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id " + id.intValue());
		}
		
		return json;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/comments")
	public String getCommenti(Principal principal) {
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Integer id = userDao.getId(username);
		String json = null;
		
		try {
			json = jsonPlaceholderService.getComments(id.intValue());
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		if(json == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comments not found for post with id " + id.intValue());
		}
		
		return json;
	}

}
