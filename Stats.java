import java.util.*;
import java.io.*;
//import java.io.File;
///import java.io.IOException;
//import java.util.Scanner;
public class Stats
{
    public static void main(String [] args) throws IOException
    {
        Scanner inGl = new Scanner(new File("stats.dat"));
        while(inGl.hasNextLine())
        {
            String temp = inGl.nextLine();
            Calculate(temp);
        }
        
    }

    public static void Calculate(String toodles)
    {
        int allNums = 0;
        double firstCalc=0;
        String input = toodles;
        Scanner in = new Scanner(input);
        ArrayList<Integer> ints = new ArrayList<Integer>();
        while(in.hasNextInt())
        {
            ints.add(in.nextInt());
            
        }
        for(int obj : ints)
        {
            //System.out.println(obj);
            allNums+=obj;
        }
        //System.out.println("All Nums: " + allNums);
        //System.out.println("Array Size " + ints.size());
        //System.out.println
        double mean = (double)allNums/ints.size();
        //System.out.println("Mean: " + mean);
        double variance=0;
         
        for(int obj: ints)
        {
            firstCalc+=Math.pow((mean-obj),2);
            //System.out.println("FirstCalc: " +firstCalc);
            
        }
        if(firstCalc!=0)
        {
            //System.out.println(firstCalc);
            //System.out.println(ints.size()-1);
            //System.out.println(firstCalc/ints.size()-1);
            variance = (double)firstCalc/(ints.size()-1);
            //System.out.println(variance);
            variance = Math.sqrt(variance);
            //variance*=2;
            //System.out.println(variance);
        }
        
        double negTwoSD = (double)Math.round((mean-variance-variance)*10)/10;
        double negOneSD = (double)Math.round((mean-variance)*10)/10;
        double oneSD = (double)Math.round((mean+variance)*10)/10;
        double twoSD = (double)Math.round((mean+variance+variance)*10)/10;
        mean = (double)Math.round((mean)*10)/10;
        System.out.println(negTwoSD + " " + negOneSD + " " + mean + " " + oneSD + " " + twoSD);
    }
}