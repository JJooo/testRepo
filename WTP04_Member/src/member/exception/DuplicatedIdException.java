package member.exception;

public class DuplicatedIdException extends Exception {
	public DuplicatedIdException(){}
	public DuplicatedIdException(String message){
		super(message);
	}
}
