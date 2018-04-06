package spring.boot.demo.EmployeeRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.demo.EmployeeRestApi.domain.Employee;
/**
 * Employee Repository Interface
 * 
 * @author Udhay
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
 	Employee findEmployeeByEmpID(long empID);
 	
  	/*Not used in REST Controller Class. 
  	 * Given just for the 
  	 * usage of Query Annotation 
   	*/
 	@Query("SELECT t.empSkills FROM Employee t WHERE t.empID = :empID")
 	String [] findEmpSkillsByEmpID(@Param("empID") long empID);
}
