import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str= sc.nextLine();
        if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u')
            str= str.charAt(0) + str.replaceAll("[AEIOUaeiou]", "");
        else
            str= str.replaceAll("[AEIOUaeiou]", "");

        int i;
        for (i=0; i<str.length()-1; i++){

            if(str.charAt(i) != str.charAt(i + 1)){
                System.out.print(str.charAt(i));
            }
        }

        System.out.print(str.charAt(i));
    }
}
