/* SINGLY LINKED LIST
 * Author: Akash Vartak
 */

import java.util.*;
import java.io.*;
public class SinglyLinkedList
{
    public static node head;
    public static int size=0;

    public static void main(String args[])throws IOException
    {
        SinglyLinkedList isl=new SinglyLinkedList();
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("\n1 Insert at head");
            System.out.println("2 Insert at tail");
            System.out.println("3 Remove at head");
            System.out.println("4 Remove at tail");
            System.out.println("5 Search");
            System.out.println("6 Display");
            switch(sc.nextInt())
            {
                case 1:{System.out.print("Data : ");
                    isl.inshead(sc.nextInt());
                    size++;
                    break;}
                case 2:{System.out.print("Data : ");
                    isl.instail(sc.nextInt());
                    size++;
                    break;}
                case 3:{isl.remhead();
                    break;}
                case 4:{isl.remtail();
                    break;}
                case 5:{
                    System.out.print("Data to search : ");
                    isl.search(sc.nextInt());
                    break;}
                case 6:{isl.display();
                    break;}
                default:System.out.println("INVALID");
            }
            System.out.println("=====continue? (1/0 = Y/N)");
        }while((sc.nextInt())==1);
    }

    public static void inshead(int x)
    {
        node p=new node(x);
        if(head==null)
        {
            head=p;
        }
        else
        {
            p.next=head;
            head=p;
        }
    }

    public static void instail(int x)
    {
        node p=new node(x);
        if(head==null)
        {
            head=p;
        }
        else
        {
            node q;
            q=head;
            while((q.next)!=null)
            {
                q=q.next;
            }
            q.next=p;
        }
    }

    public static void remtail()
    {
        node p;
        p=head;
        int count=1;
        if(size==1)
        {
            head=null;
        }
        if(size==2)
        {
            p.next=null;
        }
        while(p.next!=null)
        {
            p=p.next;
            count++;
            if(count==(size-1))
                break;
        }
        p.next=null;
        size--;
    }

    public static void remhead()
    {
        node p;
        p=head;
        head=p.next;
        size--;
    }
    
    public static void search(int x)
    {
        node q;
        q=head;
        boolean found=false;
        if(head==null)
        {
            System.out.println("List is empty.");
        }
        else
        {
            int c=1;
            while((q.next)!=null)
            {
                if(q.data==x)
                {
                    System.out.println(x+" found at index "+c);
                    found=true;
                    break;
                }
                c++;
                q=q.next;
            }
            c++;
            if(found==false)
            {
                if(q.data==x)
                {
                    System.out.println(x+" found at index "+c);
                    found=true;
                }
                else
                {
                    System.out.println(x+" not in the list");
                }
            }
        }
    }
    
    public static void display()
    {
        node q;
        q=head;
        if(head==null)
        {
            System.out.println("Empty List");
            return;
        }
        if(q.next==null)
        {
            System.out.println(q.data);
            return;
        }
        while(q.next!=null)
        {
            System.out.print(q.data+" -> ");
            q=q.next;
        }
        System.out.println(q.data);

    }
}

class node
{
    public int data;
    public node next;
    public node()
    {
        data=0;
        next=null;
    }

    public node(int x)
    {
        data=x;
        next=null;
    }
}