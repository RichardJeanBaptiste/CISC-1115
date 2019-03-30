package assignment3;

/*
 * Richard Jean-Baptiste
 * CISC 1115-ETR6 
 */

import java.util.*;

public class assignment3
{
    public static void main(String[] args)
    {
    	int id , numJudges;
    	boolean keepGoing = true;
    	double avg;
    	
    	int highestId = 0;
    	double highestAvg = 0;
    	
    	int highestScoreId = 0;
    	double highestScore = 0;
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(keepGoing == true)
    	{
    		System.out.println("Enter 666 to quit");
    		
    		System.out.println("\nenter the athlete id num - ");
        	id = sc.nextInt();
        	
        	if(id == 666)
        	{
        		System.out.println("Finished");
        		break;
        	}
        	
        	System.out.println("enter the number of judges - ");
        	numJudges = sc.nextInt();
        	
        	System.out.println("enter the scores - ");
        	double[] scores = new double[numJudges];
        	
        	for(int i = 0; i < numJudges; i++)
        	{
        		scores[i] = sc.nextDouble();
        		//get highest score and id
        		if(scores[i] > highestScore)
        		{
        			highestScoreId = id;
        			highestScore = scores[i];
        		}
        	}
        	
        	
        	avg = getAverage(scores);
        	
        	//get highest avg score / id
        	if(avg > highestAvg)
        	{
        		highestId =  id;
        		highestAvg = avg;
        	}
        	
        	
        	System.out.printf("Athlete %d had %d judges and scored - ", id, numJudges);
        	System.out.println(Arrays.toString(scores));
        	System.out.printf("\nAthlete %d had an average of - %.2f\n", id, avg);
    	}
    	
    	
    	System.out.printf("Athlete - %d had the highest average of %.2f\n", highestId, highestAvg);
    	System.out.printf("Athlete - %d had the highest score of %.1f", highestScoreId, highestScore);
    	
    	sc.close();

    }
    
    public static double getAverage(double[] x)
    {
    	
    	Arrays.sort(x);
    	
    	double avg = 0;
    	
    	for(int i = 0; i < x.length; i++)
    	{
    		if(x[i] == x[0] || x[i] == x[x.length - 1])
    		{
    			// do nothing
    		}
    		else
    		{
    			avg += x[i];
    		}
    	}
    	
    	avg = avg / (x.length - 2);
    	
    	return avg;
    }
    
}
