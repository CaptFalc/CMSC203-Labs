/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Java Programming
 * Due: 2/09/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Wadi Ahmed
*/
package Assign;

import java.util.Scanner;

public class wifiTroubleshooting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //Declares Scanner variable for input
		String userResp; //Declares string 

		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work."); //Prints statement
		System.out.println("First Step: Reboot your computer and try to connect."); //Prints statement
		System.out.println("Are you able to connect with the internet? (yes or no)"); //Prints statement

		userResp = scanner.nextLine(); //Asks user for input
		if (userResp.equalsIgnoreCase("yes")) //If statement; if the response turns out to this, do this

			System.out.println("Rebooting your computer seemed to work."); //Prints statement

		else if (userResp.equalsIgnoreCase("no")) { //Else if statement, if the if statement is false
			System.out.println("Second Step: Reboot your router"); //Prints statement
			System.out.println("Now are you able to connect to the internet? (yes or no)"); //Prints statement
			userResp = scanner.next(); //Asks user for input
			if (userResp.equalsIgnoreCase("yes")) { //If statement; if the response turns out to this, do this
				System.out.println("Rebooting your router seemed to work.");  //Prints statement
			} else if (userResp.equalsIgnoreCase("no")) {  //Else if statement, if the if statement is false
				System.out.println("Third Step: Make sure the cables are securely fastened to the router."); //Prints statement
				System.out.println("Now are you able to connect to the internet? (yes or no)"); //Prints statement
				userResp = scanner.next(); //Asks user for input
				if (userResp.equalsIgnoreCase("yes")) { //If statement; if the response turns out to this, do this
					System.out.println("Checking your routers cables seemed to work."); //Prints statement
				} else if (userResp.equalsIgnoreCase("no")) { //Else if statement, if the if statement is false
					System.out.println("Fourth Step: Move your computer closer to the router."); //Prints statement
					System.out.println("Now are you able to connect to the internet? (yes or no)"); //Prints statement
					userResp = scanner.next(); //Asks user for input 
					if (userResp.equalsIgnoreCase("yes")) { //If statement; if the response turns out to this, do this
						System.out.println("Bringing your computer closer to the router helped"); //Prints statement
					} else if (userResp.equalsIgnoreCase("no")) {  //Else if statement, if the if statement is false
						System.out.println("Please contact your Internet Service Provider.");  //Prints statement
					}
				}
			}
		}

	}

}
