import java.util.Scanner;

public class MovieDriver extends Movie 
{
	public static void main(String[] args) {	
		String movieTitle, movieRating, tryAgain, useLess; //Declares strings for title and ratings
		int movieTickets; //Declares integer for 
		Scanner movieInput = new Scanner(System.in);
		Movie actionMovie = new Movie();
		boolean repeat = true;
	do
	{
		System.out.println("Please enter the name of a movie.");
		movieTitle = movieInput.nextLine();
		actionMovie.setTitle(movieTitle);
		
		System.out.println("Please enter the rating of the movie.");
		movieRating = movieInput.nextLine();
		actionMovie.setRating(movieRating);
		
		System.out.println("Please enter the number of tickets sold for this movie.");
		movieTickets = movieInput.nextInt();
		actionMovie.setSoldTickets(movieTickets);
		
		System.out.println(actionMovie.toString());
		
		System.out.println("Do you want to enter another movie? (y or n)");
		tryAgain = movieInput.next();
		useLess = movieInput.nextLine();
		
		if (tryAgain.equalsIgnoreCase("n"))
		{
			repeat = false;
			System.out.println("Good Bye!");
		}
		else 
		{
			repeat = true;
			
		}
		
	} while(repeat);

	}
}
