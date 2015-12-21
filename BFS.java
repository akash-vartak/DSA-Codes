/* Breadth First Search
 * Color scheme used for nodes: WHITE-not traversed; GREY-in queue; BLACK-traversed
 * Author: Akash Vartak
 */

import java.io.*;
import java.util.*;
public class BFS
{
    public static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static int vertex;
    public static Set<Integer> printed=new LinkedHashSet();
    public static Map<Integer,List<node>> adjlist=new HashMap();
    public static LinkedList<Integer> queue=new LinkedList<>();

    public static void main(String args[])throws IOException
    {
        BFS bfs=new BFS();

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
            System.out.println("3. Display BFS traversal");
            int choice=Integer.parseInt(obj.readLine());
            switch(choice)
            {
                case 1:{
                    bfs.insEdge();
                    break;}
                case 2:{
                    bfs.display();
                    break;}
                case 3:{
                    bfs.bfsdisplay();
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
            for(int i:adjlist.keySet())
            {
                if(u==i)
                {
                    List<node> ul=adjlist.get(i);
                    node n=new node(v, "white");
                    ul.add(n);
                }
                if(v==i)
                {
                    List<node> vl=adjlist.get(i);
                    node n=new node(u, "white");
                    vl.add(n);
                }
            }
        }
    }

    public void display()
    {
        for(int i:adjlist.keySet())
        {
            List<node> slist=adjlist.get(i);
            ListIterator<node> l=slist.listIterator();
            System.out.print(i+" --> ");
            while(l.hasNext())
            {
                node vert=l.next();
                System.out.print("("+ vert.nodename +"-"+ vert.color +") ");
            }
            System.out.println();
        }
    }
    
    public static void changeColor(int i, String oldColor, String newColor)
    {
        for(int x2:adjlist.keySet())            /*Chaning inserted node's color to GREY*/
        {
            List<node> slist = adjlist.get(x2);
            ListIterator<node> n2 = slist.listIterator();
            while(n2.hasNext())
            {
                node vert=n2.next();
                if(vert.nodename==i && vert.color.equals(oldColor))
                {
                    vert.color=newColor;
                }
                if(newColor.equals("black"))
                    printed.add(i);
            }
        }
    }

    public void bfsdisplay()throws IOException
    {
        System.out.print("Enter starting vertex: ");
        int start=Integer.parseInt(obj.readLine());
        changeColor(start, "white","grey");
        queue.add(start);

        while(!queue.isEmpty())
        {
            int n=queue.remove();
            changeColor(n, "grey", "black");

            List<node> slist2 = adjlist.get(n);
            ListIterator<node> n1 = slist2.listIterator();
            while(n1.hasNext())
            {
                node v=n1.next();
                if(v.color.equals("white"))             /*Adding only WHITE nodes (not-traversed nodes)*/
                {
                    start=v.nodename;
                    changeColor(start, "white", "grey");
                    queue.add(start);
                }
            }
        }
        
        Iterator i=printed.iterator();
        while(i.hasNext())
            System.out.print(i.next()+" ");
    }
}

class node
{
    String color;
    int nodename;

    public node(int i, String c)
    {
        color=c;
        nodename=i;
    }
}