package spring.boot.demo.EmployeeRestApi.controller;

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

import spring.boot.demo.EmployeeRestApi.domain.Employee;
import spring.boot.demo.EmployeeRestApi.exception.EmpAlreadyExists;
import spring.boot.demo.EmployeeRestApi.exception.EmpNotFoundException;
import spring.boot.demo.EmployeeRestApi.exception.ExceptionResponse;
import spring.boot.demo.EmployeeRestApi.exception.NoEmpFoundException;
import spring.boot.demo.EmployeeRestApi.repository.EmployeeRepository;
import spring.boot.demo.EmployeeRestApi.utl.CustomInfo;

/**
 * 
 * REST Controller Class
 * @author Udhay
 *
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository empRepo;
	
	/**
	 * GET method to get all employees
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="Get all employees")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response=Employee[].class),
            @ApiResponse(code = 204, message = "No Content."),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@GetMapping (value = "/", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> getAllEmployees() throws Exception{
		List<Employee> empList = empRepo.findAll();
		if(empList.isEmpty()){			
			throw new NoEmpFoundException("No Employee Exists in the system");			 
		}
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}

	/**
	 * GET method to return Employee based on ID
	 * 
	 * @param reqEID
	 * @return
	 */
	@ApiOperation(value="Get Employee based on ID", response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response=Employee.class),
            @ApiResponse(code = 404, message = "No Content."),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@GetMapping (value="/{eId}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> getEmployeeByID(@PathVariable("eId") long reqEID){
		Employee emp = empRepo.findEmployeeByEmpID(reqEID);
		if(emp == null){
			throw new EmpNotFoundException("No Employee Exists for the eID " + reqEID + " you sent");
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
 
	/**
	 * POST method to save Employee to the system
	 * 
	 * @param reqEmp
	 * @return
	 */
	@ApiOperation(value="Add Employee to the System")	
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee created", response=CustomInfo.class),
            @ApiResponse(code = 409, message = "Employee Already Exists", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@PostMapping(value = "/", consumes={"application/xml","application/json"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<?> saveEmployee(@RequestBody final Employee reqEmp){
		
		Employee emp = empRepo.findEmployeeByEmpID(reqEmp.getEmpID());
		if(emp != null){
			throw new EmpAlreadyExists("Employee Already Exists with ID " + reqEmp.getEmpID() +" !");
		}
		
		empRepo.save(reqEmp);
		return new ResponseEntity<CustomInfo>(new CustomInfo("Employee has been created !"), HttpStatus.CREATED);	
	}

	/**
	 * PUT method to handle Update part of CRUD operation
	 * 
	 * @param reqEmp
	 * @param reqEID
	 * @return
	 */
	@ApiOperation(value="Update Employee present in the System")	
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response=CustomInfo.class),
            @ApiResponse(code = 404, message = "Employee not found.", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@PutMapping(value="/{eId}", consumes={"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<?> updateEmployee(@RequestBody Employee reqEmp, @PathVariable ("eId") long reqEID){
		Employee emp = empRepo.findEmployeeByEmpID(reqEID);
		if(emp == null){
			throw new EmpNotFoundException("No Employee Exists with ID " + reqEID + " to update");
		}
		
		emp.setEmpID(reqEmp.getEmpID());
		emp.setEmpName(reqEmp.getEmpName());
		emp.setEmpSkills(reqEmp.getEmpSkills());
		
		empRepo.save(emp);
		return new ResponseEntity<CustomInfo>(new CustomInfo("Employee has been updated !"), HttpStatus.OK);
	}

	/**
	 * DELETE method to delete single Employee based on ID
	 * 
	 * @param reqEID
	 * @return
	 */
	@ApiOperation(value="Delete Employee based on ID", response=ExceptionResponse.class)	
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response=CustomInfo.class),
            @ApiResponse(code = 404, message = "Employee not found", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@DeleteMapping(value= "/{eId}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> deleteEmployeeByID(@PathVariable ("eId") long reqEID){
		Employee emp = empRepo.findEmployeeByEmpID(reqEID);
		if(emp == null){
			throw new EmpNotFoundException("No Employee Exists with ID " + reqEID +" to delete");
		}
		empRepo.delete(emp);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	/**
	 * DELETE method to delete all Employees
	 * 
	 * @return
	 */
	@ApiOperation(value="Delete All Employees", response=ExceptionResponse.class)	
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "No Employee Exists in the System.", response=ExceptionResponse.class),
            @ApiResponse(code = 204, message = "All Employees deleted.", response=ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Something went wrong at Server end.", response=ExceptionResponse.class)
            })
	@DeleteMapping(value="/", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> deleteAllEmployees() {
		List<Employee> empList = empRepo.findAll();
		if(empList.isEmpty()){	
			throw new EmpNotFoundException ("No Employee Exists to delete");
		}
		empRepo.deleteAll();	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
}
