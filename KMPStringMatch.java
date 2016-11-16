// String matching algorithm using Knuth Morris Pratt (KMP)Algorithm

import java.io.*;

public class KMPStringMatch
{
    public static void main(String args[])throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text string: ");
        String t=obj.readLine();
        System.out.print("Enter pattern string: ");
        String p=obj.readLine();

        kmp_matcher(t, p);
    }

    public static int[] compute_prefix_array(String P)
    {
        int m=P.length(), k=0;
        int prefixarr[]=new int[m];
        prefixarr[0]=0;

        for(int j=1;j<m;j++)
        {
            while( k>0 && P.charAt(k+1)!=P.charAt(j) )
                k=prefixarr[k];
            if( P.charAt(k+1)==P.charAt(j) )
                k+=1;
            prefixarr[j]=k;
        }

        return prefixarr;
    }

    public static void kmp_matcher(String T, String P)
    {
        int n=T.length(), m=P.length(), j=0;
        int prefix_array[]=new int[m];

        prefix_array=compute_prefix_array(P);
        System.out.print("Prefix array: ");
        for(int x:prefix_array)
            System.out.print(x+" ");
        for(int i=0;i<n;i++)
        {
            while( j>0 && P.charAt(j+1)!=T.charAt(i) )
                j=prefix_array[j];
            if( P.charAt(j+1)==T.charAt(i) )
                j+=1;
            if( j==m )
            {
                System.out.println("Pattern occurs with shift "+(i-m));
                j=prefix_array[j];
            }
        }
    }
}