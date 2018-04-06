package spring.boot.demo.EmployeeRestApi.exception;

/**
 * Custom Exception Class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class EmpNotFoundException extends RuntimeException {

	public EmpNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
