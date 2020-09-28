import java.util.*;
public class Main 
{
    public static void main (String[] args)
    {
        System.out.println("enter the total no. of elements : ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("enter the elements : ");
        int [] a =new int[n];
        for (int i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
        }
        Main obj = new Main();
        
        obj.sort(a,n);
        
        System.out.println("after sorting : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
    void sort(int a[] , int n)
    {
        // build heap 
        for(int i= (n/2)-1;i>=0;i--)
        {
            heapify(a,n,i);
        }
        // one by one extract an element from heap
        for(int i=n-1;i>0;i--)
        {
            //move current root to end 
            int t=a[0];
            a[0]=a[i];
            a[i]=t;
            //call max heapify 
            heapify(a,i,0);
        }
    }
    void heapify(int a[],int n, int i)
    {
        int larg =i;//initialize largest element
        int l=2*i+1; // left child 
        int r=2*i+2;//right child 
        
        //if left child is greater than the root
        if(l<n&&a[l]>a[larg])
        {
            larg =l;
        }
        //if right child is greater than the root
        if(r<n && a[r]>a[larg])
        {
            larg=r;
        }
        //if larg is not root 
        if(larg!=i)
        {
            int swap= a[i];
            a[i]=a[larg];
            a[larg]=swap;
            //recursively heapify 
            heapify(a,n,larg);
        }
        
    }
}