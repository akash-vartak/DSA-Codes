/* Sieve Of Eratosthenes: Prints all primes less than a given 'n' 
Author: Akash Vartak */

import java.io.*;
import java.util.*;
public class SieveOfEratosthenes
{
    public static int n;
    public static boolean prime[];

    public static void main(String args[])throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number limit 'n': ");
        n=Integer.parseInt(obj.readLine());

        prime=new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0]=prime[1]=false;

        SieveOfEratosthenes soe=new SieveOfEratosthenes();
        soe.grid();

        soe.display();
    }

    public void grid()
    {
        for(int i=2;i<n;i++)
        {
            if(prime[i]==true)
                for(int j=2*i;j<n;j+=i)
                {
                    prime[j]=false;
                }
        }
    }

    public void display()
    {
        System.out.println("--- PRIMES BELOW "+n+" ARE ---");
        for(int i=2;i<n;i++)
            if(prime[i]==true)
                System.out.print(i+"  ");
    }
}