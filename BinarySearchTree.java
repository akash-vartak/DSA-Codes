/* Binary Search Tree->          leftData <= rootData <= rightData
Author: Akash Vartak
 */

import java.io.*;

public class BinarySearchTree
{
    private static node root;
    public static int count;

    public BinarySearchTree()
    {
        root=null;
        count=0;
    }

    public static void main(String args[])throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bst=new BinarySearchTree();
        char con;

        do
        {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Number of data nodes");
            System.out.println("5. Diplay");
            int ch=Integer.parseInt(obj.readLine());

            switch(ch)
            {
                case 1:{
                    System.out.print("Data to enter: ");
                    int x=Integer.parseInt(obj.readLine());
                    bst.insert(x);
                    break;}

                case 2:{
                    System.out.print("Data to delete: ");
                    int x=Integer.parseInt(obj.readLine());
                    bst.delete(x);
                    break;}

                case 3:{
                    System.out.print("Data to search: ");
                    int x=Integer.parseInt(obj.readLine());
                    boolean found=bst.search(x);
                    if(found)
                        System.out.print(x+" available in tree");
                    else
                        System.out.print(x+" not in tree");
                    break;}

                case 4:{
                    System.out.println("Number of nodes="+count);
                    break;}

                case 5:{
                    bst.display();
                    break;}

                default:{
                    System.out.println("INVALID INPUT");
                    break;}
            }

            System.out.print("\n=====continue?? (y/n): ");
            con=(char)obj.read();
            String t=obj.readLine();
        }
        while(con=='y' || con=='Y');
    }

    
    public void insert(int data)
    {
        root=insert(root, data);
        count++;
    }

    public node insert(node x, int n)
    {
        if(x==null)
        {
            x=new node(n);
        }
        else
        {
            if(n < x.data)
            {
                x.left=insert(x.left, n);
            }
            else
            {
                x.right=insert(x.right, n);
            }
        }
        return(x);
    }

    
    public void delete(int x)
    {
        if(count==0)
        {
            System.out.println("Tree is empty.");
        }
        else if(search(x)==false)
        {
            System.out.println(x+" is not in the tree.");
        }
        else
        {
            root=delete(root, x);
            System.out.println(x+" is deleted from the tree.");
            count--;
        }
    }

    public node delete(node r, int x)
    {
        node p, p2, n;
        if(r.data == x)     //delete root
        {
            node lt, rt;
            lt=r.left;
            rt=r.right;

            if(lt==null && rt==null)    //node has no subtrees
            {
                return null;
            }
            else if(lt==null)           //no left subtree
            {
                p=rt;
                return p;
            }
            else if(rt==null)            //no right subtree
            {
                p=lt;
                return p;
            }
            else                        //has both subtrees
            {
                p2=rt;
                p=rt;
                while(p.left!=null)
                {
                    p=p.left;
                }
                p.left=lt;
                return p2;
            }
        }

        if(x < r.data)
        {
            n=delete(r.left, x);
            r.left=n;
        }
        else
        {
            n=delete(r.right, x);
            r.right=n;
        }

        return r;
    }

    
    public boolean search(int val)
    {
        return search(root, val);
    }

    public boolean search(node r, int val)
    {
        boolean found=false;

        while((r!=null) && !found)
        {
            int rval=r.data;
            if(val < rval)
            {
                r=r.left;
            }
            else if(val > rval)
            {
                r=r.right;
            }
            else
            {
                found=true;
                break;
            }
            found=search(r, val);
        }
        return found;
    }

    
    public void display()
    {
        System.out.print("\n-----PREORDER---\n\t");
        preorder();
        System.out.print("\n-----INORDER---\n\t");
        inorder();
        System.out.print("\n-----POSTORDER---\n\t");
        postorder();
    }

    public static void preorder()
    {
        preorder(root);
    }

    public static void preorder(node x)
    {
        if(x!=null)
        {
            System.out.print(x.data+"  ");
            preorder(x.left);
            preorder(x.right);
        }
    }

    public static void inorder()
    {
        inorder(root);
    }

    public static void inorder(node x)
    {
        if(x!=null)
        {
            inorder(x.left);
            System.out.print(x.data+"  ");
            inorder(x.right);
        }
    }

    public static void postorder()
    {
        postorder(root);
    }

    public static void postorder(node x)
    {
        if(x!=null)
        {
            postorder(x.left);
            postorder(x.right);
            System.out.print(x.data+"  ");
        }
    }

    
}

class node
{
    protected node left, right;
    protected int data;
    public node()
    {
        data=0;
        left=right=null;
    }

    public node(int n)
    {
        data=n;
        left=right=null;
    }
}