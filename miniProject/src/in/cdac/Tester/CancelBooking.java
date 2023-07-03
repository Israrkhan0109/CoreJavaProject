package in.cdac.Tester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.cdac.domain.BookingDetails;

public class CancelBooking {
	    private static final String BOOKINGS_FILE = "Booking_Details.txt";

	    public static void cancelRide(String userId) {
	        // Check if the user is logged in
	        // Load the bookings from the file
			List<BookingDetails> bookings;
			// Find the booking with the specified ID
			BookingDetails bookingToCancel;
			try {
				if (userId.isEmpty()) {
				    System.err.println("Please login or register to cancel a ride.");
				    return;
				}

				// Prompt the user to enter the ID of the booking to cancel
				System.out.print("Enter the ID of the booking to cancel: ");
				try (Scanner sc = new Scanner(System.in)) {
					int bookingId = sc.nextInt();
					bookings = loadBookings();

					bookingToCancel = null;
					for (BookingDetails booking : bookings) {
					    if (booking.getBookingId() == bookingId && booking.getUserId().equals(userId)) {
					        bookingToCancel = booking;
					        break;
					    }
					}
				}
				// If the booking was not found, display an error message and return
				if (bookingToCancel == null) {
				    System.err.println("Booking not found.");
				    return;
				}

				// Calculate the time difference between the current time and the booking time
				LocalDateTime bookingTime = bookingToCancel.getDateTime();
				LocalDateTime currentTime = LocalDateTime.now();
				long minutesDiff = java.time.Duration.between(currentTime, bookingTime).toMinutes();
				System.out.println("\n----------------------------------------------------------------\n");
				// If the booking has already started, display an error message and return
				if (minutesDiff < -60) {
				    System.err.println("Booking has already started and cannot be cancelled.");
				    return;
				}
			
	        // Remove the booking from the list of bookings
	        bookings.remove(bookingToCancel);
			

	        // Write the updated bookings back to the file
	        
	            Files.write(Paths.get(BOOKINGS_FILE), toLines(bookings));
	            System.out.println("Booking cancelled.");
	        } catch (Exception e) {
				System.err.println("Error : Please check and enter the provided ID properly.");
			}
	    }

	    public static List<BookingDetails> loadBookings() {
	        List<BookingDetails> bookings = new ArrayList<>();

	        try {
	            List<String> lines = Files.readAllLines(Paths.get(BOOKINGS_FILE));
	            for (String line : lines) {
	            	BookingDetails booking = BookingDetails.fromString(line);
	            	if (booking != null) {
	                    bookings.add(booking);
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("An error occurred while loading the bookings.");
	        }

	        return bookings;
	    }

	    public static List<String> toLines(List<BookingDetails> bookings) {
	        List<String> lines = new ArrayList<>();

	        for (BookingDetails booking : bookings) {
	            lines.add(booking.toString());
	        }

	        return lines;
	    }
	    
	}
