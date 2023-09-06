
public class InvalidUserException extends RuntimeException{
	/** This is a custom exception to handle the invalid user input.
	 *
	 * @param  String message
	 * */
	InvalidUserException(String message){
		super(message);
	}
}
