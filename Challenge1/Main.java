import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner fileContents = FileReader.getFileContents("Challenge1\\input\\input.txt");
        int position = 0;
        int directionPosition = 0;
        while (fileContents.hasNext()) {
            String directions = fileContents.nextLine();
            for (char c : directions.toCharArray()) {
                switch (c) {
                    case '(':
                        position++;
                        break;
                    case ')':
                        position--;
                        break;
                }
                directionPosition++;
                if (position == -1) {
                    System.out.println("Found -1 at position: " + directionPosition);
                    break;
                }
            }
        }
        System.out.println("Final position: " + position);
    }
}

