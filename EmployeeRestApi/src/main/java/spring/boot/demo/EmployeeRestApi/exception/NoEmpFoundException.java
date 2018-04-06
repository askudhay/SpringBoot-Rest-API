package spring.boot.demo.EmployeeRestApi.exception;

/**
 * Custom Exception class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class NoEmpFoundException extends RuntimeException {

	public NoEmpFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
