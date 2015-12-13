import java.io.*;
public class NativeStringMatching
{
    public static void main(String args[])throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text String: ");
        String T=obj.readLine();
        System.out.print("Enter pattern String: ");
        String P=obj.readLine();

        stringMatcher(T, P);
    }

    public static void stringMatcher(String T, String P)
    {
        int n=T.length();
        int m=P.length();

        for(int s=0 ; s<=(n-m) ; s++)
        {
            String temp="";
            for(int i=s ; i<(s+m) ; i++)
            {
                temp+=T.charAt(i);
            }
                //System.out.println("T:"+temp+"   P:"+P+"   s:"+s);
            if(temp.equals(P))
            {
                System.out.println("Pattern String occurs with valid shift: "+s);
            }
        }
    }
}
