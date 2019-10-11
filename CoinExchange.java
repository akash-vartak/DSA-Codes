/*Sample demonstration of a greedy algorithm:
 * Problem is to pick the least number of coins to make a total of N from k coins of denomination set, given coins of denominations D1, D2, D3 ... Dk, where always D1=1
 * Denomination system considered for this problem is the binary system: D1=1, D2=2, D3=4, D4=8 ....Dk=2^(k-1)
 * Also, we can reuse the same coin multiple times, considering we have infinite supply of every in coin in a denomination D
 * Example: N=70, k=6.
 * Thus, denomination set D of length k = [1 2 4 8 16 32]
 * Number of coins required = 4
 * Actual coins required: 32, 32, 4, 2
 * 
 * Any denomination set can be used like the standard american denomination set (1 cent, 5 cents, 10, 25...), sequential denomination set (1 cent, 2, 3, 4...), etc*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoinExchange
{
	public static void main(String args[])throws IOException
	{
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter N: ");
		int n = Integer.parseInt(obj.readLine());

		System.out.println("Enter k: ");
		int k = Integer.parseInt(obj.readLine());
		
		int d[] = new int[k];
		int base = 2;
		
		System.out.print("Denomination set D generated: [");
		for(int i=0;i<k;i++)
		{
			d[i] = (int) Math.pow(base, i);
			System.out.print("D" + (i+1) + " = " + d[i] + ((i==k-1) ? "]" : ", "));
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		int count=0;
		
		int remainingAmount = n;
		
		int i=d.length-1;
		while(remainingAmount>0)
		{
			if(d[i]<=remainingAmount)
			{
				output.add(d[i]);
				count++;
				remainingAmount = remainingAmount - d[i];
				i=d.length-1;
			}
			else
			{
				i-=1;
			}
		}
		
		System.out.println("\n\nNumber of coins required to make " + n + " : " + count);
		System.out.println("Actual coins required: " + output);
	}
}
