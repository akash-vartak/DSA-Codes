import java.io.*;
import java.util.*;

public class PrettyPrintTree
{
    public int data;
    public PrettyPrintTree left;
    public PrettyPrintTree right;
    public PrettyPrintTree parent;

    int depth=0, level=0, drawPosition=0;

    public static void main(String args[])throws IOException
    {
        PrettyPrintTree root=createRandomTree(20);
        root.inorderInt(", ");
        drawTree(root);
    }

    public static int RANDOM_RANGE=0;
    public static PrettyPrintTree createRandomTree(int numNodes)
    {
        RANDOM_RANGE=10*numNodes;

        PrettyPrintTree root=new PrettyPrintTree();
        root.data=(int)(Math.random()*RANDOM_RANGE);

        int treeSize=countNodes(root);
        while(treeSize<numNodes)
        {
            int count=numNodes-treeSize;
            while((count--)>0)
                root.insert((int)(Math.random()*RANDOM_RANGE));
            treeSize=countNodes(root);
        }
        return root;
    }

    public void insert(int d)
    {
        if(this.data==d)
            return;
        else if(this.data<d)
        {
            if(this.right==null)
            {
                this.right=new PrettyPrintTree();
                this.right.data=d;
                this.right.parent=this;
            }
            else
            {
                this.right.insert(d);
            }
        }
        else if(this.data>d)
        {
            if(this.left==null)
            {
                this.left=new PrettyPrintTree();
                this.left.data=d;
                this.left.parent=this;
            }
            else
            {
                this.left.insert(d);
            }
        }
    }

    public static int countNodes(PrettyPrintTree n)
    {
        if(n==null)
            return 0;
        return(1+countNodes(n.left)+countNodes(n.right));
    }

    public void inorderInt(String sep)
    {
        if(left!=null)
            left.inorderInt(sep);
        System.out.print(data+sep);
        if(right!=null)
            right.inorderInt(sep);
    }

    public static int currentDrawLevel=-1, currentSpaceCount=-1;
    public static final int SPREAD=3;
    public static void drawTree(PrettyPrintTree root)
    {
        System.out.println("\n\tLevel order traversal");
        int depth=depth(root);
        setLevels(root,0);
        int depthChildCount[]=new int[depth+1];

        LinkedList<PrettyPrintTree> p=new LinkedList<PrettyPrintTree>();
        p.add(root.left);
        p.add(root.right);

        root.drawPosition=(int)(Math.pow(2, depth-1)*SPREAD);
        currentDrawLevel=root.level;
        currentSpaceCount=root.drawPosition;
        System.out.println(getSpace(root.drawPosition)+root.data);
        while(!p.isEmpty())
        {
            PrettyPrintTree e=p.pollFirst();
            drawElement(e, depthChildCount, depth, p);
            if(e==null)
                continue;
            p.add(e.left);
            p.add(e.right);
        }
        System.out.println();
    }

    public static int depth(PrettyPrintTree n)
    {
        if(n==null)
            return 0;
        n.depth=1+Math.max(depth(n.left), depth(n.right));
        return n.depth;
    }

    public static void setLevels(PrettyPrintTree n, int level)
    {
        if(n==null)
            return;
        n.level=level;
        setLevels(n.left, level+1);
        setLevels(n.right, level+1);
    }

    public static String getSpace(int i)
    {
        String s="";
        while(i>=0)
        {
            s+=" ";
            i--;
        }
        return s;
    }

    public static void drawElement(PrettyPrintTree e, int depthChildCount[], int depth, LinkedList<PrettyPrintTree> p)
    {
        if(e==null)
            return;

        if(e.level!=currentDrawLevel)
        {
            currentDrawLevel=e.level;
            currentSpaceCount=0;
            System.out.println();
            for(int i=0;i<(depth-e.level+1);i++)
            {
                int drawn=0;
                if(e.parent.left!=null)
                {
                    drawn=e.parent.drawPosition-2*i-2;
                    System.out.print(getSpace(drawn)+"/");
                }
                if(e.parent.right!=null)
                {
                    int drawn2=e.parent.drawPosition+2*i+2;
                    System.out.print(getSpace(drawn2-drawn)+"\\");
                    drawn=drawn2;
                }

                PrettyPrintTree doneparent=e.parent;
                for(PrettyPrintTree sibiling:p)
                {
                    if(sibiling==null)
                        continue;
                    if(sibiling.parent==doneparent)
                        continue;
                    doneparent=sibiling.parent;
                    if(sibiling.parent.left!=null)
                    {
                        int drawn2=sibiling.parent.drawPosition-2*i-2;
                        System.out.print(getSpace(drawn2-drawn-1)+"/");
                        drawn=drawn2;
                    }
                    if(sibiling.parent.right!=null)
                    {
                        int drawn2=sibiling.parent.drawPosition+2*i+2;
                        System.out.print(getSpace(drawn2-drawn-1)+"\\");
                        drawn=drawn2;
                    }
                }
                System.out.println();
            }
        }
        
        int offset=0, numdigits=(int)(Math.ceil(Math.log10(e.data)));
        if(e.parent.left==e)
        {
            e.drawPosition=e.parent.drawPosition-SPREAD*(depth-currentDrawLevel+1);
            offset+=numdigits/2;
        }
        else
        {
            e.drawPosition=e.parent.drawPosition+SPREAD*(depth-currentDrawLevel+1);
            offset-=numdigits/2;
        }
        
        System.out.print(getSpace(e.drawPosition-currentSpaceCount+offset)+e.data);
        currentSpaceCount=e.drawPosition+numdigits/2;
    }
}


