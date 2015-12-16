/* Representing graphs as Adjacency Matrix
Author: Akash Vartak */

import java.io.*;
public class AdjacencyMatrix
{
    public static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static String vertices[]; //contains vertex names
    public static int matrix[][], vertex;  //matrix is the adjacency matrix, vertex is number of nodes

    public static void main(String args[])throws IOException
    {
        AdjacencyMatrix adm=new AdjacencyMatrix();

        System.out.print("Number of vertices/nodes? : ");
        vertex=Integer.parseInt(obj.readLine());
        char con;

        vertices=new String[vertex];
        matrix=new int[vertex][vertex];

        for(int i=0;i<vertex;i++)
        {
            String temp="V"+(i+1);
            vertices[i]=temp;
            for(int j=0;j<vertex;j++)
                matrix[i][j]=0;
        }

        do
        {
            System.out.println("\n1. Insert Edge");
            System.out.println("2. Display Graph as Adjacency Matrix");
            int choice=Integer.parseInt(obj.readLine());
            switch(choice)
            {
                case 1:{
                    adm.insEdge();
                    break;}
                case 2:{
                    adm.display();
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
            matrix[u-1][v-1]=1;
            matrix[v-1][u-1]=1;
        }
    }

    public void display()
    {
        System.out.print("   ");
        for(int i=0;i<vertex;i++) //printing vertex names in first line
        {
            System.out.print(vertices[i]+" ");
        }
        
        System.out.println();
        for(int i=0;i<vertex;i++) //printing the adjacency matrix
        {
            for(int j=0;j<vertex;j++)
            {
                if(j==0)
                    System.out.print(vertices[i]+" ");
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
