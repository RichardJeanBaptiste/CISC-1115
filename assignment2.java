import java.util.*;

public class assignment2 {
	
	public static void main(String[] args)
	{
			
		double teamId = 0;
		double teamWins = 0;
		double teamLosses = 0;
		double gamesPlayed;
		double bestAvg = 0;
		double bestAvgId = 0;
		double bestAvgComp = 0;
		double bestAvgCompId = 0;
		int processed = 0;
		boolean keepGoing = true;
		
		
		
		Scanner in = new Scanner(System.in);
		
	
		while(keepGoing == true)
		{
			boolean checkInput = false;
			
			// end the program
			if(processed == 8)
			{
				keepGoing = false;
				System.out.printf("There are %d teams in the league\n",processed);
				break;
			}
			
			// get input
			while(checkInput == false)
			{
				
				System.out.println("Id Number : ");
				teamId = in.nextDouble();
				System.out.println("Wins - ");
				teamWins = in.nextDouble();
				System.out.println("Losses - ");
				teamLosses = in.nextDouble();
				
				if(teamWins + teamLosses <= 25)
				{
					checkInput = true;
					break;
				}
				else if(teamWins + teamLosses > 25)
				{
					System.out.println("check input\n");
				}
			
			} 
			
			gamesPlayed = teamWins + teamLosses;
			double gamesRemaining = 25 - gamesPlayed;
			double winAverage = teamWins / gamesPlayed;
			double [] test = ifWinLoss(gamesPlayed,gamesRemaining,teamWins,teamLosses);
			
			System.out.printf("Team - %.0f has %.0f wins and %.0f losses\n", teamId, teamWins, teamLosses);
			System.out.printf("Games Played - %.0f / Games Remaining - %.0f\n", gamesPlayed, gamesRemaining);
			
			// Check if season is finished
			if(gamesPlayed == 25)
			{
				System.out.println("The season is finished\n");
				/*
				 * get win average 
				 * if winAverage is > bestAvgComp 
				 * bestAvgComp = winAverage;
				 */
				
				if(winAverage > bestAvgComp && winAverage != 1)
				{
					bestAvgComp = winAverage;
					bestAvgCompId = teamId;
				}
				
			}
			else
			{
				System.out.printf("There are %.0f games left\n", gamesRemaining);
				System.out.printf("If all remaining games are won the win loss record will be %.0f/%.0f and the average would be %.04f \n", test[0],teamLosses, test[2]);
				System.out.printf("If all remaining games are loss the win loss record will be %.0f/%.0f and the average would be %.04f \n", teamWins,test[1], test[3]);
			}
			
			// winning average
			System.out.printf("The win average is %.04f\n", winAverage);
			/*
			 * if winAverage is greater than bestAvg 
			 * bestAvg = winAverage
			 */
			
			if(winAverage > bestAvg && winAverage != 1)
			{
				bestAvg = winAverage;
				bestAvgId = teamId;
			}
			
			// compare remaining games to games won and lost
			if(gamesRemaining >= teamWins)
			{
				System.out.println("Games remaining is greater/equal to games won");
			}
			else
			{
				System.out.println("Games remaining is less than games won");
			}
			
			if(gamesRemaining >= teamLosses)
			{
				System.out.println("Games remaining is greater than games lost\n\n");
			}
			else
			{
				System.out.println("Games remaining is less than games lost\n\n");
			}
			
			
			processed++;
						
		}
		
		System.out.printf("team - %.0f had the best average of - %.04f\n",bestAvgId,bestAvg);
		System.out.printf("team - %.0f had the best average of completed seasons - %.04f\n",bestAvgCompId,bestAvgComp);
		in.close();		
	}
	
	public static double [] ifWinLoss(double gamesPlayed, double gamesRemaining, double teamWins, double teamLosses)
	{
		/*
		 * games remaining - games played = games left to win
		 * games left to win +  games won = if games won,
		 * if games won / games lost =  if win average 
		 */
		
		
		double ifGamesWon = teamWins + gamesRemaining;
		double ifGamesLost = teamLosses + gamesRemaining;
		double ifWinAverage = ifGamesWon / 25;
		double ifLossAverage =  teamWins / 25;
		double [] ifData = {ifGamesWon, ifGamesLost, ifWinAverage, ifLossAverage};
		
		
		return ifData;
	}
	
}
