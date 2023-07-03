package in.cdac.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import in.cdac.Tester.CancelBooking;
import in.cdac.Tester.PastRidesDetais;
import in.cdac.Tester.UserOperation;
import in.cdac.exception.UserNotFoundException;

enum Menu_List{
	Sign_up,Sign_In,EXIT;
}
public class Program {
	private static Scanner sc = new Scanner (System.in);
	private static Menu_List menuList() {
		System.out.println("1.Sign up");
		System.out.println("2.Sign In");
		System.out.println("3.EXIT");
		return Menu_List.values() [sc.nextInt()-1];
		
	}

static enum Sub_Menu_List{
	 Logout,View_profile, Show_available_rides, Book_ride , Past_rides , Cancel_ride ,  Rate_the_ride;
}
	private static Sub_Menu_List subMenuList() {
		System.out.println("0. Logout.");
		System.out.println("1. View profile.");
		System.out.println("2. Show available rides.");
		System.out.println("3. Book ride.");
		System.out.println("4. Past rides.");
		System.out.println("5. Cancel ride.");
		System.out.println("6. Rate the ride.");
		System.out.print("Option : ");
		return Sub_Menu_List.values()[sc.nextInt()];
	}
	@SuppressWarnings("incomplete-switch")
	public static void main(String[] args) throws IOException {
		Menu_List choice;
		while((choice = Program.menuList())!=Menu_List.EXIT)
		{
				switch(choice) {
				case Sign_up :
					
						UserOperation.userRegistration() ;
						break;
					
				case Sign_In :
					String str;
					try {
						str = UserOperation.userLogin();					 
					if(str!=null) {
						Sub_Menu_List ch;
						while((ch=Program.subMenuList())!=Sub_Menu_List.Logout) {
							switch(ch) {
							case View_profile:
								UserOperation.showRecord(str);
								break;
							case Show_available_rides:
								UserOperation.showRide();
								break;
							case Book_ride:
								UserOperation.bookRide(str);						
								break;
							case Past_rides: PastRidesDetais.bookingHistory(str);
								break;
							case Cancel_ride:CancelBooking.cancelRide(str);
								break;
							case Rate_the_ride: UserOperation.feedback(str);
								break;
								
							}
						}
					}
					} catch (FileNotFoundException | UserNotFoundException e) {
						System.err.println(e.getMessage());
					}
					catch(Exception e) {
						System.err.print("Error : ");
						e.printStackTrace();
					}
					
					}			
		}
		System.out.println("Thank You For Visiting");
	}
	
}
