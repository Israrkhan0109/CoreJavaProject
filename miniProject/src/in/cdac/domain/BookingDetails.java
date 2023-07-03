package in.cdac.domain;

import java.time.LocalDateTime;

public class BookingDetails {
    private int bookingId;
    private String userId;
    private String name;
    private String carName;
    private String destination;
    private float distance;
    private LocalDateTime dateTime;
    private double fare;


    public BookingDetails(int bookingId, String str, String name, String carName, String destination, float distance, LocalDateTime dateTime, double total) {
    	 this.bookingId = bookingId;
         this.userId = str;
         this.name=name;
         this.carName=carName;
         this.destination = destination;
         this.distance=distance;
         this.dateTime = dateTime;
         this.fare = total;
	}

    public int getBookingId() {
		return bookingId;
	}

    public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%f,%s,%.2f", bookingId, userId,name,carName, destination,distance, dateTime.toString(), fare);
    }
    
    public static BookingDetails fromString(String line) {
											
        String[] fields = line.split(",");
//fw.write(bookingId+","+storedContactNo+","+storedName+","+selectedCar.getCarName()+","+selectedRide.getDestination()+","+selectedRide.getDistance()+","+dateTime.toString()+","+(float)total+"\n");
//        for (String string : fields) {
//			System.out.println(string);
//		}
        //3264,8850793097,Nashik,2023-04-24T10:28:20.954323,58923.28
        int bookingId = Integer.parseInt(fields[0]);
        String userId =fields[1];
        String name=fields[2];
        String carName=fields[3];
        String destination = fields[4];
        float distance=Float.parseFloat(fields[5]);
        LocalDateTime dateTime= LocalDateTime.parse(fields[6]);
        double fare = Double.parseDouble(fields[7]);
        return new BookingDetails(bookingId,userId,name,carName,destination,distance,dateTime, fare);
    }

}
