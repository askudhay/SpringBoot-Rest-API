package com.springboot.ex.Rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.ex.Model.User;
import com.springboot.ex.util.CustomError;
import com.springboot.ex.util.CustomInfo;
/**
 * Rest Controller Class
 * 
 * @author Udhay
 *
 */
@RestController
@RequestMapping(path="/user")
public class RestApiService {
	
	static User staticUser;
	
	/**
	 * Handles GET request (/user/)
	 * 
	 * @return ResponseEntity
	 */
	@RequestMapping(method=RequestMethod.GET, produces={"application/xml", "application/json"})
	public ResponseEntity<?> getUser(){		
		if(staticUser == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(staticUser,HttpStatus.OK);
	}
	
	/**
	 * Handles POST request (/user/save)
	 * 
	 * @param reqUser
	 * @param ucBuilder
	 * @return ResponseEntity
	 */
	@RequestMapping(path="/save", method=RequestMethod.POST, consumes={"application/xml","application/json"})
	public ResponseEntity<?> saveUser(@RequestBody User reqUser, UriComponentsBuilder ucBuilder){
		
		if(staticUser != null){
			return new ResponseEntity<CustomError>(new CustomError("You need to delete User before trying to add."), HttpStatus.CONFLICT);
		}
		
		staticUser = new User();
		staticUser.setUserID(reqUser.getUserID());
		staticUser.setUserName(reqUser.getUserName());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user").buildAndExpand().toUri());
		return new ResponseEntity<CustomInfo>(new CustomInfo("User created !"), headers, HttpStatus.CREATED);		
	}
	
	/**
	 * Handles PUT request (/user/update)
	 * 
	 * @param reqUser
	 * @return ResponseEntity
	 */
	@RequestMapping(path="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User reqUser){
		
		if(staticUser == null){
			return new ResponseEntity<CustomError>(new CustomError("No User Exists"), HttpStatus.NOT_FOUND);
		}
		
		if(staticUser != null && (reqUser.getUserID() != staticUser.getUserID())){
			return new ResponseEntity<CustomError>(new CustomError("User with ID "  + reqUser.getUserID() + " doesn't exist to update!"), HttpStatus.NOT_FOUND);
		}
		
		staticUser.setUserName(reqUser.getUserName());		
		return new ResponseEntity<CustomInfo>(new CustomInfo("User info has been updated !"),HttpStatus.OK);
	}
	
	/**
	 * Handles DELETE request (/user/delete)
	 * 
	 * @param reqUser
	 * @return
	 */
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestBody User reqUser){
		
		if(staticUser == null){
			return new ResponseEntity<CustomError>(new CustomError("No User Exists"), HttpStatus.NOT_FOUND);
		}
		
		if(staticUser != null && (reqUser.getUserID() != staticUser.getUserID())){
			return new ResponseEntity<CustomError>(new CustomError("User with ID "  + reqUser.getUserID() + " doesn't exist to delete !"), HttpStatus.NOT_FOUND);
		}
		
		staticUser = null;	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
