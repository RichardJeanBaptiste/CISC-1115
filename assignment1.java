/*
    Richard Jean-Baptiste - 2/7
    CISC 1115-ETR6

*/
public class assignment1 
{
    public static void main(String[] args)
    {
        System.out.println("My Name is Richard Jean-Baptiste");
        System.out.println("This is my first program\n");

        double x;

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        double lowest = Integer.MAX_VALUE;
        double lowestIndex = 0;
    
        for(x = -3 ; x <= 3; x = x + 0.5)
        {

            if(getAnswer(x) > 0)
            {
                //get closest to zero
                if(getAnswer(x) < lowest)
                {
                    lowest = getAnswer(x);
                    lowestIndex = x;
                }

                positiveCount++;
                System.out.printf("X = %.01f    Y = %f   Y is Positive\n", x, getAnswer(x));
            }
            else if (getAnswer(x) < 0)
            {
                // get closest to zero
                if(Math.abs(getAnswer(x)) < lowest )
                {
                    lowest = getAnswer(x);
                    lowestIndex = x;
                }

                negativeCount++;
                System.out.printf("X = %.01f    Y = %f   Y is Negative\n", x, getAnswer(x));
            }
            else if(getAnswer(x) == 0)
            {
                zeroCount++;
                System.out.printf("X = %.01f    Y = %.0f   Y is Zero\n", x, getAnswer(x));
            }
            
        }


        System.out.printf("\nThere are %d positive numbers", positiveCount);
        System.out.printf("\nThere are %d negative numbers", negativeCount);
        System.out.printf("\nThere are %d Zeroes\n", zeroCount);

        System.out.printf("\nValue %.01f gives you the closest value to zero which is %f and that is %.01f away from zero\n", lowestIndex, lowest, lowest);
        
        System.out.println("\nMy first program is complete");
    
        
    }

    public static double getAnswer(double x)
    {
        double answer;
        double top;
        double bottom;
        
        
        top = 4 * Math.pow(x , 3.0) + 8 * Math.pow(x , 2.0) - 31 * x - 35;
        bottom = Math.sqrt( 3 * Math.pow(x , 2.0) +1) + 2 * Math.abs(x - 1.5);

        answer = top / bottom;


        return answer;
    }

}
