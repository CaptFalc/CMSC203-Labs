import java.util.Scanner;


public class Assignment2 extends RNG {
	
	public static void main(String[] args)
	{
		int nextGuess, randNum, lowGuess = 0, highGuess = 99;
		boolean tryAgain = false;
		String repeat;
		Scanner ranScan = new Scanner(System.in);
		System.out.println("Enter your first guess between 0 and 100");
		nextGuess = ranScan.nextInt();
		randNum = rand();
		do
		{
		while (randNum != nextGuess)
		{
			if (nextGuess > randNum && nextGuess < highGuess)
			{ 
				highGuess = nextGuess;
				inputValidation(nextGuess, lowGuess, highGuess);
				System.out.println("Your guess is too high");
				System.out.println("Number of guesses is " + getCount());  
			}
			else if (nextGuess < randNum && nextGuess > lowGuess)
			{
				lowGuess = nextGuess;
				inputValidation(nextGuess, lowGuess, highGuess);
				System.out.println("Your guess is too low");
				System.out.println("Number of guesses is " + getCount());
			}
			nextGuess = ranScan.nextInt();
		}
		System.out.println("Congratulations, you guessed correctly!");
		System.out.println("Do you want to play another round? (yes or no?)");
		repeat = ranScan.next();
		if (repeat.equalsIgnoreCase("Yes"))
		{
			RNG.resetCount();
			tryAgain = true;
			System.out.println("Enter your first guess between 0 and 100");
			randNum = rand();
			nextGuess = ranScan.nextInt();
			lowGuess = 0; highGuess = 99;
		}
		else if(repeat.equalsIgnoreCase("no"))
		{
			System.out.println("Thanks for playing!");
			tryAgain = false;
			break;
		}
		} while (true);
		System.out.println("Good Bye!");
	}
	
}