import java.util.*;

public class Main {

    static List<Coordinate> housesSanta = new ArrayList<>();
    static List<Coordinate> housesRobo = new ArrayList<>();
    static int xSanta = 0;
    static int ySanta = 0;
    static int xRobo = 0;
    static int yRobo = 0;

    public static void main(String[] args) {
        Scanner fileContents = FileReader.getFileContents("Challenge3\\input\\input.txt");
        assert fileContents != null;

        List<Coordinate> deliveredSanta = new ArrayList<>();
        List<Coordinate> deliveredRobo = new ArrayList<>();
        Coordinate startSanta = new Coordinate(xSanta, ySanta);
        Coordinate startRobo = new Coordinate(xSanta, ySanta);
        deliveredSanta.add(startSanta);
        deliveredRobo.add(startRobo);
        housesSanta.add(startSanta);
        housesRobo.add(startRobo);

        while (fileContents.hasNext()) {
            String directions = fileContents.nextLine();

            for (int i = 0; i < directions.length(); i++) {
                char character = directions.charAt(i);
//                System.out.println("Evaluating direction '" + character + "' at position " + i);
                if (i % 2 == 0) {
                    countHouses(character, deliveredSanta, true);
                } else {
                    countHouses(character, deliveredRobo, false);
                }
            }
        }

        housesSanta.addAll(housesRobo);
//        System.out.println("Summed " + housesSanta);
        List<Coordinate> finalHouses = housesSanta.stream().distinct().toList();
//        System.out.println("Unique " + finalHouses);
        System.out.println("Houses: " + finalHouses.size());
    }

    private static void countHouses(char direction, List<Coordinate> delivered, boolean isSanta) {
        switch (direction) {
            case '^':
                if (isSanta) {
                    ySanta++;
                } else {
                    yRobo++;
                }
                break;
            case 'v':
                if (isSanta) {
                    ySanta--;
                } else {
                    yRobo--;
                }
                break;
            case '<':
                if (isSanta) {
                    xSanta--;
                } else {
                    xRobo--;
                }
                break;
            case '>':
                if (isSanta) {
                    xSanta++;
                } else {
                    xRobo++;
                }
                break;
        }
        Coordinate current = isSanta ? new Coordinate(xSanta, ySanta) : new Coordinate(xRobo, yRobo);
        if (!delivered.contains(current)) {
            if (isSanta) {
                housesSanta.add(current);
            } else {
                housesRobo.add(current);
            }
        }
        delivered.add(current);
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

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
