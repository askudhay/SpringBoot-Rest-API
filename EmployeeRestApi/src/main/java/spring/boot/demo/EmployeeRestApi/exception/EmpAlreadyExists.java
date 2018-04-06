package spring.boot.demo.EmployeeRestApi.exception;

/**
 * Custom Exception Class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class EmpAlreadyExists extends RuntimeException {
	public EmpAlreadyExists(String message) {
		super(message);
	}
}
