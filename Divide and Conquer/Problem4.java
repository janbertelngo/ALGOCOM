import java.util.Scanner;

public class Problem4 {

    public void printPossibleWords(String strMorse, String strAlpha, int inputSize, String[] code, String[] letters) {
        if (strMorse.length() > 0) {  // still input to process
            if (strAlpha.length() < inputSize) { // String has correct size
                for (int i = 0; i < code.length; i++) { // try all codes
                    if (strMorse.startsWith(code[i])) { // on the beginning of the given string
                        printPossibleWords(strMorse.substring(code[i].length()), strAlpha + letters[i], inputSize, code, letters);
                    }
                }
            }
        }
        else{
            System.out.println(strAlpha);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] letters = {
                "A",    // A
                "B",    // B
                "C",    // C
                "D",    // D
                "E",    // E
                "F",    // F
                "G",    // G
                "H",    // H
                "I",    // I
                "J",    // J
                "K",    // K
                "L",    // L
                "M",    // M
                "N",    // N
                "O",    // O
                "P",    // P
                "Q",    // Q
                "R",    // R
                "S",    // S
                "T",    // T
                "U",    // U
                "V",    // V
                "W",    // W
                "X",    // X
                "Y",    // Y
                "Z"};   // Z

        String[] code = {
                "-",    // A
                "--.",  // B
                ".--",  // C
                "-.-",  // D
                ".",    // E
                "..-",  // F
                "---.", // G
                "..--", // H
                "-.",   // I
                "---",  // J
                "...",  // K
                ".-.",  // L
                ".-.-", // M
                ".-..", // N
                "..",   // O
                ".--.", // P
                "--..", // Q
                ".-..-",// R
                "....-",// S
                "-..--",// T
                "--",   // U
                "-.-..",// V
                "--..-",// W
                ".-.-.",// X
                ".....",// Y
                "-----"};   // Z

        String input = sc.nextLine();

        Problem4 prob4 = new Problem4();

        prob4.printPossibleWords(input, "", input.length() , code, letters);

    }

}
