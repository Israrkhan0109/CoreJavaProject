package in.cdac.domain;

public class Ride {
	private String source;
	private String destination;
	private float distance;
	
	
	public Ride() {
		
	}


	public Ride(String source, String destination, float distance) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public float getDistance() {
		return distance;
	}


	public void setDistance(float distance) {
		this.distance = distance;
	}


	@Override
	public String toString() {
    return String.format("%-20s%-20s%-10.2f",this.source,this.destination,this.distance);
	}
	
	
	
	
}
