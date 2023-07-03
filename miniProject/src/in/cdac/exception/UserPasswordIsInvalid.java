package in.cdac.exception;

@SuppressWarnings("serial")
public class UserPasswordIsInvalid extends Exception{
	public UserPasswordIsInvalid(String msg) {
		super(msg);
	}
}
