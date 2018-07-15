import java.util.Scanner;

public class ClosestPair {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int N = sc.nextInt();

        Point arr [] = new Point [N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Point();
            arr[i].x = sc.nextInt();
            arr[i].y = sc.nextInt();
            arr[i].index = i;
        }

        sortX(arr, 0, arr.length - 1);

        Point[] p = getClosestPoint(arr, 0, N);
        System.out.printf("%d %d %.6f", p[0].index, p[1].index, p[0].distance(p[1]));
    }

    public static Point [] force (Point [] points, int start, int size) {
        Point [] p = new Point [2];

        for (int i = start; i < start + size; i++) {
            for (int j = start; j < start + size; j++) {
                if (i != j && (p[0] == null || points[i].distance(points[j]) < p[0].distance(p[1]))) {
                    p[0] = points[i];
                    p[1] = points[j];
                }
            }
        }
        return p;
    }

    public static Point [] getClosestPoint (Point [] points, int start, int size) {
        if (size <= 3) {
            return force(points, start, size);
        }

        Point [] p1 = getClosestPoint(points, 0, (size) / 2 );
        Point [] p2 = getClosestPoint(points, (size) / 2, size - (size) / 2);

        Point [] p3;

        if (p1[0].distance(p1[1]) < p2[0].distance(p2[1])) {
            p3 = p1;
        } else {
            p3 = p2;
        }


        Point [] temp = new Point[size];

        int j = 0;
        for (int i = start; i < start + size; i++) {
            if (Math.abs(points[i].x - points[(size)/2].x) > p3[0].distance(p3[1])) {
                temp[j] = points[i];
                j++;
            }
        }

        Point [] closest = new Point [j];

        for (int i = 0; i < closest.length; i++) {
            closest[i] = temp[i];
        }


        sortY(closest, 0, closest.length - 1);

        for (int i = 0; i < closest.length; i ++) {
            for (j = i + 1; j <  closest.length && closest[j].y - closest[i].y < p3[0].distance(p3[1]); j++) {
                if (closest[i].distance(closest[j]) < p3[0].distance(p3[1])) {
                    p3[0] = closest[i];
                    p3[1] = closest[j];
                }
            }
        }

        return p3;
    }

    public static void mergeX(Point arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Point L[] = new Point [n1];
        Point R[] = new Point [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].x <= R[j].x)
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeY(Point arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Point L[] = new Point [n1];
        Point R[] = new Point [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].y <= R[j].y)
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sortX(Point arr[], int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortX(arr, l, m);
            sortX(arr , m+1, r);

            // Merge the sorted halves
            mergeX(arr, l, m, r);
        }
    }

    public static void sortY(Point arr[], int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortY(arr, l, m);
            sortY(arr , m+1, r);

            // Merge the sorted halves
            mergeX(arr, l, m, r);
        }
    }


}

class Point {
    int x;
    int y;

    int index;

    double distance (Point a) {
        return Math.sqrt(Math.pow(a.x - this.x, 2) + Math.pow(a.y - this.y, 2));
    }

    public String toString () {
        return x + " " + y + "\n";
    }
}