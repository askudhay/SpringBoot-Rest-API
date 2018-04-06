package spring.boot.demo.EmployeeRestApi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Employee Entity Class
 * @author Udhay
 *
 */
@Entity
public class Employee {
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public String[] getEmpSkills() {
		return empSkills;
	}
	public void setEmpSkills(String[] empSkills) {
		this.empSkills = empSkills;
	}
	
	public Employee(long empID, String empName, String empDesg, Date empDoj,
			String[] empSkills) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empDesg = empDesg;
		this.empSkills = empSkills;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	long empID;
	String empName;
	String empDesg;
	String [] empSkills;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long rowID;
}
