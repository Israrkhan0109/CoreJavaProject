package in.cdac.domain;

public class Car {
	//Fields
	private String carName;
	private String carType;
	private int seatingCapacity;
	private float rate;
	//parameter-less constructor
	public Car() {
		
	}

	//parametrized constructor
	public Car(String carName, String carType, int seatingCapacity,float rate) {
		
		this.carName = carName;
		this.carType = carType;
		this.seatingCapacity = seatingCapacity;
		this.rate=rate;
	}

	

	//Getters and Setters
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	//toString for formatted output
	@Override
	public String toString() {
		return String.format("%-30s%-20s\t%-15d\t%-25.2f",this.carName,this.carType,this.seatingCapacity,this.rate);
	}
	
	
	

}
