import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Intersection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        int[] numSet = new int[num1 + num2];

        for(int i=0; i<numSet.length; i++){
            numSet[i] = sc.nextInt();
        }

        ArrayList<Integer> finalList = new ArrayList();

        Arrays.sort(numSet);

        for(int i = 1; i<numSet.length; i++){
            if(numSet[i-1] == numSet[i]){
                finalList.add(numSet[i]);
                i++;
            }
        }

        if(finalList.size() != 0){
            for(int i = 0; i < finalList.size(); i++){
                System.out.print(finalList.get(i) + " ");
            }
        }
        else
        {
            System.out.println("NO INTERSECTIONS");
        }

    }
}
