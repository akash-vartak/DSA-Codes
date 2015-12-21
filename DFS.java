/* Depth First Search using Stack
Author: Akash Vartak
 */

import java.util.*;
import java.io.*;

public class DFS{
    public static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static int vertex;
    public static Set<Integer> printed=new LinkedHashSet();
    public static Map<Integer,List<node>> adjlist=new HashMap();
    public static Stack<Integer> sta=new Stack<>();

    public static void main(String args[])throws IOException
    {
        DFS dfs=new DFS();

        System.out.print("Number of vertices/nodes? : ");
        vertex=Integer.parseInt(obj.readLine());
        char con;

        for(int i=1;i<=vertex;i++)
        {
            adjlist.put(i,new LinkedList());
        }

        do
        {
            System.out.println("1. Insert Edge");
            System.out.println("2. Display Adjacency List");
            System.out.println("3. Display DFA traversal");
            int choice=Integer.parseInt(obj.readLine());
            switch(choice)
            {
                case 1:{
                    dfs.insEdge();
                    break;}
                case 2:{
                    dfs.display();
                    break;}
                case 3:{
                    dfs.dfsdisplay();
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
        System.out.println("Enter second vertex number (v):");
        int v=Integer.parseInt(obj.readLine());
        if(u==v)
        {
            System.out.println("Self Edge not possible!");
            return;
        }
        else
        {
            for(int x=1;x<=vertex;x++)
            {
                if(x==u)
                {
                    List<node> ul = adjlist.get(x);
                    node n=new node(v, false);
                    ul.add(n);
                }
                if(x==v)
                {
                    List<node> vl = adjlist.get(x);
                    node n2=new node(u, false);
                    vl.add(n2);
                }
            }
        }
    }

    public static void display()
    {
        for(int i=1;i<=vertex;i++)
        {
            List<node> slist = adjlist.get(i);
            ListIterator<node> n = slist.listIterator();
            System.out.print(i + " --> ");
            while(n.hasNext())
            {
                System.out.print("("+n.next().nodename+")  ");
            }
            System.out.println();
        }
    }

    public void dfsdisplay()throws IOException
    {
        System.out.println("Enter starting vertex");
        int start=Integer.parseInt(obj.readLine());
        sta.push(start);

        while(!sta.isEmpty())
        {
            int n=sta.pop();
            //System.out.print(n+"  ");

            for(int x2:adjlist.keySet())
            {
                List<node> slist = adjlist.get(x2);
                ListIterator<node> n2 = slist.listIterator();
                while(n2.hasNext())
                {
                    node vert=n2.next();
                    if(vert.nodename==n && vert.visited==false)
                    {
                        vert.visited=true;
                        printed.add(n);
                    }
                }
            }

            List<node> slist2 = adjlist.get(n);
            ListIterator<node> n1 = slist2.listIterator();
            while(n1.hasNext())
            {
                node v=n1.next();
                if(v.visited==false)
                    sta.push(v.nodename);
            }
        }
        Iterator i=printed.iterator();
        while(i.hasNext())
            System.out.print(i.next()+" ");
    }
}

class node
{
    boolean visited;
    int nodename, printed;
    public node(int i, boolean n)
    {
        nodename=i;
        visited=n;
        printed=0;
    }
}
