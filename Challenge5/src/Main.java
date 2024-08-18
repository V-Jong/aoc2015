import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner fileContents = FileReader.getFileContents("Challenge5\\input\\input.txt");
        assert fileContents != null;
        int niceCount = 0;
        while (fileContents.hasNext()) {
            String current = fileContents.nextLine();
            if (!containsIllegal(current) && countVowels(current) >= 3 && countDuplicates(current) >= 1) {
                niceCount++;
            }
        }
        System.out.println("Count: " + niceCount);
    }

    private static int countVowels(String input) {
        int count = 0;
        input = input.toLowerCase();
        String vowels = "aeiou";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }

    private static int countDuplicates(String input) {
        int count = 0;

        // Iterate through the string, starting from the second character
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
                // Skip the next character as we've already counted this pair
                i++;
            }
        }

        return count;
    }

    private static boolean containsIllegal(String input) {
        return input.contains("ab") || input.contains("cd") || input.contains("pq") || input.contains("xy");
    }

}
