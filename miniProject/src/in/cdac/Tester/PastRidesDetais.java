package in.cdac.Tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PastRidesDetais {
	public static void bookingHistory(String str) throws FileNotFoundException {
		Scanner scanner =new Scanner(new File("Booking_Details.txt"));
		//fw.write(bookingId+","+storedContactNo+","+storedName+","+selectedCar.getCarName()+","+selectedRide.getDestination()+","+selectedRide.getDistance()+","+dateTime.toString()+","+(float)total+"\n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-10s\t\t %-25s %-25s\n","BookingId","Contact No","Customer Name","Selected Car","Destination","Distance from Mumbai","Date Time","Bill Amount");
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts=line.split(",");
			String uId=parts[1];
			if(uId.equals(str)) {//%-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s
				System.out.printf("%-10s %-20s %-20s %-20s %-20s %-25s %-15s\t %-20s\n",parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7]);
			}
		}
	}
}
