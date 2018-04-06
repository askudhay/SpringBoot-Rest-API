package com.springboot.ex.SpringRestJPAExample.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ex.SpringRestJPAExample.Exception.ExceptionResponse;
import com.springboot.ex.SpringRestJPAExample.Exception.NoUserFoundException;
import com.springboot.ex.SpringRestJPAExample.Exception.UserAlreadyExists;
import com.springboot.ex.SpringRestJPAExample.Exception.UserNotFoundException;
import com.springboot.ex.SpringRestJPAExample.Model.User;
import com.springboot.ex.SpringRestJPAExample.Repo.UserRepository;
import com.springboot.ex.SpringRestJPAExample.Util.CustomInfo;

/**
 * Rest Controller Class
 * 
 * @author Udhay
 *
 */
@Api(value="User Rest Controller", description="User Rest Api")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * GET method to return all Users
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="Get all users")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response=User[].class),
            @ApiResponse(code = 204, message = "No Content."),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@GetMapping (value = "/", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> getAllUsers() throws Exception{
		List<User> userList = userRepo.findAll();
		if(userList.isEmpty()){			
			throw new NoUserFoundException("No User Exists in the system");			 
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	/**
	 * GET method to return User based on ID
	 * 
	 * @param reqUserID
	 * @return
	 */
	@ApiOperation(value="Get User based on ID", response=User.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response=User.class),
            @ApiResponse(code = 404, message = "No Content."),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@GetMapping (value="/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> getUserByID(@PathVariable("id") long reqUserID){
		User user = userRepo.findByUserID(reqUserID);
		if(user == null){
			//return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
			throw new UserNotFoundException("No User Exists for the ID " + reqUserID + " you sent");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * POST method to save User to the system
	 * 
	 * @param reqUser
	 * @return
	 */
	@ApiOperation(value="Add User to the System")	
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created", response=CustomInfo.class),
            @ApiResponse(code = 409, message = "User Already Exists", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@PostMapping(value = "/", consumes={"application/xml","application/json"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<?> saveUser(@RequestBody final User reqUser){
		
		User user = userRepo.findByUserID(reqUser.getUserID());
		if(user != null){
			throw new UserAlreadyExists("User Already Exists with ID " + reqUser.getUserID() +" !");
		}
		
		userRepo.save(reqUser);
		return new ResponseEntity<CustomInfo>(new CustomInfo("User has been created !"), HttpStatus.CREATED);	
	}
	
	/**
	 * PUT method to handle Update part of CRUD operation
	 * 
	 * @param reqUser
	 * @param reqUserID
	 * @return
	 */
	@ApiOperation(value="Update User present in the System")	
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response=CustomInfo.class),
            @ApiResponse(code = 404, message = "User not found.", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@PutMapping(value="/{id}", consumes={"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<?> updateUser(@RequestBody User reqUser, @PathVariable ("id") long reqUserID){
		User user = userRepo.findByUserID(reqUserID);
		if(user == null){
			throw new UserNotFoundException ("No User Exists with ID " + reqUserID + " to update");
		}
		
		user.setUserID(reqUser.getUserID());
		user.setUserName(reqUser.getUserName());
		userRepo.save(user);
		return new ResponseEntity<CustomInfo>(new CustomInfo("User has been updated !"), HttpStatus.OK);
	}
	
	/**
	 * DELETE method to delete single user based on ID
	 * 
	 * @param reqUserID
	 * @return
	 */
	@ApiOperation(value="Delete User based on ID", response=ExceptionResponse.class)	
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response=CustomInfo.class),
            @ApiResponse(code = 404, message = "User not found", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@DeleteMapping(value= "/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> deleteUserbyID(@PathVariable ("id") long reqUserID){
		User user = userRepo.findByUserID(reqUserID);
		if(user == null){
			throw new UserNotFoundException ("No User Exists with ID " + reqUserID +" to delete");
		}
		//userRepo.deleteByUserID(reqUserID);
		userRepo.delete(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	/**
	 * DELETE method to delete all users
	 * 
	 * @return
	 */
	@ApiOperation(value="Delete All Users", response=ExceptionResponse.class)	
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "No User Exists in the System.", response=ExceptionResponse.class),
            @ApiResponse(code = 204, message = "All Users deleted.", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@DeleteMapping(value="/", produces = {"application/json", "application/xml"})
	public ResponseEntity<?>  deleteAllUsers(){
		List<User> userList = userRepo.findAll();
		if(userList.isEmpty()){	
			throw new UserNotFoundException ("No User Exists to delete");
		}
		userRepo.deleteAll();	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
}
