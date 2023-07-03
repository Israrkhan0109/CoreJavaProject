package in.cdac.exception;

@SuppressWarnings("serial")
public class UserEmailIsInvalid extends Exception{
	public UserEmailIsInvalid(String msg) {
		super(msg);
	}
}
