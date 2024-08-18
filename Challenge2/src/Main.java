import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner fileContents = FileReader.getFileContents("Challenge2\\input\\input.txt");
        assert fileContents != null;
        List<Integer> sumsWrapping = new ArrayList<>();
        List<Integer> sumsRibbon = new ArrayList<>();
        while (fileContents.hasNext()) {
            String dimensions = fileContents.nextLine();
            List<Integer> dimensionList = new ArrayList<>(Arrays.stream(dimensions.split("x")).map(Integer::parseInt).toList());
            if (dimensionList.size() != 3) {
                System.out.println("Skipping because either no height, width or length: " + dimensionList);
                continue;
            }
            int length = dimensionList.get(0);
            int width = dimensionList.get(1);
            int height = dimensionList.get(2);

            // Wrapping
            int lwSurface = 2 * length * width;
            int whSurface = 2 * width * height;
            int hlSurface = 2 * height * length;
            List<Integer> surfaces = Arrays.asList(lwSurface, whSurface, hlSurface);
            int sumWrapping = surfaces.stream().mapToInt(Integer::intValue).sum() + (Collections.min(surfaces) / 2);
            sumsWrapping.add(sumWrapping);

            // Ribbon
            dimensionList.remove(Collections.max(dimensionList));
            int perimeter = 2 * dimensionList.get(0) + 2 * dimensionList.get(1);
            int volume = length * width * height;
            int sumRibbon = perimeter + volume;
            sumsRibbon.add(sumRibbon);
        }
        System.out.println("Final sum wrapping paper: " + sumsWrapping.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Final sum ribbon paper: " + sumsRibbon.stream().mapToInt(Integer::intValue).sum());
    }

}
