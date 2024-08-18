import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner fileContents = FileReader.getFileContents("Challenge3\\input\\input.txt");
        assert fileContents != null;
        int houses = 0;
        int x = 0;
        int y = 0;
        List<Coordinate> delivered = new ArrayList<>();
        delivered.add(new Coordinate(x, y));
        houses++;

        while (fileContents.hasNext()) {
            String directions = fileContents.nextLine();
            for (char direction : directions.toCharArray()) {
                switch (direction) {
                    case '^':
                        y++;
                        break;
                    case 'v':
                        y--;
                        break;
                    case '<':
                        x--;
                        break;
                    case '>':
                        x++;
                        break;
                }
                Coordinate current = new Coordinate(x, y);
                if (!delivered.contains(current)) {
                    houses++;
                }
                delivered.add(current);
            }
        }

        System.out.println("Houses: " + houses);
    }

    private static class Coordinate {

        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Coordinate other = ((Coordinate) obj);
            return x == other.x && y == other.y;
        }
    }

}
