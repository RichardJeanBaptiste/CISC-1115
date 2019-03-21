package assignment6;
import java.util.*;
import java.io.*;
/*
 * Richard Jean-Baptiste
 * CISC 1115-ETR6 
 */
public class assignment6
{
    public static void main(String[] args)throws IOException
    {
    	/*
    	 * This program prints two sets of arrays to an output file 
    	 * it gets the average of the arrays and finds which values are closest to the average
    	 */
    	
    	
    	
        int size;
        double[] numbers = {};
        PrintWriter outFile = new PrintWriter("output.txt");
        
        Scanner in = new Scanner(System.in);
        System.out.println("enter size");
        size = in.nextInt();

        
        double[] b = Arrays.copyOf(readData(size, numbers), size);
        
        
        
        outFile.println("------------------------------------\nHere is the original Array\n");
        outFile.println(printArray(size, b));
        
        
        
        double avg = findAverage(size, b);
        outFile.printf("\n\navg = %.2f\n", avg);
        outFile.printf(highAndLow(b, avg));
        
        
        double[] second = Arrays.copyOf(howFarAway(size, avg, b), size);
        
        outFile.println("\n------------------------------------\nHere is the second Array\n");
        outFile.println(printArray(size, second));
        
        double avg2 = findAverage(size, second);
        
        outFile.println("\navg = " + avg2);
        outFile.printf(highAndLow(second, avg2));
       
        outFile.close();
        in.close();
           
    }
    
    public static double[] readData(int n , double[] numbers)throws IOException
    {
        
        numbers = new double[50];

        File file = null;
        Scanner infile = null;

        file = new File("test.txt");
        infile = new Scanner(file);
        
        int index = 0;
        while(infile.hasNextLine() && index != n)
        {
            numbers[index] = infile.nextDouble();
            index++;    
        }
    
        infile.close();
        
        return numbers;

    }
    // print a given array making 5 columns each 
    public static String printArray(int q, double[] numb)
    {
    	
        int index = -1;
        String s = "";
        
        
        for(int i = 0; i < q; i++)
        {
            index++;
            double x = numb[i];
            
            if(index == 5)
            {
                
                s += String.format("\n%.2f ", x);
                index = 0;
            }
            else
            {
                
            	s += String.format("%.2f ", x);
            }
        }

        	return s;
    }
    // find the average of an array of numbers
    public static double findAverage(int k, double[] p)
    {
    	/*
    	 * loop through the array k times
    	 * add all the values to sum
    	 * divide k
    	 */
    	
    	
    	double sum = 0;
    	double average;
    	
    	
    	for(int i = 0; i <= k - 1; i++)
    	{
    		sum += p[i];
    	}
    	
    	average = sum / k;
    	
    	return average;
    }
    
    public static double[] howFarAway(int m, double avg, double[] r)
    {
    	/*
    	 * loop through all the values in r 
    	 * subtract avg
    	 * add result to new array 
    	 * return array
    	 */
    	double[] s = new double[50];
    	
    	for(int i = 0; i < r.length; i++)
    	{
    		s[i] = r[i] - avg ;
    	}
    	
    	    	
    	return s;
    }
    // get the values closest and farthest from the average in an array
    public static String highAndLow(double[] x, double avg)
    {
    	
    	double high = 0.0;
    	double low = Double.MAX_VALUE;
    	String s = "";
    	double dist;
    	double highVal = 0;
    	double lowVal = 0;
    	// loop through the array
    	for(int i = 0; i < x.length; i++)
    	{
    		// get the distance between the number and the average
    		dist = Math.abs(x[i] - avg);
    		
    		
    		if(dist > high)
    		{
    			high = dist;
    			highVal = x[i];
    		}
    		
    		if(dist < low)
    		{
    			low = dist;
    			lowVal = x[i];
    		}
    	}
    	
    	s = String.format("The furthest from the average is %.2f - The closest to the average is - %.2f", highVal, lowVal);
    	return s;
    }
  
}


