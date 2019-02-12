import java.util.*;

public class assignment4
{
    
    public static void main(String[] args) 
    {
        
        int firstNum = 0;
        int secondNum = 0;
        int thirdNum = 0;
        int completedSets = 0;
        int nameTotal = 0;
        int largestSum = 0;
        int smallestSum = Integer.MAX_VALUE;
        boolean keepGoing = true;
        
        
        introduction();
  
        Scanner in = new Scanner(System.in);
        
        
        while(keepGoing == true)
        {
        	
            System.out.println("Enter a number - positive, negative, or zero :");
            firstNum = in.nextInt();
            
            secondNum = in.nextInt();
            
            thirdNum = in.nextInt();
            
            // ends program if 1, 2, 3 is entered 
            if(firstNum == 1 && secondNum == 2 && thirdNum == 3)
            {
            	keepGoing = false;
            	break;
            }
           
            
            System.out.printf("The three original integers are - %d, %d, %d \n", firstNum, secondNum, thirdNum);
            System.out.printf("The sum is - %d\n", findsum(firstNum,secondNum,thirdNum));
            
            int result = findsum(firstNum,secondNum,thirdNum);
            int evenNums = howmanyeven(firstNum,secondNum,thirdNum);
            
            printmyname(result);
            
            // get total amount of times name is printed
            if(result <= 0 || result > 10)
            {
            	//do nothing
            }
            else
            {
            	nameTotal += result;
            }
            
            // get the smallest value
            if(result < smallestSum)
            {
            	smallestSum = result;
            }
            
            // get the largest value
           if(result > largestSum)
           {
        	   largestSum = result;
           }
           
           
            
            System.out.printf("There is/are %d even number(s)\n\n", evenNums);
            System.out.println("\n\n");
        	
            completedSets++;
        }
        
        System.out.printf("The largest value was %d\n", largestSum);
        System.out.printf("The smallest value was %d\n",smallestSum);
        System.out.printf("My name was printed %d times\n",nameTotal);
        System.out.printf("There are %d completed sets",completedSets);
        in.close();
        
    }
    
    public static void introduction() 
    {
        System.out.println(" This program will take in three numbers\n It will then get the sum of the larger two numbers.\n Then it will print how many even numbers you entered\n");
        System.out.println(" If you want to exit the program enter 1 , 2 , 3\n");
    }
    
    // takes in the user inputs firstNum , secondNum, and thirdNum
    public static int findsum(int firstNum,int secondNum, int thirdNum)
    {
    	int result;
    	// place values into array and then sort them 
        int[] numSort = {firstNum,secondNum,thirdNum};
        Arrays.sort(numSort);
        // return result of 2nd and 3rd index of array
        result = numSort[1] + numSort[2];
        
        return result;
        
    }
    
    // takes in int x and prints my name x amount of times
    public static void printmyname(int x)
    {
    	if(x <= 0 || x > 10)
    	{
    		System.out.println("It is not possible to print the name");
    	}
    	else
    	{
    		for(int i = 0; i < x; i++)
    		{
    			System.out.println("Richard Jean-Baptiste");
    		}
    	}
    }
    
    // takes in firstNum, secondNum, thirdNum and returns the amount of even numbers
    public static int howmanyeven(int firstNum, int secondNum, int thirdNum)
    {
    	int numEven = 0;
    	int[] numArr = {firstNum, secondNum, thirdNum};
    	Arrays.sort(numArr);
    	
    	for(int i = 0; i < numArr.length; i++)
    	{
    		if(numArr[i] % 2 == 0)
    		{
    			numEven++;
    		}
    	}
    	
    	return numEven;    	
    }
    

}
