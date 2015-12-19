/* Graph as Adjacency List
Author: Akash Vartak*/

import java.util.*;
import java.io.*;

public class AdjacencyList
{
    public static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static int vertex;
    public static Map<Integer,List<Integer>> adjlist=new HashMap();

    public static void main(String args[])throws IOException
    {
        AdjacencyList adl=new AdjacencyList();

        System.out.print("Number of vertices/nodes? : ");
        vertex=Integer.parseInt(obj.readLine());
        char con;

        for(int i=0;i<vertex;i++)
        {
            adjlist.put(i,new LinkedList());
        }

        do
        {
            System.out.println("\n1. Insert Edge");
            System.out.println("2. Display Graph as Adjacency List");
            int choice=Integer.parseInt(obj.readLine());
            switch(choice)
            {
                case 1:{
                    adl.insEdge();
                    break;}
                case 2:{
                    adl.display();
                    break;}
                default:System.out.println("INVALID INPUT");
                break;
            }
            System.out.println("=====Repeat? (Y/N)");
            con=(char)obj.read();
            String t=obj.readLine();
        }
        while(con=='y' || con=='Y');
    }

    public void insEdge()throws IOException
    {
        System.out.println("Enter first vertex number (u):");
        int u=Integer.parseInt(obj.readLine());
        u=u-1;
        System.out.println("Enter second vertex number (v):");
        int v=Integer.parseInt(obj.readLine());
        v=v-1;
        if(u==v)
        {
            System.out.println("Self Edge not possible!");
            return;
        }
        else
        {
            List<Integer> ul = adjlist.get(u);
            ul.add(v);
            List<Integer> vl = adjlist.get(v);
            vl.add(u);
        }
    }

    public static void display()
    {
        for(int i = 0;i<vertex;i++)
        {
            List<Integer> slist = adjlist.get(i);
            ListIterator<Integer> irt = slist.listIterator();
            System.out.print(i + " --> ");
            while(irt.hasNext())
            {
                System.out.print(irt.next() + " ");
            }
            System.out.println();
        }
    }
}
