package in.cdac.Tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.cdac.domain.BookingDetails;
import in.cdac.domain.Car;
import in.cdac.domain.Ride;
import in.cdac.domain.User;
import in.cdac.exception.CarNotAvailableException;
import in.cdac.exception.UserContactNoException;
import in.cdac.exception.UserEmailIsInvalid;
import in.cdac.exception.UserNameIsInvalid;
import in.cdac.exception.UserNotFoundException;
import in.cdac.exception.UserPasswordIsInvalid;

public class UserOperation {
	private static Scanner sc = new Scanner(System.in);
	
	 private static boolean isCarAvailable(Car selectedCar) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("Booking_Details.txt"));
		while(scanner.hasNextLine()) {
			String line=scanner.nextLine();
			//check whether the selected car name is present in booking list or not if present ask user to select another car as the existing one is already booked.
			if(!line.isEmpty())		{
				String[] parts=line.split(",");
				
				String car= parts[3];
				LocalDate date = LocalDate.parse(parts[6].subSequence(0, 10));
				if(car.equals(selectedCar.getCarName()) && LocalDate.now().equals(date))
					return false;
			}
			return true;
		}
			return true;
		}
	 
	 
		private static int generateBookingId() {
		        return (int) (Math.random() * 9000) + 1000;
		    }
	
	
	public static void userRegistration() throws IOException {
		User person =Test.acceptRecord(new User());
				try {
					if(validateUser(person))
					{
						FileWriter fw = new FileWriter("registered_users.txt", true);
					    fw.write(person.getName() + "," + person.getEmailId() + "," + person.getPhoneNumber() + ","+person.getPassword() + "\n");
					    fw.close();
					    System.out.println("Registration successful!");
					    return;
					}
				} catch (UserNameIsInvalid | UserContactNoException | UserEmailIsInvalid | UserPasswordIsInvalid
						| IOException e) {
					System.err.println(e.getMessage());
				}
				System.out.println("User details invalid Please register again!!");
	}
      
	
	
	
	private static boolean validateUser(User person) throws UserNameIsInvalid, UserContactNoException, UserEmailIsInvalid, UserPasswordIsInvalid {
			if(!isNameValid(person.getName())) {
				throw new UserNameIsInvalid("User name should contain only alphabets, and minimum 5 characters.");
			}
			if(!isContactNoValid(person.getPhoneNumber())) {
				throw new UserContactNoException("Please check contact no. and enter 10 digit number.");
			}
			if(!isEmailIDValid(person.getEmailId())) {
				throw new UserEmailIsInvalid("Email is invalid.");
			}
			if(!isPasswordValid(person.getPassword())) {
				throw new UserPasswordIsInvalid("Password is invalid. It should contain 8 character, 1 capital 1 digit 1 small case 1 special character.  ");
			}
		
		return true;
	}


	private static boolean isPasswordValid(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&!+=])"
                + "(?=\\S+$).{8,20}$";

			 // Compile the ReGex
			 Pattern p = Pattern.compile(regex);
			
			 // If the password is empty
			 // return false
			 if (password == null) {
			     return false;
			 }
			
			 // Pattern class contains matcher() method
			 // to find matching between given password
			 // and regular expression.
			 Matcher m = p.matcher(password);
			
			 // Return if the password
			 // matched the ReGex
			 return m.matches();
	}


	private static boolean isEmailIDValid(String emailId) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(emailRegex);
		if (emailId == null)
			return false;
		return pat.matcher(emailId).matches();
	}


	private static boolean isContactNoValid(String phoneNumber) {
		//(0/91): number starts with (0/91)  
		//[7-9]: starting of the number may contain a digit between 0 to 9  
		//[0-9]: then contains digits 0 to 9  
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		//the matcher() method creates a matcher that will match the given input against this pattern  
		Matcher match = ptrn.matcher(phoneNumber);  
		//returns a boolean value  
		return match.matches(); //(match.find() && match.group().equals(phoneNumber)); 
	}


	private static boolean isNameValid(String name) {
		 String regex = "^[A-Za-z]+[ A-Za-z]+{5,29}$";
	        Pattern p = Pattern.compile(regex);
	  
	        // If the username is empty
	        // return false
	        if (name == null) {
	            return false;
	        }
	  
	        // Pattern class contains matcher() method
	        // to find matching between given username
	        // and regular expression.
	        Matcher m = p.matcher(name);
	  
	        // Return if the username
	        // matched the ReGex
	        return m.matches();
	}


	public static String userLogin() throws FileNotFoundException, UserNotFoundException {
		System.out.println("Enter your contact number : ");
		String contactNo=sc.nextLine();
		System.out.println("Enter your password ");
		String password=sc.nextLine();
		
		Scanner scanner = new Scanner(new File("registered_users.txt"));
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            String[] parts = line.split(",");
            String storedContactNo = parts[2];
            String storedPassword = parts[3];
            
            if (contactNo.equals(storedContactNo) && password.equals(storedPassword)) {
				
                System.out.println("\t\tLogin successful! ");
                System.out.println("\n----------------------------------------------------------------\n");
                System.out.println("\t\tWelcome to HI Tours and Travels\n\t\tOur Motto is your convinient travelling\n");
                System.out.println("----------------------------------------------------------------\n");
                return contactNo;
            }
        }
		throw new UserNotFoundException("User name or password is in correct, Please check and try again!! ");
	}
	
	
	public static void showRecord(String str) throws FileNotFoundException, UserNotFoundException {
		if(str!=null) {
			Scanner scanner = new Scanner(new File("registered_users.txt")); 
			while (scanner.hasNextLine()) {
		            String line = scanner.nextLine();
		            
		            String[] parts = line.split(",");
		            String storedName = parts[0];
		            String storedEmailId = parts[1];
		            String storedContactNo = parts[2];
		            
		            if(str.equals(storedContactNo) ) {
		            	System.out.println("Name : "+storedName+"\nEmail Id : "+storedEmailId+"\nContact Number : "+storedContactNo);
		            	return;
		            }
			}
		}
		throw new UserNotFoundException("Please Login again!!");
	}
	
	public static void showRide() {
		 Ride []ride=Test.rideOptions();
		 System.out.printf("%s          %-20s%-20s%-12s\n","Sr.No.","Source","Destination","Distance");
		for(int index = 0;index<ride.length;index++) {
			System.out.println((index+1)+"               "+ride[index]);
		}
	}
	
	public static void bookRide(String str) throws IOException, UserNotFoundException {
		if(str.isEmpty()) {
			throw new UserNotFoundException("Please Login first!!");
		}
		System.out.println("----------------------------------------------------------------\n\t\tSelect the ride from below\n----------------------------------------------------------------");
		Ride []ride=Test.rideOptions();
		System.out.printf("%s          %-20s%-20s%-12s\n","Sr.No.","Source","Destination","Distance");
		for(int index = 0;index<ride.length;index++) {
			System.out.println((index+1)+"               "+ride[index]);
		}
		System.out.print("\nEnter your ride option : ");
		int option=sc.nextInt();
		Ride selectedRide=ride[option-1];
		System.out.println("----------------------------------------------------------------\n\t\tSelect the car from below\n----------------------------------------------------------------");
		
		Car[] cars=Test.carDetails();
		System.out.printf("%s          %-30s%-20s%-10s\t%-10s\n","Sr.No.","Car Name","Car Type","Seating capacity","Rate/KM");
		//Format show table 
		for(int index = 0;index<cars.length;index++) {
			System.out.println((index+1)+"               "+cars[index]);
			
		}
		System.out.print("\nEnter your car choice : ");
		int choice =sc.nextInt();
		Car selectedCar=cars[choice-1];
		
		//printf("Estimated fare: $%.2f",);
		
		try {
			if(!isCarAvailable(selectedCar)) {
				throw new CarNotAvailableException("Car is already booked!!");
			}
		
		double gst= ( selectedRide.getDistance() * selectedCar.getRate())*0.18;
		double total= ( selectedRide.getDistance() * selectedCar.getRate()) +gst+50000;
		System.out.printf("Estimated fare: %.2f\n\n",total);
		System.out.print("Would you like to confirm this ride? (y/n) : ");
		
		if(sc.next().equalsIgnoreCase("y")) {
			int bookingId=generateBookingId();
			LocalDateTime dateTime = LocalDateTime.now();
//			public BookingDetails(int bookingId, String str, String destination, LocalDateTime dateTime, double total) {
		       
			Scanner scanner = new Scanner(new File("registered_users.txt"));
	        
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            
	            String[] parts = line.split(",");
	            String storedContactNo = parts[2];
	            String storedName = parts[0];
	          
	            if (str.equals(storedContactNo)) {
	            	FileWriter fw = new FileWriter("Booking_Details.txt", true);
	            	//6286,48466,hsui,Toyota Innova Crysta,Nashik,166.2,58923.278115234374
	            	BookingDetails booking = new BookingDetails(bookingId, str,storedName,selectedCar.getCarName(), selectedRide.getDestination(),selectedRide.getDistance(), dateTime, total);
	    			
	    	        fw.write(bookingId+","+storedContactNo+","+storedName+","+selectedCar.getCarName()+","+selectedRide.getDestination()+","+selectedRide.getDistance()+","+dateTime.toString()+","+(float)total+"\n");
	    	        fw.close();
	    	        System.out.println("\n----------------------------------------------------------------\n");
	    	        System.out.println("\t\tCab booked successfully!\n");
	    	        System.out.println("----------------------------------------------------------------\n\tyour booking id is :  "+bookingId);
	    	        
	    	        generateInvoice(str,booking);
	            }
	        }
		}
		} catch (CarNotAvailableException e) {
			
			System.err.println("Error : "+e.getMessage());
		}	
	}


	private static void generateInvoice(String str, BookingDetails booking) {
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\t\t\tInvoice\n");
		System.out.println("Booking Id  : "+booking.getBookingId()+"\t\tDate : "+LocalDate.parse(booking.getDateTime().toString().subSequence(0, 10)).format(DateTimeFormatter.ofPattern("dd MMM yy")));
		System.out.println("Customer ID : "+booking.getUserId());//2023-04-24T09:26:47.139131800
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("Mumbai  to  "+booking.getDestination());
		System.out.println("Amount : "+booking.getFare());
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\t\t\tThank You!!!\n");
	}


	public static void feedback(String str) {
		System.out.print("Enter the ID of the booking : ");
       int bookingId=sc.nextInt();
       int rate=0;;
       List<BookingDetails> bookings = CancelBooking.loadBookings();

       // Find the booking with the specified ID
       BookingDetails bookingToFeedback = null;
       for (BookingDetails booking : bookings) {
           if (booking.getBookingId()==bookingId && booking.getUserId().equals(str)) {
        	   System.out.println("Please rate the ride out of 5 start : ");
        	   rate=sc.nextInt();
               bookingToFeedback = booking;
               System.out.println(bookingToFeedback);
               break;
           }
       }

       // If the booking was not found, display an error message and return
       if (bookingToFeedback == null) {
           System.out.println("Booking not found.");
           return;
       }
       try {
    	   FileWriter fw=new FileWriter("Feedback.txt",true);
//    	   9424,48466,Nashik,2023-04-24T08:39:29.396400800,56030.57
//    	   9424,48466,Nashik,4
//    	   fw.write(String.valueOf(bookingToFeedback)+"\n"); 
    	   fw.write(bookingToFeedback.getBookingId()+","+bookingToFeedback.getUserId()+","+bookingToFeedback.getDestination()+","+rate);
           fw.close();
    	   System.out.println("Feedback stored");
       } catch (IOException e) {
           System.out.println("An error occurred while cancelling the booking. Please try again.");
       }
        
	}
}
	


