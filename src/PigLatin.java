import java.util.Scanner;

/**
 * Created by michelhayman on 6/30/17.
 */
public class PigLatin {

    public static void main(String[] args) {

        String choice = "y";


        while (choice.equalsIgnoreCase("y")) { // while loop to ask to continue

            // 1. display welcome message
            System.out.println("Welcome to the Pig Latin Translator! \n ");

            // 2. prompt for user input
            System.out.println("Enter a line to be translated: ");

            // 3. get user input
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            // 4. translate user input
            // 4.1 convert input to lowercase

            userInput = userInput.toLowerCase();
            String result; //declaring this above if else-
            if (isVowels(userInput)) {// vowels
                result = piggifiedVowels(userInput); // if true goes to piggifiedvowels

            } else { // consonant
                result = piggifiedConsonant(userInput); // if false goes to piggifiedconsonants
            }

            // 5. display result
            System.out.println(result);

            // 6. prompt for user to play again

            System.out.println("Translate another line? (y/n)"); // prompt to play again
            choice = scan.nextLine();
        }

    }

    /* Translate a word using consonant pig latin logic
     */
    public static String piggifiedConsonant(String userInput) {

        String vowels = "aeiou"; // list of vowels
        String result = "";
        int lastChar = 0; // last character before the vowel

        // while the last character before the vowel is less than the length
        //and while there is no vowel in this character

        while ((lastChar < userInput.length()) && !(vowels.contains("" + userInput.charAt(lastChar)))) {
            String bVowel = ""; // this is the string of characters before the vowel
            bVowel = bVowel + userInput.charAt(lastChar); // collects the letters before the vowel
            lastChar++;
            result = userInput.substring(lastChar) + bVowel + "ay";
        }

        return result;
    }

    /* Translates a word using vowel pig latin logic
     */
    public static String piggifiedVowels(String userInput) {

        StringBuffer sbuffer = new StringBuffer(userInput);
        sbuffer.append("way");
        System.out.println(sbuffer);

        return userInput;
    }

    /* This determines if a word starts with a vowel or consonat
     */

    public static boolean isVowels(String userInput) {
        //aeiou
        if (userInput.charAt(0) == 'a' || userInput.charAt(0) == 'e' || userInput.charAt(0) == 'i' || userInput.charAt(0) == 'o' || userInput.charAt(0) == 'u') {
            piggifiedVowels(userInput);
        } else {
            piggifiedConsonant(userInput);
        }
        return false;
    }
}