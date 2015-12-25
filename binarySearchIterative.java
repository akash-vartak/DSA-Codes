/* Binary Search Iteratively
 * Author: Akash Vartak
 */

import java.io.*;
import java.util.*;

public class binarySearchIterative
{
    public static String numbers[], num;
    public static int numarray[], key, len;

    binarySearchIterative()
    {
        numbers = num.split(" ");
        len=numbers.length;
        numarray = new int[len];
        for(int i=0;i<len;i++)
            numarray[i] = Integer.parseInt(numbers[i]);
        Arrays.sort(numarray);
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the numbers seperated by space (example- 1 2 3)");
        num = obj.readLine();

        System.out.print("Enter the number to be searched: ");
        key = Integer.parseInt(obj.readLine());

        binarySearchIterative bsi = new binarySearchIterative();
        len = numarray.length;
        
        bsi.binSearch();
    }
    
    public void binSearch()
    {
        int low=0, high=len-1, mid;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(numarray[mid]==key)
            {
                System.out.println("\n"+key+" found at position "+(mid+1));
                break;
            }
            else if(numarray[mid]<key)
                low=mid+1;
            else if(numarray[mid]>key)
                high=mid;
        }
        if(low>high)
            System.out.println(key+" not in array.");
    }
}