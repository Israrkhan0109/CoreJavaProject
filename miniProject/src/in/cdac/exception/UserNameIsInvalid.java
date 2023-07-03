package in.cdac.exception;

@SuppressWarnings("serial")
public class UserNameIsInvalid extends Exception{
	public UserNameIsInvalid(String msg) {
		super(msg);
	}
}
