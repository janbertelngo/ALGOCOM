import java.lang.*;
import java.util.Scanner;

public class FillTheContainer
{
    public static int[] array = null;
    public static int n, m;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[n];

        for(int i = 0; i < n; i++)
        {
            array[i] = sc.nextInt();
        }
        System.out.println(simulate((int) 1e9 + 5));

    }
    public static int simulate(int max)
    {
        int lo = 1, hi = max, mid = 0, ans = 0;
        while(lo <= hi)
        {
            mid = (lo + hi) / 2;

            if (can(mid))
            {
                ans = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return ans;
    }
    public static boolean can(int capacity)
    {
        int currentCapacity = capacity;
        int counter = 1;
        for(int i = 0; i < n; i++)
        {
            if (array[i] > capacity)	// if any vessel is bigger than provided capacity container
            {
                return false;
            }

            if (array[i] <= currentCapacity)	// if any vessel is lesser than provided capacity then using ONE CAPACITY CONTAINER
            {
                currentCapacity -= array[i];	// decrementing capacity
            }
            else
            {
                currentCapacity = capacity - array[i];	// USING NEXT CAPACITY CONTAINER
                counter++;
            }
        }
        if (counter > m)
            return false;
        return true;
    }
}