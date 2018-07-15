import java.util.*;
import java.lang.*;

public class HelpingFillBates
{
    public static void main(String[] args)  {

        ArrayList<ArrayList<Integer>> list;
        Scanner sc=new Scanner(System.in);

        list = new ArrayList<ArrayList<Integer>>();
        String input = sc.nextLine();
        int query = sc.nextInt();
        int len = input.length();

        for (int i = 0; i < 256; ++i)
            list.add(new ArrayList<Integer>());

        for (int i = 0; i < len; ++i)
            list.get(input.charAt(i)).add(i);

        while (query-- > 0) {
            String string = sc.nextLine();
            len = string.length();
            int first_index = 0, last_index = -1;
            boolean isMatched = true;
            for (int i = 0; i < len; ++i) {
                int low = Collections.binarySearch(list.get(string.charAt(i)), last_index+1);
                if (low < -1 || list.get(string.charAt(i)).isEmpty()) {
                    isMatched = false;
                    break;
                }
                if (low == -1) last_index = list.get(string.charAt(i)).get(0);
                else           last_index = list.get(string.charAt(i)).get(low);
                if (i == 0) first_index = last_index;
            }

            if (isMatched)
                System.out.println("Matched " + first_index + " " + last_index);
            else
                System.out.println("Not Matched\n");
        }
    }

}