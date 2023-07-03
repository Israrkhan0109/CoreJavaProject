package in.cdac.exception;

@SuppressWarnings("serial")
public class CarNotAvailableException extends Exception{
	public CarNotAvailableException(String msg) {
		super(msg);
	}
}
