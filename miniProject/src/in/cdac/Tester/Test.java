package in.cdac.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.cdac.domain.Car;
import in.cdac.domain.Ride;
import in.cdac.domain.User;

public class Test {
	List<User> arrList =new ArrayList<>();
		
	public void addUser(User arr) {
		if(arr!=null)
			this.arrList.add (arr);
		/*for (User user : arrList) {
				System.out.println(user);
			}*/
		}
	
	private static Scanner sc = new Scanner(System.in);
	public static User acceptRecord(User user) {
		if(user!=null) {
			System.out.print("Enter Full Name: ");
			user.setName(sc.nextLine());
			System.out.print("Enter Phone Number :	");
			user.setPhoneNumber(sc.nextLine());
			System.out.print("Enter Email Id :	");
			user.setEmailId(sc.nextLine());
			System.out.print("Set Password : ");
			user.setPassword(sc.nextLine());
			Test test = new Test();
			test.addUser(user);
		
		}
		return user;
	}
	
	public static  Car[] carDetails() {
		 Car[] arr=new Car[5] ;
		 arr[0]=new Car("Toyota Fortuner", "SUV", 7,50.50f);
		 arr[1]=new Car("Toyota Innova Crysta", "SUV", 7,45.50f);
		 arr[2]=new Car("Honda City", "Sedan", 5,30.75f);
		 arr[3]=new Car("Mercedes Benz C200", "Compact Sedan", 5,40.75f);
		 arr[4]=new Car("Mercedes Benz S650","Luxury Sedan",4,100.50f);
		 return arr;
	}
	
	 public static Ride[] rideOptions() {
		 Ride[] arr=new Ride[5] ;
		 arr[0]=new Ride("Mumbai","Goa",588.2f);
		 arr[1]=new Ride("Mumbai","Pune",147.8f);
		 arr[2]=new Ride("Mumbai","Nashik",166.2f);
		 arr[3]=new Ride("Mumbai","Lonavala",83.0f);
		 arr[4]=new Ride("Mumbai","Delhi",1441.2f);
		 return arr;
	 }
	
			
}
