package assignment5;

/*
	Richard Jean-Baptiste
    CISC 1115-ETR6 
*/
import java.util.*;

public class assignment5 
{
	
	public static void main(String[] args)
	{
		
		int die1 , die2;
		int die3 = 0;
		int die4 = 0;
		int sum;
		String Outcome;
		boolean keepGoing = true;
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 17 & 38 to end program");
		
		while(keepGoing == true)
		{
				System.out.println(" -------------------------------------");
				System.out.println("\nEnter two numbers between 1 - 6 :");
				die1 = in.nextInt();
				die2 = in.nextInt();
				sum = die1 + die2;
			
				
			//Ends program
			if(die1 == 17 && die2 == 38)
			{
				System.out.println("You exited the game");
				keepGoing = false;
				break;
			}
				/* print the first pair of numbers
				 * then print if win /loss or keep playing 
				 */
				System.out.printf("You rolled %d and %d\n",die1,die2);
				Outcome = outcome(die1,die2);
				System.out.println(Outcome);
		
				/* if outcome() returns "\nContinue playing"
				 * go to the second round
				 */
				if(Outcome == "\nContinue playing")
				{
					 boolean keepGoing2 = true;
			
					  while(keepGoing2 == true)
					  {
						  
						die3 = in.nextInt();
						die4 = in.nextInt();
							
						String secondRoll = Continue(sum,die3,die4);
						
						if(secondRoll == "\nKeep playing")
						{
							System.out.printf("You rolled %d , %d",die3,die4);
							System.out.println("\nTry again");
						}
						else
						{
							System.out.println(secondRoll);
							keepGoing2 = false;
						}
						
					  }
				}	
				
		};
		
		
		
		in.close();
		
		
	}
	// takes in two ints (the die rolls) and returns a string 
	public static String outcome(int x, int y)
	{
		String result;
		int sum = x + y;
		
		if(sum == 7 || sum == 11)
		{
			
			result = "You scored " + sum + "\nYou Win!!!!!!!!!!!!!!!";
		}
		else if(sum == 2 || sum == 12)
		{
			result = "You scored " + sum + "\nYou Lose :(";
		}
		else
		{
			result = "\nContinue playing";
			
		}
				
		return result;
	}
	
	//takes in three ints (the sum of first two rolls & the next two rolls) and returns a string 
	public static String Continue(int firstVal, int x, int y)
	{
		
		String result = "";
		int sum = 0;
		sum = x + y;
			if(sum == 7)
			{
				result = "You rolled " + x + " and " + y + "\nYou scored " + sum + "\nYou Lose :(";
			}
			else if(sum == firstVal)
			{
				//result = "\nYou Win!!!!!!!!";
				result = "You rolled " + x + " and " + y + "\nYou scored " + sum + "\nYou Win!!!!!!!";
			}
			else 
			{
				result = "\nKeep playing";
			}
			
		return result;
	}
	
}

