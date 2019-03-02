import java.util.*;
import java.io.*;

public class Assignment6
{
    public static void main(String[] args)throws IOException
    {
        int size;
        double[] numbers = {3.0};
        
        Scanner in = new Scanner(System.in);
        System.out.println("enter size");
        size = in.nextInt();


        double[] b = Arrays.copyOf(readData(size, numbers), size);
        
        System.out.println("------------------------------------\nHere is the original Array\n");
        printArray(size, b);

        in.close();
        
        
    }

    public static double[] readData(int n , double[] numbers)throws IOException
    {
        
        numbers = new double[50];

        File file = null;
        Scanner infile = null;

        file = new File("test");
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

    public static void printArray(int q, double[] numb)
    {
        //System.out.println(Arrays.toString(numb));
        /*
            first val
            lines left
            index 

            loop through for loop

            everytime index = 5 make a new and keep printing 
        */
        int index = 0;


        for(int i = 0; i < q; i++)
        {
            index++;
            double x = numb[i];
            
            if(index == 6)
            {
                System.out.println("\n");
                System.out.printf("%.2f ", x);
                index = 0;
            }
            else
            {
                System.out.printf("%.2f ", x);
            }
        }


    }
  
}


    /*        
        Scanner infile = new Scanner(new File("test"));
        ArrayList<Double> fullFile = new ArrayList<Double>();


        while (infile.hasNextLine())
        {
            //if the number == to double and the length of fullFile == to x
            if((infile instanceof Double) && (infile.length() <= x) )
            {
                fullFile.add(infile.nextDouble());
            }    
        }

        //fullFile.forEach(System.out::println);
        infile.close();
        */    
