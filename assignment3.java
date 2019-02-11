import java.util.*;


public class assignment3
{
    public static void main(String[] args)
    {
        

        HashMap<Integer, double[]> data = new HashMap<>();


        data.put(2365 , new double[]{7, 8.8, 7.4, 6.3, 7.1, 5.6, 7.3, 6.4});
        data.put(2345 , new double[]{6, 8.9, 8.9, 4.5, 4.5, 6.7, 9.2});
        data.put(4356 , new double[]{8, 8.8, 8.8, 5.7, 8.9, 9.4, 2.3, 6.7, 5.9});
        data.put(7865 , new double[]{5, 7.8, 5.3, 2.3, 6.9, 9.8});
        data.put(2319 , new double[]{8, 8.8, 8.8, 8.8, 6.4, 8.8, 8.8, 8.8, 9.4});
        data.put(4508 , new double[]{7, 8.9, 9.4, 2.3, 5.6, 3.4, 9.9, 9.8});
        
        double highestScore = 0;
        int athleteNum = 0;

        // loop through each entry in the hashMap
        for (Map.Entry<Integer, double[]> entry : data.entrySet()) 
        {
            // get the highest score and the athlete number
        	if(getAverage(entry.getValue()) > highestScore)
            {
            	athleteNum = entry.getKey();
            	highestScore = getAverage(entry.getValue());
            };
            
            System.out.println("Athlete - " + entry.getKey() + ", Number of Judges - " + numJudges(entry.getValue()) + ", Scored - " + getAverage(entry.getValue()));
        }
        
        System.out.println("\nAthlete - " + athleteNum + " had the highest score of - " + Math.floor(highestScore * 100) / 100);
        

        
      
    }

    public static double getAverage(double[] x)
    {
        double total = 0;
        
        //remove first element from array
        double[] scores = Arrays.copyOfRange(x, 1, x.length);
        Arrays.sort(scores);
        for(int i = 0; i <= scores.length - 1; i++)
        {
            //if i is equal to the first index or the last index
            if( i == scores[0]-1 || scores[i] == scores[scores.length - 1] )
            {
                //do nothing
            }
            else
            {
                total += scores[i];
                
            }   
        }
        
        total = total / (scores.length - 2);
        total = Math.floor(total * 100) / 100 ;

        
        return total;

    }
    
    
    public static int numJudges(double[] x)
    {
    	
    	double firstIndex = x[0];
    	
    	int numJudges = (int) Math.round(firstIndex);
    	
    	return numJudges;
    	
    }
    
    
}
